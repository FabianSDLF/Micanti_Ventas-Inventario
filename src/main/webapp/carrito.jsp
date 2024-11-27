<%@ page import="org.example.miscanti_ventainventario.Logica.BodegaManagment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <th>Acción</th>
      </tr>
      </thead>
      <tbody>

      <%
        List<String> miLista = BodegaManagment.getBodega().reporteInventario();
        if (miLista.get(0).equals("La bodega está vacía.")){
          for (String elemento : miLista) {
            String[] partes = elemento.split("\t");
      %>

        <tr>
          <td><%= partes[1] %></td>
          <td>0</td>
          <td><%= partes[3] %></td>
          <td><%= 0 * Integer.parseInt(partes[3]) %></td>
          <td>
            <form action="eliminarProductoCarrito" method="post" style="display:inline;">
              <input type="hidden" name="idProducto" value="${producto.id}" />
              <button type="submit" class="btn-eliminar">Eliminar</button>
            </form>
          </td>
        </tr>
      <%
          }
      } else {
      %>
        <tr>
          <td colspan="5" class="empty-cart">No hay productos en tu carrito.</td>
        </tr>
      <%  } %>
      </tbody>
    </table>
    <%-- Mostrar el total solo si hay productos --%>
    <c:if test="${!productos.isEmpty()}">
      <div class="cart-summary">
        <h3>Total: $${total}</h3>
        <button class="btn-pagar" onclick="location.href='pago.jsp'">Proceder al Pago</button>
      </div>
    </c:if>
  </div>
</main>
  <jsp:include page="component/footer.jsp" />
</body>
</html>