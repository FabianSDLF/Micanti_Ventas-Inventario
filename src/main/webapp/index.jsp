<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda Miscanti</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<!-- Encabezado dinámico -->
<jsp:include page="component/header.jsp"></jsp:include>

<!-- Contenido principal -->
<main>
    <h1>Bienvenidos a la Tienda Miscanti</h1>
    <p>Encuentra los mejores productos al mejor precio</p>

    <h2>Producto Destacado</h2>
    <section class="productos">
        <!-- Aquí puedes iterar los productos dinámicamente -->
        <article class="producto">
            <img src="${pageContext.request.contextPath}/images/producto1.jpg" alt="Producto">
            <h3>Botella 20L</h3>
            <p>Botella de agua purificada de 20 litros.</p>
            <p><strong>$20.000</strong></p>
        </article>

    </section>
</main>
<!-- Pie de página -->
<jsp:include page="component/footer.jsp"></jsp:include>

</body>
</html>

