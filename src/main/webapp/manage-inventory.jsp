<%@ page import="org.example.miscanti_ventainventario.Logica.Bodega" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.miscanti_ventainventario.Logica.Producto" %>
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

<h1 style="text-align:center;">Inventario Actual</h1>
<table>
    <thead>
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Cantidad</th>
    </tr>
    </thead>
    <tbody>
    <%
        Bodega bodega = new Bodega(999,20,600);
        bodega.agregarProducto(new Producto(20, 1223, "botella"));
        bodega.agregarProducto(new Producto(20, 1224, "limpiador"));
        bodega.agregarProducto(new Producto(20, 1228, "tapas"));
        List<String> miLista = bodega.reporteInventario();
        for (String elemento : miLista) {
            String[] partes = elemento.split("\t");
    %>
    <tr>
        <td><%= partes[0] %></td>
        <td><%= partes[1] %></td>
        <td><%= partes[2] %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>