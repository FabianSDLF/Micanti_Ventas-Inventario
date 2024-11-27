<%@ page import="org.example.miscanti_ventainventario.Logica.BodegaManagment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario Actual</title>
    <link rel="stylesheet" href="styles.css">
    </script>

</head>
<body>

<jsp:include page="component/header.jsp"></jsp:include>


<main>
    <div class="cart-container">
        <h1>Inventario Actual</h1>
        <table>
            <thead>
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Añadir / Reducir</th>
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
                    <input type="text" id="number" name="number" required aria-label="Cantidad a cambiar">
                    <form action="eliminarProductoCarrito" method="post" style="display:inline;">
                        <input type="hidden" name="idProducto" value="${producto.id}" />
                        <button type="submit" onclick="" class="btn-añadir">Añadir</button>
                    </form>
                    <form action="eliminarProductoCarrito" method="post" style="display:inline;">
                        <input type="hidden" name="idProducto" value="${producto.id}" />
                        <button type="submit" class="btn-reducir">Reducir</button>
                    </form>
                </td>
            </tr>
            <%
                    } %>
            </tbody>
        </table>
    </div>
</main>
<jsp:include page="component/footer.jsp" />
</body>
</html>



