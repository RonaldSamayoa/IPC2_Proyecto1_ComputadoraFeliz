package modelo.dao;
import java.time.LocalDate;
import modelo.Devolucion;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevolucionDAO {
    private Connection conn;

    public DevolucionDAO() {
        this.conn = ConexionBD.getConnection();
    }

    public boolean agregarDevolucion(Devolucion devolucion) {
        String sql = "INSERT INTO Devolucion (id_devolucion, fecha_devolucion, perdida, id_venta) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, devolucion.getId_devolucion());
            stmt.setDate(2, Date.valueOf(devolucion.getFecha_devolucion()));
            stmt.setDouble(3, devolucion.getPerdida());
            stmt.setInt(4, devolucion.getId_venta());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Devolucion> obtenerDevoluciones() {
        List<Devolucion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Devolucion";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Devolucion(
                        rs.getInt("id_devolucion"),
                        rs.getDate("fecha_devolucion").toLocalDate(),
                        rs.getDouble("perdida"),
                        rs.getInt("id_venta")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int obtenerUltimoId() {
        String sql = "SELECT MAX(id_devolucion) AS max_id FROM Devolucion";
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
    
    public boolean eliminarDevolucion(int id) {
        String sql = "DELETE FROM Devolucion WHERE id_devolucion = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
