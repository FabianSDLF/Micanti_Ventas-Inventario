<%@ page import="org.example.miscanti_ventainventario.Logica.Producto" %>
<%@ page import="java.util.List" %>
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
  <h1>Tu Carrito</h1>
  <table>
    <thead>
    <tr>
      <th>Producto</th>
      <th>Cantidad</th>
      <th>Precio</th>
      <th>Total</th>
      <th>Eliminar</th>
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
      <td colspan="3">Total:</td>
      <td colspan="2">$<%= total %></td>
    </tr>
    <%
    } else {
    %>
    <tr>
      <td colspan="5">El carrito está vacío.</td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>

  <!-- Botón de pago -->
  <form action="pago.jsp" method="get">
    <button type="submit">Proceder al Pago</button>
  </form>
</main>
<jsp:include page="component/footer.jsp" />
</body>
</html>