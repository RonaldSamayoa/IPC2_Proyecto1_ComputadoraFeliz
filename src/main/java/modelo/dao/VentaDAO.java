package modelo.dao;

import modelo.Venta;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private Connection conn;

    public VentaDAO() {
        this.conn = ConexionBD.getConnection();
    }

    public boolean agregarVenta(Venta venta) {
        String sql = "INSERT INTO Venta (id_venta, fecha_venta, total_venta, id_cliente, id_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, venta.getId_venta());
            stmt.setDate(2, Date.valueOf(venta.getFecha_venta()));
            stmt.setDouble(3, venta.getTotal_venta());
            stmt.setInt(4, venta.getId_cliente());
            stmt.setInt(5, venta.getId_usuario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Venta> obtenerVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM Venta";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Venta(
                        rs.getInt("id_venta"),
                        rs.getDate("fecha_venta").toLocalDate(),
                        rs.getDouble("total_venta"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_usuario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int obtenerUltimoId() {
        String sql = "SELECT MAX(id_venta) AS max_id FROM Venta";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("max_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Si no hay registros, empezamos desde 0
    }
    
    public boolean eliminarVenta(int id) {
        String sql = "DELETE FROM Venta WHERE id_venta = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


