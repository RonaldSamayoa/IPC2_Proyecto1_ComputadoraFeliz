<%-- 
    Document   : listarDevoluciones
    Created on : 8 mar 2025, 11:03:57
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Devolucion" %>
<%@ page import="modelo.dao.DevolucionDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Devoluciones</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Lista de Devoluciones</h2>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Fecha de Devolución</th>
            <th>Pérdida</th>
            <th>ID Venta</th>
            <th>Acciones</th>
        </tr>
        <%
            DevolucionDAO devolucionDAO = new DevolucionDAO();
            List<Devolucion> listaDevoluciones = devolucionDAO.obtenerDevoluciones();
            for (Devolucion dev : listaDevoluciones) {
        %>
        <tr>
            <td><%= dev.getId_devolucion() %></td>
            <td><%= dev.getFecha_devolucion() %></td>
            <td><%= dev.getPerdida() %></td>
            <td><%= dev.getId_venta() %></td>
            <td>
                <a href="editarDevolucion.jsp?id=<%= dev.getId_devolucion() %>">Editar</a> |
                <a href="eliminarDevolucion?id=<%= dev.getId_devolucion() %>" onclick="return confirm('¿Seguro que deseas eliminar esta devolución?');">Eliminar</a>
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

