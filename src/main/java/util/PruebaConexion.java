package util;
import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
     public static void main(String[] args) {
        Connection conn = ConexionBD.getConnection();
        if (conn != null) {
            System.out.println("🚀 Conexión exitosa.");
            ConexionBD.closeConnection(conn);
        } else {
            System.out.println("⚠️ Error en la conexión.");
        }
    }
}
