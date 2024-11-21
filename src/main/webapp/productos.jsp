<%--
  Created by IntelliJ IDEA.
  User: sapul
  Date: 20-11-2024
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Productos</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
  <h1>Productos Disponibles</h1>
</header>
<nav>
  <ul>
    <li><a href="index.jsp">Inicio</a></li>
    <li><a href="productos.jsp" class="active">Productos</a></li>
    <li><a href="carrito.jsp">Carrito</a></li>
    <li><a href="contacto.jsp">Contacto</a></li>
  </ul>
</nav>
<main>
  <h2>Explora nuestros productos</h2>
  <section class="productos">
    <article class="producto">
      <img src="img/producto1.jpg" alt="Producto 1">
      <h3>Producto 1</h3>
      <p>Descripción breve del producto 1.</p>
      <strong>$10.000</strong>
      <button>Añadir al carrito</button>
    </article>
    <article class="producto">
      <img src="img/producto2.jpg" alt="Producto 2">
      <h3>Producto 2</h3>
      <p>Descripción breve del producto 2.</p>
      <strong>$15.000</strong>
      <button>Añadir al carrito</button>
    </article>
    <!-- Añade más productos según sea necesario -->
  </section>
</main>
<footer>
  <p>&copy; 2024 Miscanti - Venta e Inventario</p>
</footer>
</body>
</html>

