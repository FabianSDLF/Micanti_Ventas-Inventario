package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.Logica.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/svAgregarAlCarrito")
public class svAgregarProdCarrito extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        // Verificar si el producto ya existe en el carrito
        boolean productoEncontrado = false;
        for (Producto producto : carrito) {
            if (producto.getCodigo() == codigo) {
                producto.setCantidad(producto.getCantidad() + cantidad);
                productoEncontrado = true;
                break;
            }
        }

        // Si no está en el carrito, agregarlo
        if (!productoEncontrado)
            carrito.add(new Producto(cantidad, codigo, nombre, precio));
        // Guardar el carrito en la sesión
        session.setAttribute("carrito", carrito);
        // Redirigir a la página de productos
        response.sendRedirect("productos.jsp?success=true");
    }
}
