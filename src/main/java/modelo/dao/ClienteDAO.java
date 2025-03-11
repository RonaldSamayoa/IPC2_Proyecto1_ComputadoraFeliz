package modelo.dao;
import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private List<Cliente> clientes;

    public ClienteDAO() {
        this.clientes = new ArrayList<>();
    }

    // Verificar si el ID ya existe
    private boolean existeId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId_cliente() == id) {
                return true;
            }
        }
        return false;
    }

    // Agregar cliente manualmente con verificación de ID único
    public boolean agregarCliente(Cliente cliente) {
        if (!existeId(cliente.getId_cliente())) {
            clientes.add(cliente);
            return true;
        }
        return false;
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    // Buscar cliente por ID
    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId_cliente() == id) {
                return cliente;
            }
        }
        return null;
    }

    // Eliminar cliente por ID
    public boolean eliminarCliente(int id) {
        return clientes.removeIf(cliente -> cliente.getId_cliente() == id);
    }
}
