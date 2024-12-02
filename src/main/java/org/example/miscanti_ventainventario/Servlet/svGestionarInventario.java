package org.example.miscanti_ventainventario.Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.miscanti_ventainventario.Logica.Bodega;
import org.example.miscanti_ventainventario.Logica.BodegaManagment;
import org.example.miscanti_ventainventario.Logica.Producto;


@WebServlet("/GestionarInventarioServlet")
public class svGestionarInventario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        Bodega bodega = BodegaManagment.getBodega();

        // Verificar si el parámetro 'codigo' está presente y no está vacío
        String codigoStr = request.getParameter("codigo");
        if (codigoStr == null || codigoStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El código del producto no es válido.");
            return;
        }

        int codigo = Integer.parseInt(codigoStr); // Convertir el código a entero

        switch (accion) {
            case "añadir":
                // Verificar que la cantidad no sea vacía
                String cantidadStr = request.getParameter("cantidad");
                if (cantidadStr == null || cantidadStr.isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "La cantidad no puede estar vacía.");
                    return;
                }
                int cantidadAñadir = Integer.parseInt(cantidadStr);
                bodega.aumentarStock(codigo, cantidadAñadir);
                break;

            case "reducir":
                // Verificar que la cantidad no sea vacía
                String cantidadReducirStr = request.getParameter("cantidad");
                if (cantidadReducirStr == null || cantidadReducirStr.isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "La cantidad no puede estar vacía.");
                    return;
                }
                int cantidadReducir = Integer.parseInt(cantidadReducirStr);
                bodega.reducirStock(codigo, cantidadReducir);
                break;

            case "eliminar":
                bodega.eliminarProducto(codigo);
                break;

            case "añadirProducto":
                String nombre = request.getParameter("nombre");
                String precioStr = request.getParameter("precio");
                if (precioStr == null || precioStr.isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El precio no puede estar vacío.");
                    return;
                }
                int precio = Integer.parseInt(precioStr);

                String cantidadStr2 = request.getParameter("cantidad");
                if (cantidadStr2 == null || cantidadStr2.isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El cantidad no puede estar vacía.");
                    return;
                }
                int cantidad = Integer.parseInt(precioStr);

                String urlImg = request.getParameter("url_img");

                if (nombre == null || nombre.isEmpty() || urlImg == null || urlImg.isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Los campos de nombre y URL de imagen no pueden estar vacíos.");
                    return;
                }

                // Crear el producto con los parámetros del formulario
                Producto nuevoProducto = new Producto(cantidad, codigo, nombre, precio, urlImg);
                bodega.agregarProducto(nuevoProducto);
                break;
        }

        // Redirigir a una página de confirmación o a la lista de inventarios
        response.sendRedirect("manage-inventory.jsp");
    }
}



