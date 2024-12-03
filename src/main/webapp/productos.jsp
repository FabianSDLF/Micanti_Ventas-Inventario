<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.Producto" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.BodegaManagment" %>
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
      // Obtén la lista de productos desde algún controlador o fuente
      List<Producto> productos = BodegaManagment.getBodega().getListaProducto();
      if (productos != null) {
        for (Producto producto : productos) {
          if (producto.getCantidad() > 20) {
    %>
    <form action="AgregarAlCarrito" method="post">
      <article class="producto">
        <img src="<%=producto.getUrl_img()%>" alt="<%= producto.getCodigo() %>">
        <h3><%= producto.getNombre() %></h3>
        <p><%= producto.getDescipcion() %></p>
        <strong>$<%= producto.getPrecio() %></strong>
        <div class="cantidad-control">
          <button type="button" onclick="updateQuantity(<%= producto.getCodigo() %>, false)">-</button>
          <input type="number" id="quantity-<%= producto.getCodigo() %>" value="1" min="0">
          <button type="button" onclick="updateQuantity(<%= producto.getCodigo() %>, true)">+</button>
        </div>
        <button type="submit">Añadir al carrito</button>
      </article>
    </form>
    <%
        }
      }
    } else {
    %>
    <p>No hay productos disponibles.</p>
    <% } %>
  </section>
</main>
<jsp:include page="component/footer.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/scripts.js"></script>
</body>
</html>


