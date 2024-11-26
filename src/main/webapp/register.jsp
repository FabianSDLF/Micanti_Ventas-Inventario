<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container-register">
    <h1>Crear una cuenta</h1>
    <form action="registro" method="POST">
        <label for="nickName">Nombre de usuario:</label>
        <input type="text" id="nickName" name="nickName" required>

        <label for="primerNombre">Primer Nombre:</label>
        <input type="text" id="primerNombre" name="primerNombre" required>

        <label for="segundoNombre">Segundo Nombre:</label>
        <input type="text" id="segundoNombre" name="segundoNombre">

        <label for="apellidoPaterno">Apellido Paterno:</label>
        <input type="text" id="apellidoPaterno" name="apellidoPaterno" required>

        <label for="apellidoMaterno">Apellido Materno:</label>
        <input type="text" id="apellidoMaterno" name="apellidoMaterno" required>

        <label for="correo">Correo electrónico:</label>
        <input type="email" id="correo" name="correo" required>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required>

        <button type="submit">Registrar</button>
    </form>
    <p style="color: red;">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>
    <div class="login-link">
        <p>¿Ya tienes una cuenta? <a href="login.jsp">Iniciar sesión</a></p>
    </div>
</div>
</body>
</html>
