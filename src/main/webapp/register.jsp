<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="styles.css">
    <script>
        function validarFormulario(event) {
            const password = document.getElementById('contrasena').value;
            const confirmPassword = document.getElementById('confirmarContrasena').value;

            if (password !== confirmPassword) {
                event.preventDefault();
                alert("Las contraseñas no coinciden. Por favor, verifica.");
            }
        }
    </script>
</head>
<body>
<div class="container-register">
    <h1>Crear una cuenta</h1>
    <form action="registro" method="POST" onsubmit="validarFormulario(event)">
        <label for="nickName">Nombre de usuario:</label>
        <input type="text" id="nickName" name="nickName" required placeholder="Ejemplo: usuario123" maxlength="20">

        <label for="primerNombre">Primer Nombre:</label>
        <input type="text" id="primerNombre" name="primerNombre" required placeholder="Tu primer nombre">

        <label for="segundoNombre">Segundo Nombre:</label>
        <input type="text" id="segundoNombre" name="segundoNombre" placeholder="Opcional">

        <label for="apellidoPaterno">Apellido Paterno:</label>
        <input type="text" id="apellidoPaterno" name="apellidoPaterno" required placeholder="Tu apellido paterno">

        <label for="apellidoMaterno">Apellido Materno:</label>
        <input type="text" id="apellidoMaterno" name="apellidoMaterno" placeholder="Opcional">

        <label for="correo">Correo electrónico:</label>
        <input type="email" id="correo" name="correo" required placeholder="ejemplo@correo.com">

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required minlength="6" placeholder="Mínimo 6 caracteres">

        <label for="confirmarContrasena">Confirmar Contraseña:</label>
        <input type="password" id="confirmarContrasena" name="confirmarContrasena" required minlength="6" placeholder="Repite la contraseña">

        <button type="submit">Registrar</button>
    </form>

    <%-- Mensajes de error dinámicos del backend --%>
    <p class="error-message">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>

    <div class="login-link">
        <p>¿Ya tienes una cuenta? <a href="login.jsp">Iniciar sesión</a></p>
    </div>
</div>
</body>
</html>