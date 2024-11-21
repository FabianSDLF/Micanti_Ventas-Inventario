<%--
  Created by IntelliJ IDEA.
  User: sapul
  Date: 20-11-2024
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contacto</title>
    <link rel="stylesheet" href="../CSS/styles.css">
</head>
<body>
<header>
    <h1>Contáctanos</h1>
</header>
<nav>
    <ul>
        <li><a href="../index.jsp">Inicio</a></li>
        <li><a href="productos.jsp">Productos</a></li>
        <li><a href="carrito.jsp">Carrito</a></li>
        <li><a href="contacto.jsp" class="active">Contacto</a></li>
    </ul>
</nav>
<main>
    <h2>¿Tienes alguna consulta? Envíanos un mensaje.</h2>
    <form action="enviarMensaje.jsp" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="email">Correo Electrónico:</label>
        <input type="email" id="email" name="email" required>

        <label for="mensaje">Mensaje:</label>
        <textarea id="mensaje" name="mensaje" rows="5" required></textarea>

        <button type="submit">Enviar</button>
    </form>
</main>
<footer>
    <p>&copy; 2024 Miscanti - Venta e Inventario</p>
</footer>
</body>
</html>

