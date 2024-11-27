
package org.example.miscanti_ventainventario.Servlet;

import org.example.miscanti_ventainventario.Logica.Usuario;
import org.example.miscanti_ventainventario.Logica.UserManagment;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cambiarContraseña")
public class svCambiarContraseña extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String usuario = request.getParameter("usuario");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Verifica si las contraseñas coinciden
        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("error", "Las contraseñas no coinciden.");
            request.getRequestDispatcher("/cambiar-contraseña.jsp").forward(request, response);
            return;
        }

        // Verifica si el nombre de usuario y la contraseña actual son correctos
        Usuario user = UserManagment.obtenerUsuario(usuario);
        if (user != null && user.getContrasena().equals(oldPassword)) {
            // Cambiar la contraseña
            user.setContrasena(newPassword);
            response.sendRedirect("account.jsp");  // Redirige a una página de perfil o éxito
        } else {
            request.setAttribute("error", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("change-password.jsp").forward(request, response);
        }
    }
}
