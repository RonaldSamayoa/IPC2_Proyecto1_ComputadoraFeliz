package modelo.dao;

import modelo.Usuario;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() {
        this.conn = ConexionBD.getConnection();
    }

    public boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nombre_usuario, password, rol) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre_usuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getRol());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre_usuario"),
                        rs.getString("password"),
                        rs.getString("rol")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}



