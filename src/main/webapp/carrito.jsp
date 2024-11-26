<%--
  Created by IntelliJ IDEA.
  User: sapul
  Date: 20-11-2024
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
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
  <h1>Tu Carrito</h1>
</header>
<jsp:include page="component/header.jsp"></jsp:include>
<main>
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
    <!-- Ejemplo de fila -->
    <tr>
      <td>Producto 1</td>
      <td>2</td>
      <td>$10.000</td>
      <td>$20.000</td>
      <td><button>Eliminar</button></td>
    </tr>
    <!-- Añadir más filas dinámicamente -->
    </tbody>
  </table>
  <h3>Total: $20.000</h3>
  <button>Proceder al Pago</button>
</main>
<jsp:include page="component/footer.jsp"></jsp:include>
</body>
</html>

