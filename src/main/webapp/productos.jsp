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
    <!-- Producto 1 -->
    <article class="producto">
      <img src="${pageContext.request.contextPath}/images/producto1.jpg" alt="Producto">
      <h3>Producto 1</h3>
      <p>Descripción breve del producto 1.</p>
      <strong>$3.000</strong>
      <div class="cantidad-control">
        <button type="button" onclick="updateQuantity(1, false)">-</button>
        <input type="number" id="quantity-1" value="1" min="0">
        <button type="button" onclick="updateQuantity(1, true)">+</button>
      </div>
      <button onclick="addToCart(1)">Añadir al carrito</button>
    </article>

    <!-- Producto 2 -->
    <article class="producto">
      <img src="${pageContext.request.contextPath}/images/producto2.jpg" alt="Producto 2">
      <h3>Producto 2</h3>
      <p>Descripción breve del producto 2.</p>
      <strong>$10.000</strong>
      <div class="cantidad-control">
        <button type="button" onclick="updateQuantity(2, false)">-</button>
        <input type="number" id="quantity-2" value="1" min="0">
        <button type="button" onclick="updateQuantity(2, true)">+</button>
      </div>
      <button onclick="addToCart(2)">Añadir al carrito</button>
    </article>

    <!-- Puedes agregar más productos aquí -->
  </section>
</main>
<jsp:include page="component/footer.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/scripts.js"></script>
</body>
</html>

