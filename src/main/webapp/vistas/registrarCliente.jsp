<%-- 
    Document   : registrarCliente
    Created on : 8 mar 2025, 14:33:03
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Cliente" %>
<%@ page import="modelo.dao.ClienteDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Cliente</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Registrar Cliente</h2>

    <form action="../ClienteServlet" method="post">
        <input type="hidden" name="accion" value="registrar">
        
        <label>NIT:</label>
        <input type="text" name="nit" required><br>

        <label>Nombre:</label>
        <input type="text" name="nombre" required><br>

        <label>Dirección:</label>
        <input type="text" name="direccion" required><br>

        <input type="submit" value="Registrar">
    </form>

    <br>
    <a href="listarClientes.jsp">Volver a la lista de clientes</a>
</body>
</html>
