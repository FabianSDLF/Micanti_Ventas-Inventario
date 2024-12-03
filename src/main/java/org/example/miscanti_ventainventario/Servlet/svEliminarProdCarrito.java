package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.Logica.Producto;

import java.io.IOException;
import java.util.List;

@WebServlet("/svEliminarProdCarrito")
public class svEliminarProdCarrito extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        int cantidadAReducir = Integer.parseInt(request.getParameter("cantidad"));
        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito != null) {
            Producto productoAEliminar = null;
            // Buscar el producto y reducir la cantidad
            for (Producto producto : carrito) {
                if (producto.getCodigo() == codigo) {
                    producto.setCantidad(producto.getCantidad() - cantidadAReducir);
                    // Marcar para eliminar si la cantidad llega a 0
                    if (producto.getCantidad() <= 0)
                        productoAEliminar = producto;
                    break;
                }
            }
            // Eliminar si la cantidad es 0
            if (productoAEliminar != null)
                carrito.remove(productoAEliminar);
        }
        // Actualizar el carrito en la sesión
        session.setAttribute("carrito", carrito);
        // Redirigir al carrito
        response.sendRedirect("carrito.jsp");
    }
}
