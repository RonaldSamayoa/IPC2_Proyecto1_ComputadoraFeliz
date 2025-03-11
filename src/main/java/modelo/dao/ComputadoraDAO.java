package modelo.dao;
import modelo.Computadora;
import java.util.ArrayList;
import java.util.List;

public class ComputadoraDAO {
    private List<Computadora> computadoras;

    public ComputadoraDAO() {
        this.computadoras = new ArrayList<>();
    }

    // Verificar si el ID ya existe
    private boolean existeId(int id) {
        for (Computadora computadora : computadoras) {
            if (computadora.getId_computadora() == id) {
                return true;
            }
        }
        return false;
    }

    // Agregar computadora manualmente con verificación de ID único
    public boolean agregarComputadora(Computadora computadora) {
        if (!existeId(computadora.getId_computadora())) {
            computadoras.add(computadora);
            return true;
        }
        return false;
    }

    // Obtener todas las computadoras
    public List<Computadora> obtenerComputadoras() {
        return computadoras;
    }

    // Buscar computadora por ID
    public Computadora buscarComputadoraPorId(int id) {
        for (Computadora computadora : computadoras) {
            if (computadora.getId_computadora() == id) {
                return computadora;
            }
        }
        return null;
    }

    // Eliminar computadora por ID
    public boolean eliminarComputadora(int id) {
        return computadoras.removeIf(computadora -> computadora.getId_computadora() == id);
    }
}
