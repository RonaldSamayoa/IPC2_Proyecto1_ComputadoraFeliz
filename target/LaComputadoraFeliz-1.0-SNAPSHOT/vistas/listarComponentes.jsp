<%-- 
    Document   : listarComponentes
    Created on : 8 mar 2025, 10:14:26
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Componente" %>
<%@ page import="modelo.dao.ComponenteDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Componentes</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Lista de Componentes</h2>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Costo</th>
            <th>Cantidad</th>
            <th>Acciones</th>
        </tr>
        <%
            ComponenteDAO componenteDAO = new ComponenteDAO();
            List<Componente> listaComponentes = componenteDAO.obtenerComponentes();
            for (Componente comp : listaComponentes) {
        %>
        <tr>
            <td><%= comp.getId_componente() %></td>
            <td><%= comp.getNombre_componente() %></td>
            <td><%= comp.getCosto() %></td>
            <td><%= comp.getCantidad() %></td>
            <td>
                <a href="../ServletComponente?accion=eliminar&id=<%= comp.getId_componente() %>" onclick="return confirm('¿Seguro que deseas eliminar este componente?');">Eliminar</a>
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

