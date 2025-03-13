<%-- 
    Document   : listarUsuarios
    Created on : 2 mar 2025, 23:47:00
    Author     : ronald
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Lista de Usuarios</h2>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Rol</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (listaUsuarios != null) {
                for (Usuario usuario : listaUsuarios) {
        %>
        <tr>
            <td><%= usuario.getId_usuario() %></td>
            <td><%= usuario.getNombre_usuario() %></td>
            <td><%= usuario.getRol() %></td>
            <td>
                <a href="ServletUsuario?accion=eliminar&id=<%= usuario.getId_usuario() %>" 
                   onclick="return confirm('¿Seguro que deseas eliminar este usuario?');">Eliminar</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    
    <br>
    <a href="registrarUsuario.jsp">Registrar Nuevo Usuario</a>
</body>
</html>


