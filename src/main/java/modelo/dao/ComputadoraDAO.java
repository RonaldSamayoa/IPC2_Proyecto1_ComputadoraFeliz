package modelo.dao;
import modelo.Computadora;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComputadoraDAO {
    private Connection conn;

    public ComputadoraDAO() {
        this.conn = ConexionBD.getConnection();
    }

    public boolean agregarComputadora(Computadora computadora) {
        String sql = "INSERT INTO Computadora (id_computadora, nombre_computadora, precio_venta, fecha_ensamblaje, id_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, computadora.getId_computadora());
            stmt.setString(2, computadora.getNombre_computadora());
            stmt.setDouble(3, computadora.getPrecio_venta());
            stmt.setDate(4, Date.valueOf(computadora.getFecha_ensamblaje()));
            stmt.setInt(5, computadora.getId_usuario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Computadora> obtenerComputadoras() {
        List<Computadora> lista = new ArrayList<>();
        String sql = "SELECT * FROM Computadora";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Computadora(
                        rs.getInt("id_computadora"),
                        rs.getString("nombre_computadora"),
                        rs.getDouble("precio_venta"),
                        rs.getDate("fecha_ensamblaje").toLocalDate(),
                        rs.getInt("id_usuario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public int obtenerUltimoId() {
        String sql = "SELECT MAX(id_computadora) AS max_id FROM Computadora";
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

    public boolean eliminarComputadora(int id) {
        String sql = "DELETE FROM Computadora WHERE id_computadora = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
