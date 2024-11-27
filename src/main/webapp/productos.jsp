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

<jsp:include page="component/header.jsp"></jsp:include>
<main>
  <h1>Productos disponibles</h1>
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
<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>

