<%@ page import="org.example.miscanti_ventainventario.Logica.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.Rol" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.UserManagment" %>
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

    <!-- Formulario para actualizar roles de los usuarios -->
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
            <!-- Iteramos sobre los usuarios pasados desde el controlador -->
            <%
                // Obtenemos la lista de usuarios de la clase UserManagment
                List<Usuario> usuarios = UserManagment.obtenerUsuarios();
                if(!usuarios.isEmpty()){
                    for (Usuario usuario : usuarios) {
            %>
            <tr>
                <td><%= usuario.getNickName() %></td>
                <td><%= usuario.getFullName() %></td>
                <td><%= usuario.getCorreo() %></td>
                <td>
                    <!-- Dropdown para seleccionar el nuevo rol -->
                    <select name="rol_<%= usuario.getNickName() %>">
                        <option value="CLIENTE" <%= usuario.getRol() == Rol.CLIENTE ? "selected" : "" %>>Cliente</option>
                        <option value="ADMINISTRADOR" <%= usuario.getRol() == Rol.ADMINISTRADOR ? "selected" : "" %>>Administrador</option>
                    </select>
                </td>
            </tr>
            <%
                    }
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
