package org.example.miscanti_ventainventario.Servlet;

import org.example.miscanti_ventainventario.DataBase.UsuarioJpaController;
import org.example.miscanti_ventainventario.Logica.Usuario;
import org.example.miscanti_ventainventario.Logica.Rol;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/administrarUsuarios")
public class svAdministrarUsuarios extends HttpServlet {

    private UsuarioJpaController usuarioJpaController;

    @Override
    public void init() throws ServletException {
        // Inicialización del controlador JPA
        usuarioJpaController = new UsuarioJpaController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la lista de usuarios desde la base de datos usando el controlador JPA
        List<Usuario> usuarios = usuarioJpaController.findUsuarioEntities();

        // Procesar el cambio de rol de cada usuario
        for (Usuario usuario : usuarios) {
            String rol = request.getParameter("rol_" + usuario.getNickName());
            if (rol != null) {
                // Cambiar el rol del usuario basado en el parámetro recibido
                switch (rol) {
                    case "CLIENTE":
                        usuario.setRol(Rol.CLIENTE);
                        break;
                    case "ADMINISTRADOR":
                        usuario.setRol(Rol.ADMINISTRADOR);
                        break;
                }

                // Actualizar el usuario en la base de datos
                try {
                    usuarioJpaController.edit(usuario);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Hubo un error al actualizar los roles de los usuarios.");
                    request.getRequestDispatcher("adminUsuarios.jsp").forward(request, response);
                    return;
                }
            }
        }

        // Redirigir a la página de administración de usuarios después de la actualización
        response.sendRedirect("manage-users.jsp");
    }
}

