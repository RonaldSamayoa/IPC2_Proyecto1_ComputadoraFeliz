<%-- 
    Document   : registrarComponente
    Created on : 1 mar 2025, 18:57:07
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Componente" %>
<%@ page import="modelo.dao.ComponenteDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Componente</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Registrar Componente</h2>

    <form action="../ComponenteServlet" method="post">
        <input type="hidden" name="accion" value="registrar">
        
        <label>Nombre del Componente:</label>
        <input type="text" name="nombre_componente" required><br>

        <label>Costo:</label>
        <input type="number" step="0.01" name="costo" required><br>

        <label>Cantidad:</label>
        <input type="number" name="cantidad" required><br>

        <input type="submit" value="Registrar">
    </form>

    <br>
    <a href="listarComponentes.jsp">Volver a la lista de componentes</a>
</body>
</html>

