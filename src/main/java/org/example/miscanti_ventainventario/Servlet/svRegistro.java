package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.miscanti_ventainventario.Logica.UserManagment;
import org.example.miscanti_ventainventario.Logica.Usuario;

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

        // Simulación de registro exitoso (almacena en una base de datos o en memoria)
        // En un proyecto real, aquí deberías llamar a una clase de servicio o DAO para manejar la lógica del registro.

        boolean registroExitoso = registrarUsuario(nickName, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, correo, contrasena);

        if (registroExitoso) {
            // Redirigir a la página de éxito o inicio de sesión
            response.sendRedirect("login.jsp");
        } else {
            // Mostrar un mensaje de error si el registro falla
            request.setAttribute("errorMessage", "Ocurrió un error al registrar al usuario. Inténtalo nuevamente.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }

    // Método simulado para registrar un usuario
    private boolean registrarUsuario(String nickName, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasena) {
        return UserManagment.addUser(new Usuario(nickName, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, correo, contrasena));
    }
}
