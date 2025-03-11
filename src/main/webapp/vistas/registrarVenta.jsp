<%-- 
    Document   : registrarVenta
    Created on : 8 mar 2025, 14:34:20
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Venta" %>
<%@ page import="modelo.dao.VentaDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Venta</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Registrar Venta</h2>

    <form action="../VentaServlet" method="post">
        <input type="hidden" name="accion" value="registrar">
        
        <label>Fecha de Venta:</label>
        <input type="date" name="fecha_venta" required><br>

        <label>Total Venta:</label>
        <input type="number" step="0.01" name="total_venta" required><br>

        <label>ID Cliente:</label>
        <input type="number" name="id_cliente" required><br>

        <label>ID Usuario:</label>
        <input type="number" name="id_usuario" required><br>

        <input type="submit" value="Registrar">
    </form>

    <br>
    <a href="listarVentas.jsp">Volver a la lista de ventas</a>
</body>
</html>

