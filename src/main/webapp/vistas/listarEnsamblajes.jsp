<%-- 
    Document   : listarEnsamblajes
    Created on : 12 mar 2025, 21:58:52
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Ensamblaje" %>
<%@ page import="modelo.dao.EnsamblajeDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Ensamblajes</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Lista de Ensamblajes</h2>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>ID Computadora</th>
            <th>ID Componente</th>
            <th>Cantidad</th>
            <th>Acciones</th>
        </tr>
        <%
            EnsamblajeDAO ensamblajeDAO = new EnsamblajeDAO();
            List<Ensamblaje> listaEnsamblajes = ensamblajeDAO.obtenerEnsamblajes();
            for (Ensamblaje ens : listaEnsamblajes) {
        %>
        <tr>
            <td><%= ens.getId_ensamblaje() %></td>
            <td><%= ens.getId_computadora() %></td>
            <td><%= ens.getId_componente() %></td>
            <td><%= ens.getCantidad() %></td>
            <td>
                <a href="editarEnsamblaje.jsp?id=<%= ens.getId_ensamblaje() %>">Editar</a> |
                <a href="../ServletEnsamblaje?accion=eliminar&id=<%= ens.getId_ensamblaje() %>" onclick="return confirm('¿Seguro que deseas eliminar este ensamblaje?');">Eliminar</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <br>
    <a href="registrarEnsamblaje.jsp">Registrar Ensamblaje</a> |
    <a href="../index.html">Volver al inicio</a>
</body>
</html>
