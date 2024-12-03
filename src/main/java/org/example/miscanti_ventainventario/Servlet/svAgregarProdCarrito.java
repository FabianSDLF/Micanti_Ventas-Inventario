package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.miscanti_ventainventario.Logica.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AgregarAlCarrito")
public class svAgregarProdCarrito extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener atributos del producto desde el formulario
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String urlImg = request.getParameter("url-img");

        System.out.println(cantidad);
        // Crear el producto
        Producto producto = new Producto(cantidad, codigo, nombre, precio, urlImg);

        // Obtener el carrito de la sesión
        List<Producto> carrito = (List<Producto>) request.getSession().getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        // Añadir el producto al carrito
        carrito.add(producto);

        // Guardar el carrito en la sesión
        request.getSession().setAttribute("carrito", carrito);

        // Redirigir a la página de productos
        response.sendRedirect("productos.jsp");
    }
}
