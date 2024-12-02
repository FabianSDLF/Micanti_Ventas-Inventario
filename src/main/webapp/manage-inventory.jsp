<%@ page import="org.example.miscanti_ventainventario.Logica.BodegaManagment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario Actual</title>
    <link rel="stylesheet" href="styles.css">

</head>
<body>x

<jsp:include page="component/header.jsp"></jsp:include>
<main>
    <div class="cart-container">
        <div class="inventory-container">
            <h1>Inventario Actual</h1>
            <table class="inventory-table">
                <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Cantidad</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<String> miLista = BodegaManagment.getBodega().reporteInventario();
                    for (String elemento : miLista) {
                        String[] partes = elemento.split("\t");
                %>
                <tr>
                    <td><%= partes[0] %></td>
                    <td><%= partes[1] %></td>
                    <td><%= partes[2] %></td>
                    <td>
                        <!-- Formulario para añadir o reducir -->
                        <form action="GestionarInventarioServlet" method="post" style="display:inline;">
                            <input type="hidden" name="codigo" value="<%= partes[0] %>">
                            <input type="number" name="cantidad" min="1" placeholder="Cantidad" required>
                            <button type="submit" name="accion" value="añadir" class="btn-añadir">Añadir</button>
                            <button type="submit" name="accion" value="reducir" class="btn-reducir">Reducir</button>
                        </form>
                        <!-- Formulario para eliminar -->
                        <form action="GestionarInventarioServlet" method="post" style="display:inline;">
                            <input type="hidden" name="codigo" value="<%= partes[0] %>">
                            <button type="submit" name="accion" value="eliminar" class="btn-eliminar">Eliminar</button>
                        </form>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>

        <div class="add-product-container">
            <!-- Botón para añadir un nuevo producto -->
            <form action="GestionarInventarioServlet" method="post">
                <h2>Añadir Nuevo Producto</h2>
                <input type="number" name="codigo" placeholder="Código del Producto" required>
                <input type="text" name="nombre" placeholder="Nombre" required>
                <input type="number" name="cantidad" placeholder="Cantidad" required>
                <input type="number" name="precio" placeholder="Precio" required>
                <input type="text" name="url_img" placeholder="URL Imagen" required>
                <button type="submit" name="accion" value="añadirProducto" class="btn-añadir">Añadir Producto</button>
            </form>
        </div>
    </div>
</main>

<jsp:include page="component/footer.jsp" />
</body>
</html>