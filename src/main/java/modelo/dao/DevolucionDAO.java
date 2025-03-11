package modelo.dao;
import modelo.Devolucion;
import java.util.ArrayList;
import java.util.List;

public class DevolucionDAO {
    private List<Devolucion> devoluciones;

    public DevolucionDAO() {
        this.devoluciones = new ArrayList<>();
    }

    // Verificar si el ID ya existe
    private boolean existeId(int id) {
        for (Devolucion devolucion : devoluciones) {
            if (devolucion.getId_devolucion() == id) {
                return true;
            }
        }
        return false;
    }

    // Agregar devolución manualmente con verificación de ID único
    public boolean agregarDevolucion(Devolucion devolucion) {
        if (!existeId(devolucion.getId_devolucion())) {
            devoluciones.add(devolucion);
            return true;
        }
        return false;
    }

    // Obtener todas las devoluciones
    public List<Devolucion> obtenerDevoluciones() {
        return devoluciones;
    }

    // Buscar devolución por ID
    public Devolucion buscarDevolucionPorId(int id) {
        for (Devolucion devolucion : devoluciones) {
            if (devolucion.getId_devolucion() == id) {
                return devolucion;
            }
        }
        return null;
    }

    // Eliminar devolución por ID
    public boolean eliminarDevolucion(int id) {
        return devoluciones.removeIf(devolucion -> devolucion.getId_devolucion() == id);
    }
}
