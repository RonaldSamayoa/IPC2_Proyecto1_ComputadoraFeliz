<%-- 
    Document   : pruebaConexion
    Created on : 12 mar 2025, 17:07:11
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prueba de Conexión</title>
</head>
<body>
    <h2>Lista de Usuarios desde la Base de Datos</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Rol</th>
        </tr>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {
        %>
        <tr>
            <td><%= usuario.getId_usuario() %></td>
            <td><%= usuario.getNombre_usuario() %></td>
            <td><%= usuario.getRol() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No hay usuarios en la base de datos.</td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <a href="../index.jsp">Volver al inicio</a>
</body>
</html>

