<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container-login">
    <h1>Iniciar Sesión</h1>
    <form action="login" method="POST">
        <div class="form-group">
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username" required aria-label="Nombre de usuario">
        </div>
        <div class="form-group">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required aria-label="Contraseña">
        </div>
        <button type="submit">Ingresar</button>

        <p class="error-message">
            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
        </p>
    </form>

    <div class="forgot-password">
        <a href="#">¿Olvidaste tu contraseña?</a>
    </div>

    <div class="register-link">
        <p>¿No tienes cuenta? <a href="register.jsp">Regístrate aquí</a></p>
    </div>
</div>
</body>
</html>

