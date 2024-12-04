package org.example.miscanti_ventainventario.Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.DataBase.UsuarioJpaController;
import org.example.miscanti_ventainventario.Logica.Usuario;

@WebServlet(name = "LoginServlet", value = "/login")
public class svLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Crear instancia del controlador JPA
        UsuarioJpaController usuarioController = new UsuarioJpaController();

        try {
            // Buscar al usuario en la base de datos
            Usuario user = usuarioController.findUsuarioByNickName(username);

            // Validar usuario y contraseña
            if (user != null && user.getContrasena().equals(password)) {
                // Crear sesión y guardar atributos
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getNickName());
                session.setAttribute("password", user.getContrasena());
                session.setAttribute("fullName", user.getFullName());
                session.setAttribute("email", user.getCorreo());
                session.setAttribute("rol", user.getRol());
                response.sendRedirect("index.jsp");
            } else {
                // Credenciales incorrectas
                request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Manejo de errores
            request.setAttribute("errorMessage", "Error al conectar con la base de datos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            e.printStackTrace();
        }
    }
}
