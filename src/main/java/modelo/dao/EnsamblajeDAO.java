package modelo.dao;
import modelo.Ensamblaje;
import java.util.ArrayList;
import java.util.List;

public class EnsamblajeDAO {
    private List<Ensamblaje> ensamblajes;

    public EnsamblajeDAO() {
        this.ensamblajes = new ArrayList<>();
    }

    // Verificar si el ID ya existe
    private boolean existeId(int id) {
        for (Ensamblaje ensamblaje : ensamblajes) {
            if (ensamblaje.getId_ensamblaje() == id) {
                return true;
            }
        }
        return false;
    }

    // Agregar ensamblaje manualmente con verificación de ID único
    public boolean agregarEnsamblaje(Ensamblaje ensamblaje) {
        if (!existeId(ensamblaje.getId_ensamblaje())) {
            ensamblajes.add(ensamblaje);
            return true;
        }
        return false;
    }

    // Obtener todos los ensamblajes
    public List<Ensamblaje> obtenerEnsamblajes() {
        return ensamblajes;
    }

    // Buscar ensamblaje por ID
    public Ensamblaje buscarEnsamblajePorId(int id) {
        for (Ensamblaje ensamblaje : ensamblajes) {
            if (ensamblaje.getId_ensamblaje() == id) {
                return ensamblaje;
            }
        }
        return null;
    }

    // Eliminar ensamblaje por ID
    public boolean eliminarEnsamblaje(int id) {
        return ensamblajes.removeIf(ensamblaje -> ensamblaje.getId_ensamblaje() == id);
    }
}
