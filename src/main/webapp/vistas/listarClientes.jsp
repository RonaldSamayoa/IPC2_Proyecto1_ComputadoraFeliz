<%-- 
    Document   : listarClientes
    Created on : 8 mar 2025, 11:13:00
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Cliente" %>
<%@ page import="modelo.dao.ClienteDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Lista de Clientes</h2>
    
    <table border="1">
        <tr>
            <th>ID Cliente</th>
            <th>NIT</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Acciones</th>
        </tr>
        <%
            ClienteDAO clienteDAO = new ClienteDAO();
            List<Cliente> listaClientes = clienteDAO.obtenerClientes();
            for (Cliente cliente : listaClientes) {
        %>
        <tr>
            <td><%= cliente.getId_cliente() %></td>
            <td><%= cliente.getNit() %></td>
            <td><%= cliente.getNombre() %></td>
            <td><%= cliente.getDireccion() %></td>
            <td>
            <a href="../ServletCliente?accion=eliminar&id=<%= cliente.getId_cliente() %>" onclick="return confirm('¿Seguro que deseas eliminar este cliente?');">Eliminar</a>
        </td>
    </tr>
        <%
            }
        %>
    </table>
    
    <br>
    <a href="registrarCliente.jsp">Registrar Cliente</a> |
    <a href="../index.html">Volver al inicio</a>
</body>
</html>


