<%-- 
    Document   : registrarUsuario
    Created on : 2 mar 2025, 23:47:17
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Usuario" %>
<%@ page import="modelo.dao.UsuarioDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuario</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Registrar Usuario</h2>
    
    <form action="../UsuarioServlet" method="post">
        <input type="hidden" name="accion" value="registrar">
        
        <label>Nombre de Usuario:</label>
        <input type="text" name="nombre_usuario" required><br>

        <label>Contraseña:</label>
        <input type="password" name="password" required><br>

        <label>Rol:</label>
        <input type="text" name="rol" required><br>

        <input type="submit" value="Registrar">
    </form>

    <br>
    <a href="listarUsuarios.jsp">Volver a la lista de usuarios</a>
</body>
</html>

