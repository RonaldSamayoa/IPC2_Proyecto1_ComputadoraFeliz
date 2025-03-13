package modelo.dao;

import modelo.Cliente;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO() {
        this.conn = ConexionBD.getConnection();
    }

    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (id_cliente, nit, nombre, direccion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId_cliente());
            stmt.setString(2, cliente.getNit());
            stmt.setString(3, cliente.getNombre());
            stmt.setString(4, cliente.getDireccion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cliente> obtenerClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nit"),
                        rs.getString("nombre"),
                        rs.getString("direccion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean eliminarCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


