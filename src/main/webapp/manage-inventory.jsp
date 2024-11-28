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
                    <input type="text" id="number" class= "container-register" name="number" required aria-label="cant">
                    <button type="submit" onclick="" class="btn-añadir">Añadir</button>
                    <button type="submit" class="btn-reducir">Reducir</button>
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