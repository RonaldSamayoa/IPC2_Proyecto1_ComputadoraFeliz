package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ronald
 */
public class ConexionBD {
    // Datos de conexión a la base de datos en Docker
    private static final String URL = "jdbc:mysql://172.17.0.2:3306/computadora_feliz?serverTimezone=UTC";
    private static final String USER = "root";  
    private static final String PASSWORD = "123";  

    // Método para obtener la conexión
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Registrar el driver de MySQL (opcional en algunas versiones)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intentar la conexión
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return conn;
    }

    // Método para cerrar la conexión (buena práctica)
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
            closeConnection(conn);
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}
