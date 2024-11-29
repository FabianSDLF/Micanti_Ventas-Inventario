<%@ page import="java.util.List" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Carrito de Compras</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
  <jsp:include page="component/header.jsp" />
</header>
<main>
  <div class="cart-container">
    <h1>Tu Carrito</h1>
    <h2>Productos en tu carrito</h2>
    <table>
      <thead>
      <tr>
        <th>Producto</th>
        <th>Cantidad</th>
        <th>Precio</th>
        <th>Total</th>
      </tr>
      </thead>
      <tbody>
      <%
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
        if (carrito != null && !carrito.isEmpty()) {
          int total = 0;
          for (Producto producto : carrito) {
            int subtotal = producto.getCantidad() * producto.getPrecio();
            total += subtotal;
      %>
      <tr>
        <td><%= producto.getNombre() %></td>
        <td><%= producto.getCantidad() %></td>
        <td>$<%= producto.getPrecio() %></td>
        <td>$<%= subtotal %></td>
      </tr>
      <%
        }
      %>
      <tr>
        <td colspan="3" style="text-align: right;"><strong>Total:</strong></td>
        <td><strong>$<%= total %></strong></td>
      </tr>
      <%
      } else {
      %>
      <tr>
        <td colspan="4" style="text-align: center;">Tu carrito está vacío.</td>
      </tr>
      <% } %>
      </tbody>
    </table>
  </div>
</main>
<jsp:include page="component/footer.jsp" />
</body>
</html>