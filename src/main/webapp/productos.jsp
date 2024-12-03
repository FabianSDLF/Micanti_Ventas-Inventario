<%@ page import="org.example.miscanti_ventainventario.Logica.Bodega" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Productos</title>
  <link rel="stylesheet" href="styles.css">
  <style>
    /* Estilo para la notificación */
    #notification {
      position: fixed;
      top: 20px;
      right: 20px;
      background-color: #4caf50;
      color: white;
      padding: 15px 20px;
      border-radius: 5px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
      z-index: 1000;
      transition: opacity 0.3s ease-in-out;
      opacity: 0; /* Oculta la notificación por defecto */
    }

    #notification.visible {
      opacity: 1; /* Muestra la notificación */
    }

    #notification.hidden {
      opacity: 0; /* Oculta la notificación */
    }
  </style>
</head>
<body>
<jsp:include page="component/header.jsp"></jsp:include>
<main>
  <h1>Productos disponibles</h1>
  <h2>Explora nuestros productos</h2>
  <section class="productos">
    <%
      Bodega bodega = (Bodega) application.getAttribute("bodega");
      for (Producto producto : bodega.getListaProductos()) {
    %>
    <article class="producto">
      <img src="${pageContext.request.contextPath}/images/producto<%= producto.getCodigo() %>.jpg" alt="<%= producto.getNombre() %>">
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
    <% } %>
  </section>
</main>

<!-- Notificación -->
<div id="notification" class="hidden">
  Producto agregado al carrito exitosamente.
</div>

<jsp:include page="component/footer.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/scripts.js"></script>
<script>
  // Verifica si la URL contiene el parámetro success=true
  const urlParams = new URLSearchParams(window.location.search);
  if (urlParams.get("success") === "true") {
    const notification = document.getElementById("notification");
    notification.classList.remove("hidden");
    notification.classList.add("visible");

    // Oculta la notificación después de 3 segundos
    setTimeout(() => {
      notification.classList.remove("visible");
      notification.classList.add("hidden");
    }, 3000);
  }

  // Función para actualizar la cantidad en el input
  function updateQuantity(codigo, increase) {
    const input = document.getElementById('quantity-' + codigo);
    let currentValue = parseInt(input.value);
    if (increase) {
      input.value = currentValue + 1;
    } else if (currentValue > 1) {
      input.value = currentValue - 1;
    }
  }
</script>
</body>
</html>

