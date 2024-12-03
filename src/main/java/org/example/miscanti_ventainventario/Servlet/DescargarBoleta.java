package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.miscanti_ventainventario.Logica.Bodega;
import org.example.miscanti_ventainventario.Logica.BodegaManagment;
import org.example.miscanti_ventainventario.Logica.Boleta;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "DescargarBoleta", urlPatterns = {"/descargarBoleta"})
public class DescargarBoleta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Configura el encabezado para la descarga
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"boleta.pdf\"");

        try (OutputStream os = response.getOutputStream()) {
            // Inicializamos las listas de productos

            List<String> productos = new ArrayList<>();
            int total = 0;
            Bodega bodega = BodegaManagment.getBodega();

            // Iteramos sobre los parámetros de la solicitud
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();

                // Verificamos si el parámetro corresponde a un producto
                if (paramName.startsWith("codigo_")) {
                    // Extraemos el código, nombre, cantidad y precio del producto
                    int codigo = Integer.parseInt(request.getParameter(paramName));
                    String nombre = request.getParameter("nombre_" + codigo);
                    int cantidad = Integer.parseInt(request.getParameter("cantidad_" + codigo));
                    int precio = Integer.parseInt(request.getParameter("precio_" + codigo));
                    int subtotal = cantidad * precio;

                    // Reducir el stock del producto
                    bodega.reducirStock(codigo, cantidad);

                    // Añadir la información del producto a la lista de productos
                    productos.add(nombre + "\t" + cantidad + "\t" + subtotal);
                    total += subtotal;
                }
            }

            // Convertir la lista de productos a un arreglo para pasarla a la generación del PDF
            String[] out = new String[productos.size() + 1];
            productos.toArray(out);

            // Añadir el total de la boleta
            out[out.length - 1] = "Total:\t\t" + total;

            // Generar el contenido del PDF
            String pdfContent = Boleta.print(out);

            // Escribir el contenido del PDF en la respuesta
            os.write(pdfContent.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}