<%-- 
    Document   : usuarios
    Created on : 5 mar 2025, 3:10:59
    Author     : ronald
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
</head>
<body>
    <h1>Lista de Usuarios</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Rol</th>
            <th>Acciones</th>
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
            <td>
                <a href="ServletUsuario?accion=buscar&id=<%= usuario.getId_usuario() %>">Ver</a>
                <a href="ServletUsuario?accion=eliminar&id=<%= usuario.getId_usuario() %>" 
                   onclick="return confirm('¿Estás seguro de eliminar este usuario?');">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br>
    <a href="registrarUsuario.jsp">Agregar Nuevo Usuario</a>
</body>
</html>

