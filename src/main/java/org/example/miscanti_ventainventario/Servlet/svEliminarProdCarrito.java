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
        int codigoProduc = Integer.parseInt(request.getParameter("codigoProducto"));

        // Obtener el carrito de la sesión
        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito != null) {
            // Buscar y eliminar el producto del carrito por código
            carrito.removeIf(producto -> producto.getCodigo() == codigoProduc);
        }

        // Redirigir al carrito actualizado
        response.sendRedirect("carrito.jsp");
    }
}
