<%@page import="org.example.miscanti_ventainventario.DataBase.ProductoJpaController"%>
<%@page import="java.util.List"%>
<%@ page import="org.example.miscanti_ventainventario.Logica.Bodega" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.Producto" %><%--
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
    <%
        ProductoJpaController jpa = new ProductoJpaController();
      List<Producto> productos = jpa.findProductoEntities();
      for (Producto producto : productos) {
        if (producto.getCantidad() >= 20) {
    %>
    <article class="producto">
      <h3><%= producto.getNombre() %></h3>
      <p>Precio: $<%= producto.getPrecio() %></p>
      <form action="svAgregarAlCarrito" method="post">
        <input type="hidden" name="codigo" value="<%= producto.getCodigo() %>">
        <input type="hidden" name="nombre" value="<%= producto.getNombre() %>">
        <input type="hidden" name="precio" value="<%= producto.getPrecio() %>">
        <div class="cantidad-control">
          <button type="button" onclick="updateQuantity(<%= producto.getCodigo() %>, false)">-</button>
          <input type="number" id="quantity-<%= producto.getCodigo() %>" name="cantidad" value="1" min="1">
          <button type="button" onclick="updateQuantity(<%= producto.getCodigo() %>, true)">+</button>
        </div>
        <button type="submit">Añadir al carrito</button>
      </form>
    </article>
    <% 
        }
       } %>
  </section>
</main>
<jsp:include page="component/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/scripts.js"></script>
</body>
</html>

