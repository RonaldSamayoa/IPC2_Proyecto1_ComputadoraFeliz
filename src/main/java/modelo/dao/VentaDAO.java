package modelo.dao;
import modelo.Venta;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private List<Venta> ventas;

    public VentaDAO() {
        this.ventas = new ArrayList<>();
    }

    // Verificar si el ID ya existe
    private boolean existeId(int id) {
        for (Venta venta : ventas) {
            if (venta.getId_venta() == id) {
                return true;
            }
        }
        return false;
    }

    // Agregar venta manualmente con verificación de ID único
    public boolean agregarVenta(Venta venta) {
        if (!existeId(venta.getId_venta())) {
            ventas.add(venta);
            return true;
        }
        return false;
    }

    // Obtener todas las ventas
    public List<Venta> obtenerVentas() {
        return ventas;
    }

    // Buscar venta por ID
    public Venta buscarVentaPorId(int id) {
        for (Venta venta : ventas) {
            if (venta.getId_venta() == id) {
                return venta;
            }
        }
        return null;
    }

    // Eliminar venta por ID
    public boolean eliminarVenta(int id) {
        return ventas.removeIf(venta -> venta.getId_venta() == id);
    }
}
