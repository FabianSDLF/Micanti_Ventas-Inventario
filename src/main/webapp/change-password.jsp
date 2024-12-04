<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cambiar Contraseña</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<jsp:include page="component/header.jsp"></jsp:include>

<div class="container-change-password">
    <h1>Cambiar Contraseña</h1>

    <!-- Formulario de cambio de contraseña -->
    <form action="cambiarContraseña" method="POST">
        <div class="form-group">
            <label for="usuario">Nombre de Usuario:</label>
            <input type="text" id="usuario" name="usuario" placeholder="Nombre de Usuario" required>
        </div>
        <div class="form-group">
            <label for="oldPassword">Contraseña Actual:</label>
            <input type="password" id="oldPassword" name="oldPassword" placeholder="Contraseña Actual" required>
        </div>
        <div class="form-group">
            <label for="newPassword">Nueva Contraseña:</label>
            <input type="password" id="newPassword" name="newPassword" placeholder="Nueva Contraseña" required>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirmar Nueva Contraseña:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirmar Contraseña" required>
        </div>
        <button type="submit">Actualizar Contraseña</button>
    </form>
</div>

<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>
