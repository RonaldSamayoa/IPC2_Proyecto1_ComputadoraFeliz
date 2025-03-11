<%-- 
    Document   : registrarDevolucion
    Created on : 8 mar 2025, 11:04:23
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="modelo.Venta" %>
<%@ page import="modelo.dao.VentaDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Devolución</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Registrar Devolución</h2>

    <form action="ServletDevolucion" method="post">
        <input type="hidden" name="accion" value="registrar">
        
        <label>Venta Asociada:</label>
        <select name="id_venta" required>
            <%
                VentaDAO ventaDAO = new VentaDAO();
                List<Venta> listaVentas = ventaDAO.obtenerVentas();
                for (Venta venta : listaVentas) {
            %>
            <option value="<%= venta.getId_venta() %>">Venta ID: <%= venta.getId_venta() %> - Cliente: <%= venta.getId_cliente() %></option>
            <%
                }
            %>
        </select><br>

        <label>Motivo:</label>
        <textarea name="motivo" required></textarea><br>

        <label>Fecha de Devolución:</label>
        <input type="date" name="fecha_devolucion" required><br>

        <input type="submit" value="Registrar">
    </form>

    <br>
    <a href="listarDevoluciones.jsp">Volver a la lista</a>
</body>
</html>

