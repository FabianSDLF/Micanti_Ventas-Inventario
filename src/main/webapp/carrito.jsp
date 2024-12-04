<% List<Producto> carrito = (List<Producto>) session.getAttribute("carrito"); %>
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
    <form action="descargarBoleta" method="POST">
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
            <!-- Delete button for each product -->
            <button type="submit" name="action" value="Delete_<%= producto.getCodigo() %>">Eliminar</button>
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
            <button type="submit" name="action" value="Pay">Pagar</button>
          </td>
        </tr>
        <% } else { %>
        <tr>
          <td colspan="5" style="text-align: center;">Tu carrito está vacío.</td>
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




