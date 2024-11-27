package org.example.miscanti_ventainventario.Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", value = "/login")
public class svInventario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String cantidad = request.getParameter("number");

        if (cantidad != null && cantidad.matches("\\d+")) {
        //lol
        }
    }
}