package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.DataBase.ProductoJpaController;
import org.example.miscanti_ventainventario.Logica.Producto;
import org.example.miscanti_ventainventario.Logica.Boleta;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;

@WebServlet(name = "DescargarBoleta", urlPatterns = {"/descargarBoleta"})
public class DescargarBoleta extends HttpServlet {

    private final ProductoJpaController productoJpaController = new ProductoJpaController(); // Controlador JPA para productos

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.startsWith("Delete_")) {
                // Extraer código del producto de la acción (e.g., Delete_123 -> 123)
                int codigoProducto = Integer.parseInt(action.split("_")[1]);

                // Obtener el carrito desde la sesión
                HttpSession session = request.getSession();
                List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

                if (carrito != null) {
                    // Eliminar el producto del carrito según el código del producto
                    carrito.removeIf(producto -> producto.getCodigo() == codigoProducto);
                    // Actualizar la sesión con el carrito modificado
                    session.setAttribute("carrito", carrito);
                }

                // Redirigir a la página de carrito
                response.sendRedirect("carrito.jsp");

            } else if ("Pay".equals(action)) {
                // Manejar la lógica de pago aquí (puedes agregar lógica de pago)

                // Generar el PDF para la boleta (factura)
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=\"boleta.pdf\"");

                try (OutputStream os = response.getOutputStream()) {
                    // Obtener los productos del carrito desde la sesión
                    HttpSession session = request.getSession();
                    List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

                    if (carrito != null && !carrito.isEmpty()) {
                        List<String> boletaItems = new ArrayList<>();
                        int total = 0;
                        for (Producto producto : carrito) {
                            // Obtener el producto desde la base de datos para asegurar que la información esté actualizada
                            Producto productoEnDb = productoJpaController.findProducto(producto.getCodigo());
                            if (productoEnDb != null) {
                                int subtotal = producto.getCantidad() * productoEnDb.getPrecio();
                                total += subtotal;
                                // Formatear los datos correctamente
                                var boletaItem = String.format("%-23s %10d %8s %10s", productoEnDb.getNombre(), 
                                                                   producto.getCantidad(), productoEnDb.getPrecio(), subtotal);
                                boletaItems.add(boletaItem);

                                // Actualizar la cantidad de productos en la base de datos después de la compra
                                int nuevaCantidad = productoEnDb.getCantidad() - producto.getCantidad();
                                if (nuevaCantidad >= 0) {
                                    productoEnDb.setCantidad(nuevaCantidad);
                                    productoJpaController.edit(productoEnDb);  // Guardar los cambios en la base de datos
                                } else {
                                    // Si la cantidad no es suficiente, se puede mostrar un mensaje de error
                                    throw new Exception("No hay suficiente stock para el producto: " + productoEnDb.getNombre());
                                }
                            }
                        }

                        // Generar el contenido de la boleta en formato PDF
                        String pdfContent = Boleta.print(boletaItems.toArray(String[]::new), total);

                        // Escribir el contenido de la boleta al flujo de salida del PDF
                        os.write(pdfContent.getBytes());

                        // Vaciar el carrito después de generar la boleta
                        session.setAttribute("carrito", new ArrayList<Producto>());
                    }
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar el pago o generar la boleta.");
                }
            }
        }
    }
}
