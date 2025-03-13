<%-- 
    Document   : listarVentas
    Created on : 8 mar 2025, 12:09:49
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Venta" %>
<%@ page import="modelo.dao.VentaDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Ventas</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Lista de Ventas</h2>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Fecha de Venta</th>
            <th>Total Venta</th>
            <th>ID Cliente</th>
            <th>ID Usuario</th>
            <th>Acciones</th>
        </tr>
        <%
            VentaDAO ventaDAO = new VentaDAO();
            List<Venta> listaVentas = ventaDAO.obtenerVentas();
            for (Venta venta : listaVentas) {
        %>
        <tr>
            <td><%= venta.getId_venta() %></td>
            <td><%= venta.getFecha_venta() %></td>
            <td><%= venta.getTotal_venta() %></td>
            <td><%= venta.getId_cliente() %></td>
            <td><%= venta.getId_usuario() %></td>
            <td>
                <a href="eliminarVenta?id=<%= venta.getId_venta() %>" onclick="return confirm('¿Seguro que deseas eliminar esta venta?');">Eliminar</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <br>
    <a href="../index.html">Volver al inicio</a>
</body>
</html>

