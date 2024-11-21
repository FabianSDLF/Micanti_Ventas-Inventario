<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tienda Miscanti</title>
    <link rel="stylesheet" href="CSS/styles.css">
</head>
<body>
<header>
    <h1>Bienvenidos a la Tienda Miscanti</h1>
    <p>Encuentra los mejores productos al mejor precio</p>
</header>

<nav>
    <ul>
        <li><a href="index.jsp">Inicio</a></li>
        <li><a href="JS/productos.jsp">Productos</a></li>
        <li><a href="JS/carrito.jsp">Carrito</a></li>
        <li><a href="JS/contacto.jsp">Contacto</a></li>
    </ul>
</nav>

<main>
    <h2>Productos Destacados</h2>
    <form method="get" action="JS/productos.jsp">
        <label for="buscar">Buscar productos:</label>
        <input type="text" id="buscar" name="query" placeholder="Escribe el nombre del producto">
        <button type="submit">Buscar</button>
    </form>

    <section class="productos">
        <!-- Aquí puedes iterar los productos dinámicamente -->
        <article class="producto">
            <img src="../resources/images/producto1.jpg" alt="Producto 1">
            <h3>Producto 1</h3>
            <p>Descripción breve del producto 1.</p>
            <p><strong>$10.000</strong></p>
            <button>Agregar al carrito</button>
        </article>

        <article class="producto">
            <img src="../resources/images/producto2.jpg" alt="Producto 2">
            <h3>Producto 2</h3>
            <p>Descripción breve del producto 2.</p>
            <p><strong>$15.000</strong></p>
            <button>Agregar al carrito</button>
        </article>

        <article class="producto">
            <img src="../resources/images/producto3.jpg" alt="Producto 3">
            <h3>Producto 3</h3>
            <p>Descripción breve del producto 3.</p>
            <p><strong>$20.000</strong></p>
            <button>Agregar al carrito</button>
        </article>
    </section>
</main>

<footer>
    <p>&copy; 2024 Tienda Miscanti. Todos los derechos reservados.</p>
    <a href="hello-servlet">Hello Servlet</a>
</footer>
</body>
</html>
