package modelo.dao;
import modelo.Componente;
import java.util.ArrayList;
import java.util.List;

public class ComponenteDAO {
    private List<Componente> componentes;

    public ComponenteDAO() {
        this.componentes = new ArrayList<>();
    }

    // Verificar si el ID ya existe
    private boolean existeId(int id) {
        for (Componente componente : componentes) {
            if (componente.getId_componente() == id) {
                return true;
            }
        }
        return false;
    }

    // Agregar componente manualmente con verificación de ID único
    public boolean agregarComponente(Componente componente) {
        if (!existeId(componente.getId_componente())) {
            componentes.add(componente);
            return true;
        }
        return false;
    }

    // Obtener todos los componentes
    public List<Componente> obtenerComponentes() {
        return componentes;
    }

    // Buscar componente por ID
    public Componente buscarComponentePorId(int id) {
        for (Componente componente : componentes) {
            if (componente.getId_componente() == id) {
                return componente;
            }
        }
        return null;
    }

    // Eliminar componente por ID
    public boolean eliminarComponente(int id) {
        return componentes.removeIf(componente -> componente.getId_componente() == id);
    }
}
