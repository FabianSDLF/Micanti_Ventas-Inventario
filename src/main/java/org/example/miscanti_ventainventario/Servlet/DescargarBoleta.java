package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.Logica.Bodega;
import org.example.miscanti_ventainventario.Logica.BodegaManagment;
import org.example.miscanti_ventainventario.Logica.Boleta;
import org.example.miscanti_ventainventario.Logica.Producto;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "descargarBoleta", urlPatterns = {"/descargarBoleta"})
public class DescargarBoleta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        // Comprobamos si la solicitud es para eliminar un producto
        String eliminarBtn = request.getParameter("eliminarBtn");

        if (eliminarBtn != null) {
            // Si se presionó el botón de eliminar, redirigimos a svEliminarProdCarrito
            int codigoProducto = Integer.parseInt(request.getParameter("codigoProducto"));
            HttpSession session = request.getSession();
            List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

            // Eliminar el producto del carrito
            if (carrito != null) {
                carrito.removeIf(producto -> producto.getCodigo() == codigoProducto);
            }

            // Redirigimos al carrito después de eliminar
            response.sendRedirect("carrito.jsp"); // Cambia esta URL a la correspondiente
        } else {
            // Si no se presionó el botón de eliminar, seguimos con la lógica de pago
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"boleta.pdf\"");

            try (OutputStream os = response.getOutputStream()) {
                // Generar el contenido del PDF
                String nombre = request.getParameter("nombre");
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                int cantidad = Integer.valueOf(request.getParameter("cantidad"));
                int precio = Integer.valueOf(request.getParameter("precio"));
                Bodega bodega = BodegaManagment.getBodega();
                bodega.reducirStock(codigo, cantidad);
                String[] out = new String[2];
                out[0] = nombre + "\t" +  String.valueOf(cantidad) + "\t" +  String.valueOf(cantidad);
                out[1] = String.valueOf(cantidad*precio);
                String pdfContent = Boleta.print(out);

                os.write(pdfContent.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}