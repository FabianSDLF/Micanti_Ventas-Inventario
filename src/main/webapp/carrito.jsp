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
      <%-- Se generan filas dinámicamente --%>
      <c:forEach var="producto" items="${productos}">
        <tr>
          <td>${producto.nombre}</td>
          <td>${producto.cantidad}</td>
          <td>${producto.precio}</td>
          <td>${producto.cantidad * producto.precio}</td>
          <td>
            <form action="eliminarProducto" method="post" style="display:inline;">
              <input type="hidden" name="idProducto" value="${producto.id}" />
              <button type="submit" class="btn-eliminar">Eliminar</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      <%-- Mostrar mensaje si el carrito está vacío --%>
      <c:if test="${productos.isEmpty()}">
        <tr>
          <td colspan="5" class="empty-cart">No hay productos en tu carrito.</td>
        </tr>
      </c:if>
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