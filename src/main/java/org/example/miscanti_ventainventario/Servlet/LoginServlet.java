package org.example.miscanti_ventainventario.Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.miscanti_ventainventario.Logica.Usuario;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (UserDatabase.isValidUser(username, password)) {
            HttpSession session = request.getSession();
            Usuario user = (Usuario) UserDatabase.getUser(username, password);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("fullName", user.getFullName());
            session.setAttribute("email", user.getCorreo());
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

