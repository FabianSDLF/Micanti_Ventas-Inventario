package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.miscanti_ventainventario.DataBase.UsuarioJpaController;
import org.example.miscanti_ventainventario.Logica.Usuario;
import org.example.miscanti_ventainventario.Logica.Rol;

import java.io.IOException;

@WebServlet("/registro")
public class svRegistro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir parámetros del formulario
        String nickName = request.getParameter("nickName");
        String primerNombre = request.getParameter("primerNombre");
        String segundoNombre = request.getParameter("segundoNombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String confirmarContrasena = request.getParameter("confirmarContrasena");

        // Validar contraseñas
        if (!contrasena.equals(confirmarContrasena)) {
            request.setAttribute("errorMessage", "Las contraseñas no coinciden. Por favor, verifica.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        // Crear una instancia de Usuario
        Usuario nuevoUsuario = new Usuario(
            nickName,
            primerNombre,
            segundoNombre,
            apellidoPaterno,
            apellidoMaterno,
            correo,
            contrasena
        );
        nuevoUsuario.setRol(Rol.CLIENTE); // Establecer el rol por defecto

        // Usar UsuarioJpaController para persistir en la base de datos
        UsuarioJpaController usuarioController = new UsuarioJpaController();

        try {
            usuarioController.create(nuevoUsuario);
            // Redirigir a la página de inicio de sesión tras el registro exitoso
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            // Manejar errores, como duplicidad de clave primaria o fallo en la base de datos
            request.setAttribute("errorMessage", "Ocurrió un error al registrar al usuario. Inténtalo nuevamente.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            e.printStackTrace();
        }
    }
}
    