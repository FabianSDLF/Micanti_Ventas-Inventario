package org.example.miscanti_ventainventario.Servlet;

import org.example.miscanti_ventainventario.Logica.Usuario;
import org.example.miscanti_ventainventario.Logica.Rol;
import org.example.miscanti_ventainventario.Logica.UserManagment;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/administrarUsuarios")
public class svAdministrarUsuarios extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la lista de usuarios desde UserManagment
        List<Usuario> usuarios = UserManagment.obtenerUsuarios();

        // Procesar el cambio de rol de cada usuario
        for (Usuario usuario : usuarios) {
            String rol = request.getParameter("rol_" + usuario.getNickName());
            if (rol != null) {
                // Cambiar el rol del usuario
                switch (rol) {
                    case "CLIENTE":
                        usuario.setRol(Rol.CLIENTE);
                        break;
                    case "ADMINISTRADOR":
                        usuario.setRol(Rol.ADMINISTRADOR);
                        break;
                }
            }
        }

        // Redirigir a la misma página para mostrar los cambios
        response.sendRedirect("manage-users");
    }
}
