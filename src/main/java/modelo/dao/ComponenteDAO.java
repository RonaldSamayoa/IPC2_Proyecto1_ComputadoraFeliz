package modelo.dao;
import modelo.Componente;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComponenteDAO {
    private Connection conn;

    public ComponenteDAO() {
        this.conn = ConexionBD.getConnection();
    }

    public boolean agregarComponente(Componente componente) {
        String sql = "INSERT INTO Componente (id_componente, nombre_componente, costo, cantidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, componente.getId_componente());
            stmt.setString(2, componente.getNombre_componente());
            stmt.setDouble(3, componente.getCosto());
            stmt.setInt(4, componente.getCantidad());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Componente> obtenerComponentes() {
        List<Componente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Componente";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Componente(
                        rs.getInt("id_componente"),
                        rs.getString("nombre_componente"),
                        rs.getDouble("costo"),
                        rs.getInt("cantidad")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean eliminarComponente(int id) {
        String sql = "DELETE FROM Componente WHERE id_componente = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
