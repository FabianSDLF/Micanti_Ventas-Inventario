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
import java.util.List;

@WebServlet(name = "DescargarBoleta", urlPatterns = {"/descargarBoleta"})
public class DescargarBoleta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.startsWith("Delete_")) {
                // Extract product code from the action value (e.g., Delete_123 -> 123)
                int codigoProducto = Integer.parseInt(action.split("_")[1]);

                // Get the cart from the session
                HttpSession session = request.getSession();
                List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

                if (carrito != null) {
                    // Remove the product from the cart based on the product code
                    carrito.removeIf(producto -> producto.getCodigo() == codigoProducto);
                    // Update the session with the modified cart
                    session.setAttribute("carrito", carrito);
                }

                // Redirect to the updated cart page
                response.sendRedirect("carrito.jsp");
            } else if ("Pay".equals(action)) {
                // Handle payment processing logic here

                // Generate the PDF for the boleta (invoice)
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=\"boleta.pdf\"");

                try (OutputStream os = response.getOutputStream()) {
                    // Retrieve all the products in the cart and prepare them for the boleta
                    HttpSession session = request.getSession();
                    List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

                    if (carrito != null && !carrito.isEmpty()) {
                        // Prepare the data for the boleta
                        String[] out = new String[carrito.size()];
                        int index = 0;
                        int total = 0;
                        for (Producto producto : carrito) {
                            int subtotal = producto.getCantidad() * producto.getPrecio();
                            total += subtotal;
                            out[index] = producto.getNombre() + "\t" + producto.getCantidad() + "\t" + subtotal;
                            index++;
                        }

                        // Generate the boleta PDF content
                        String pdfContent = Boleta.print(out);

                        // Write the PDF content to the response output stream
                        os.write(pdfContent.getBytes());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}