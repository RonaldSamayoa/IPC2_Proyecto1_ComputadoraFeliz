<%-- 
    Document   : listarComputadoras
    Created on : 8 mar 2025, 10:16:03
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Computadora" %>
<%@ page import="modelo.dao.ComputadoraDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Computadoras</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Lista de Computadoras</h2>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio de Venta</th>
            <th>Fecha de Ensamblaje</th>
            <th>ID Usuario</th>
            <th>Acciones</th>
        </tr>
        <%
            ComputadoraDAO computadoraDAO = new ComputadoraDAO();
            List<Computadora> listaComputadoras = computadoraDAO.obtenerComputadoras();
            for (Computadora comp : listaComputadoras) {
        %>
        <tr>
            <td><%= comp.getId_computadora() %></td>
            <td><%= comp.getNombre_computadora() %></td>
            <td><%= comp.getPrecio_venta() %></td>
            <td><%= comp.getFecha_ensamblaje() %></td>
            <td><%= comp.getId_usuario() %></td>
            <td>            
                <a href="../ServletComputadora?accion=eliminar&id=<%= comp.getId_computadora() %>" onclick="return confirm('¿Seguro que deseas eliminar esta computadora?');">Eliminar</a>
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

