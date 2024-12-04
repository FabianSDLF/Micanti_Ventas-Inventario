package org.example.miscanti_ventainventario.Servlet;

import org.example.miscanti_ventainventario.DataBase.UsuarioJpaController;
import org.example.miscanti_ventainventario.Logica.Usuario;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cambiarContraseña")
public class svCambiarContraseña extends HttpServlet {

    private UsuarioJpaController usuarioJpaController = new UsuarioJpaController(); // Instancia de controlador JPA

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuarioNick = request.getParameter("usuario");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Verifica si las contraseñas coinciden
        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("error", "Las contraseñas no coinciden.");
            request.getRequestDispatcher("/cambiar-contraseña.jsp").forward(request, response);
            return;
        }

        // Usar JPA para obtener el usuario
        Usuario user = usuarioJpaController.findUsuario(usuarioNick);

        if (user != null && user.getContrasena().equals(oldPassword)) {
            // Cambiar la contraseña
            user.setContrasena(newPassword);
            try {
                usuarioJpaController.edit(user);  // Usamos JPA para actualizar el usuario
                response.sendRedirect("account.jsp");  // Redirige a una página de perfil o éxito
            } catch (Exception e) {
                request.setAttribute("error", "Hubo un error al actualizar la contraseña.");
                request.getRequestDispatcher("/change-password.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("/change-password.jsp").forward(request, response);
        }
    }
}
