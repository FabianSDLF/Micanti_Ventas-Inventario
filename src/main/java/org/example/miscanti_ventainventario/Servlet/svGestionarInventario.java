package org.example.miscanti_ventainventario.Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.miscanti_ventainventario.DataBase.ProductoJpaController;
import org.example.miscanti_ventainventario.Logica.Producto;

@WebServlet("/GestionarInventarioServlet")
public class svGestionarInventario extends HttpServlet {

    private ProductoJpaController productoJpaController = new ProductoJpaController(); // Instancia del controlador JPA

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

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
                Producto productoAñadir = productoJpaController.findProducto(codigo);
                if (productoAñadir != null) {
                    // Aumentamos el stock del producto encontrado
                    productoAñadir.setCantidad(productoAñadir.getCantidad() + cantidadAñadir);
                    try {
                        productoJpaController.edit(productoAñadir); // Actualizamos el producto
                    } catch (Exception e) {
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el stock.");
                        return;
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Producto no encontrado.");
                }
                break;

            case "reducir":
                // Verificar que la cantidad no sea vacía
                String cantidadReducirStr = request.getParameter("cantidad");
                if (cantidadReducirStr == null || cantidadReducirStr.isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "La cantidad no puede estar vacía.");
                    return;
                }
                int cantidadReducir = Integer.parseInt(cantidadReducirStr);
                Producto productoReducir = productoJpaController.findProducto(codigo);
                if (productoReducir != null) {
                    // Reducimos el stock del producto encontrado
                    if (productoReducir.getCantidad() >= cantidadReducir) {
                        productoReducir.setCantidad(productoReducir.getCantidad() - cantidadReducir);
                        try {
                            productoJpaController.edit(productoReducir); // Actualizamos el producto
                        } catch (Exception e) {
                            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el stock.");
                            return;
                        }
                    } else {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No hay suficiente stock para reducir.");
                        return;
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Producto no encontrado.");
                }
                break;

            case "eliminar":
                try {
                    productoJpaController.destroy(codigo); // Elimina el producto de la base de datos
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el producto.");
                    return;
                }
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
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "La cantidad no puede estar vacía.");
                    return;
                }
                int cantidad = Integer.parseInt(cantidadStr2);

                // Crear el producto con los parámetros del formulario
                Producto nuevoProducto = new Producto(cantidad, codigo, nombre, precio);
                try {
                    productoJpaController.create(nuevoProducto); // Crear un nuevo producto
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al añadir el producto.");
                    return;
                }
                break;
        }

        // Redirigir a una página de confirmación o a la lista de inventarios
        response.sendRedirect("manage-inventory.jsp");
    }
}
            