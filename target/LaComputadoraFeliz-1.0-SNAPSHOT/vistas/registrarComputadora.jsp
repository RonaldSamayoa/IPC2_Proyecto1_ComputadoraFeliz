<%-- 
    Document   : registrarComputadora
    Created on : 8 mar 2025, 10:18:55
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Computadora" %>
<%@ page import="modelo.dao.ComputadoraDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Computadora</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Registrar Computadora</h2>

    <form action="../ServletComputadora" method="post">
        <input type="hidden" name="accion" value="registrar">

        <label>Nombre de la Computadora:</label>
        <input type="text" name="nombre_computadora" required><br>

        <label>Precio de Venta:</label>
        <input type="number" step="0.01" name="precio_venta" required><br>

        <label>Fecha de Ensamblaje:</label>
        <input type="date" name="fecha_ensamblaje" required><br>

        <label>ID Usuario:</label>
        <input type="number" name="id_usuario" required><br>

        <input type="submit" value="Registrar">
    </form>

    <br>
    <a href="listarComputadoras.jsp">Volver a la lista de computadoras</a>
</body>
</html>

