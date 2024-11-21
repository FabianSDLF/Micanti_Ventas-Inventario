<%--
  Created by IntelliJ IDEA.
  User: sapul
  Date: 21-11-2024
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Obtiene la sesión actual, pero no la crea si no existe
    String username = (session != null) ? (String) session.getAttribute("username") : null;

    // Redirige al login si el usuario no está autenticado
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
</head>
<body>
<h1>¡Bienvenido, <%= username %>!</h1>
<a href="logout">Cerrar sesión</a>
</body>
</html>


