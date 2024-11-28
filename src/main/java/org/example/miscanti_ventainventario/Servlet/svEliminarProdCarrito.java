package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.Logica.Producto;

import java.io.IOException;
import java.util.List;

public class svEliminarProdCarrito extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigoProduc = Integer.parseInt(request.getParameter("codigoProducto"));
        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito!=null)
            carrito.removeIf(producto -> producto.getCodigo() == codigoProduc);
        //Redirige al carrito
        response.sendRedirect("carrito.jsp");
    }
}
