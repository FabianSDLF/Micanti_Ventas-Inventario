package org.example.miscanti_ventainventario.Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.Logica.UserManagment;
import org.example.miscanti_ventainventario.Logica.Usuario;

@WebServlet(name = "LoginServlet", value = "/login")
public class svLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (UserManagment.isValidUser(username, password)) {
            HttpSession session = request.getSession();
            Usuario user = (Usuario) UserManagment.getUser(username, password);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("fullName", user.getFullName());
            session.setAttribute("email", user.getCorreo());
            session.setAttribute("rol", user.getRol());
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
