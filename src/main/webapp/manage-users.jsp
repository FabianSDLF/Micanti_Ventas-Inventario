<%@page import="org.example.miscanti_ventainventario.DataBase.UsuarioJpaController"%>
<%@ page import="org.example.miscanti_ventainventario.Logica.Usuario" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.Rol" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administrar Usuarios</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<jsp:include page="component/header.jsp"></jsp:include>
<div class="container-manage-user">
    <h1>Administrar Usuarios</h1>

    <form action="administrarUsuarios" method="POST">
        <table border="1" class="managment-user-table">
            <thead>
            <tr>
                <th>Nombre de Usuario</th>
                <th>Nombre Completo</th>
                <th>Correo</th>
                <th>Rol</th>
            </tr>
            </thead>
            <tbody>
            <%
                
                UsuarioJpaController users = new UsuarioJpaController();
                // Recuperamos la lista de usuarios desde el request
                List<Usuario> usuarios = users.findUsuarioEntities();
                if (usuarios != null && !usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
            %>
            <tr>
                <td><%= usuario.getNickName() %></td>
                <td><%= usuario.getPrimerNombre() %> <%= usuario.getSegundoNombre() %> 
                    <%= usuario.getApellidoPaterno() %> <%= usuario.getApellidoMaterno() %></td>
                <td><%= usuario.getCorreo() %></td>
                <td>
                    <select name="rol_<%= usuario.getNickName() %>">
                        <option value="CLIENTE" <%= "CLIENTE".equals(usuario.getRol().toString()) ? "selected" : "" %>>Cliente</option>
                        <option value="ADMINISTRADOR" <%= "ADMINISTRADOR".equals(usuario.getRol().toString()) ? "selected" : "" %>>Administrador</option>
                    </select>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="4" style="text-align: center;">No hay usuarios registrados.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <button type="submit">Actualizar Roles</button>
    </form>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>
