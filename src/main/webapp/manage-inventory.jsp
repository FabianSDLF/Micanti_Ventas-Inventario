<%@ page import="org.example.miscanti_ventainventario.Logica.BodegaManagment" %>
<%@ page import="java.util.ArrayList" %>
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

<h1 class="inventory-h1">Inventario Actual</h1>
<table class="inventory-table">
    <thead>
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Cantidad</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<String> miLista = (ArrayList<String>) BodegaManagment.getBodega().reporteInventario();
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