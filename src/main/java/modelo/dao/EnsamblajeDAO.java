package modelo.dao;

import modelo.Ensamblaje;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnsamblajeDAO {
    private Connection conn;

    public EnsamblajeDAO() {
        this.conn = ConexionBD.getConnection();
    }

    public boolean agregarEnsamblaje(Ensamblaje ensamblaje) {
        String sql = "INSERT INTO Ensamblaje (id_ensamblaje, id_computadora, id_componente, cantidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ensamblaje.getId_ensamblaje());
            stmt.setInt(2, ensamblaje.getId_computadora());
            stmt.setInt(3, ensamblaje.getId_componente());
            stmt.setInt(4, ensamblaje.getCantidad());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Ensamblaje> obtenerEnsamblajes() {
        List<Ensamblaje> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ensamblaje";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Ensamblaje(
                        rs.getInt("id_ensamblaje"),
                        rs.getInt("id_computadora"),
                        rs.getInt("id_componente"),
                        rs.getInt("cantidad")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int obtenerUltimoId() {
        String sql = "SELECT MAX(id_ensamblaje) AS max_id FROM Ensamblaje";
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
    
    public boolean eliminarEnsamblaje(int id) {
        String sql = "DELETE FROM Ensamblaje WHERE id_ensamblaje = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
