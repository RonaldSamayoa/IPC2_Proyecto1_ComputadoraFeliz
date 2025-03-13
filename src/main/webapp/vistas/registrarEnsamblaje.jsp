<%-- 
    Document   : registrarEnsamblaje
    Created on : 12 mar 2025, 21:58:06
    Author     : ronald
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Ensamblaje</title>
    <link rel="stylesheet" type="text/css" href="../css/estilos.css">
</head>
<body>
    <h2>Registrar Ensamblaje</h2>

    <form action="../ServletEnsamblaje" method="post">
        <input type="hidden" name="accion" value="registrar">
        
        <label>ID Computadora:</label>
        <input type="number" name="id_computadora" required><br>

        <label>ID Componente:</label>
        <input type="number" name="id_componente" required><br>

        <label>Cantidad:</label>
        <input type="number" name="cantidad" required><br>

        <input type="submit" value="Registrar">
    </form>

    <br>
    <a href="listarEnsamblajes.jsp">Volver a la lista de ensamblajes</a>
</body>
</html>
