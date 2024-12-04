<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Obtiene la sesión actual, pero no la crea si no existe
    String username = (session != null) ? (String) session.getAttribute("username") : null;

    // Redirige al login si el usuario no está autenticado
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Puedes agregar información adicional aquí si lo necesitas, como el nombre completo, email, etc.
    String fullName = (String) session.getAttribute("fullName"); // Ejemplo de nombre completo del usuario
    String email = (String) session.getAttribute("email");// Ejemplo de correo electrónico del usuario
    String rol = session.getAttribute("rol").toString();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi Cuenta - Bienvenido <%= username %> </title>
    <link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>

<!-- Header de la página -->
<jsp:include page="component/header.jsp"></jsp:include>

<!-- Contenido principal de la página de cuenta -->
<div class="account-container">
    <h1>¡Bienvenido, <%= username %>!</h1>

    <!-- Información del usuario -->
    <section class="user-info">
        <h2>Información de la cuenta</h2>
        <p><strong>Nombre completo:</strong> <%= fullName != null ? fullName : "No disponible" %></p>
        <p><strong>Correo electrónico:</strong> <%= email != null ? email : "No disponible" %></p>
    </section>

    <!-- Sección de acciones adicionales -->
    <section class="actions">
        <h2>Opciones disponibles</h2>
        <ul>
            <li><a href="change-password.jsp">Cambiar contraseña</a></li>
            <% if (rol.equals("ADMINISTRADOR")) { %>
                <li><a href="manage-users.jsp">Administrar usuarios</a></li>
                <li><a href="manage-inventory.jsp">Administrar inventario</a></li>
            <% } %>
        </ul>
    </section>

    <!-- Enlace de cierre de sesión -->
    <section class="logout-section">
        <a href="logout" onclick="return confirm('¿Estás seguro de que quieres cerrar sesión?');">Cerrar sesión</a>
    </section>
</div>

<!-- Footer de la página -->
<jsp:include page="component/footer.jsp"></jsp:include>

</body>
</html>
