<%@ page import="org.example.miscanti_ventainventario.Logica.Producto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tu Carrito</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<jsp:include page="component/header.jsp" />
<main>
  <div class="cart-container">
    <h1>Tu Carrito</h1>
    <h2>Productos en tu carrito</h2>
    <form action="svEliminarProdCarrito" method="post">
      <table>
        <thead>
        <tr>
          <th>Código</th>
          <th>Producto</th>
          <th>Cantidad</th>
          <th>Precio</th>
          <th>Total</th>
          <th>Acción</th>
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
          <td><%= producto.getCodigo() %></td>
          <td><%= producto.getNombre() %></td>
          <td><%= producto.getCantidad() %></td>
          <td><%= producto.getPrecio() %></td>
          <td><%= subtotal %></td>
          <td>
            <!-- Disminuir cantidad de productos-->
            <form action="svEliminarProdCarrito" method="post" style="display:inline;">
              <input type="hidden" name="codigo" value="<%= producto.getCodigo() %>">
              <input type="number" name="cantidad" min="1" max="<%= producto.getCantidad() %>" value="1" required>
              <button type="submit">Eliminar</button>
            </form>
          </td>
        </tr>
        <%
          }
        %>
        <tr>
          <td colspan="4" style="text-align: right;"><strong>Total:</strong></td>
          <td><strong>$<%= total %></strong></td>
          <td>
            <!-- Payment button -->
            <form action="descargarBoleta" method="POST">
              <button type="submit" name="action" value="Pay">Pagar</button>
            </form>
          </td>
        </tr>
        <% } else { %>
        <tr>
          <td colspan="6" style="text-align: center;">Tu carrito está vacío.</td>
        </tr>
        <% } %>
        </tbody>
      </table>
    </form>
  </div>
</main>
<jsp:include page="component/footer.jsp" />
</body>
</html>





