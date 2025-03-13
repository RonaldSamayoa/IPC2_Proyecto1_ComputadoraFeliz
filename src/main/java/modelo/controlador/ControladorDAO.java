package modelo.controlador;
import modelo.Usuario;
import modelo.Cliente;
import modelo.Computadora;
import modelo.Componente;
import modelo.Venta;
import modelo.Ensamblaje;
import modelo.Devolucion;
import modelo.dao.UsuarioDAO;
import modelo.dao.ClienteDAO;
import modelo.dao.ComputadoraDAO;
import modelo.dao.ComponenteDAO;
import modelo.dao.VentaDAO;
import modelo.dao.EnsamblajeDAO;
import modelo.dao.DevolucionDAO;
import java.util.List;

public class ControladorDAO {
    private UsuarioDAO usuarioDAO;
    private ClienteDAO clienteDAO;
    private ComputadoraDAO computadoraDAO;
    private ComponenteDAO componenteDAO;
    private VentaDAO ventaDAO;
    private EnsamblajeDAO ensamblajeDAO;
    private DevolucionDAO devolucionDAO;

    public ControladorDAO() {
        this.usuarioDAO = new UsuarioDAO();
        this.clienteDAO = new ClienteDAO();
        this.computadoraDAO = new ComputadoraDAO();
        this.componenteDAO = new ComponenteDAO();
        this.ventaDAO = new VentaDAO();
        this.ensamblajeDAO = new EnsamblajeDAO();
        this.devolucionDAO = new DevolucionDAO();
    }

    // Métodos para gestionar Usuarios
    public boolean agregarUsuario(Usuario usuario) {
        return usuarioDAO.agregarUsuario(usuario);
    }
    
    public List<Usuario> obtenerUsuarios() {
        return usuarioDAO.obtenerUsuarios();
    }
    public boolean eliminarUsuario(int id) {
        return usuarioDAO.eliminarUsuario(id);
    }

    // Métodos para gestionar Clientes
    public boolean agregarCliente(Cliente cliente) {
        return clienteDAO.agregarCliente(cliente);
    }
    
    public List<Cliente> obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }
    public boolean eliminarCliente(int id) {
        return clienteDAO.eliminarCliente(id);
    }

    // Métodos para gestionar Computadoras
    public boolean agregarComputadora(Computadora computadora) {
        return computadoraDAO.agregarComputadora(computadora);
    }
    
    public List<Computadora> obtenerComputadoras() {
        return computadoraDAO.obtenerComputadoras();
    }
    public boolean eliminarComputadora(int id) {
        return computadoraDAO.eliminarComputadora(id);
    }

    // Métodos para gestionar Componentes
    public boolean agregarComponente(Componente componente) {
        return componenteDAO.agregarComponente(componente);
    }
    
    public List<Componente> obtenerComponentes() {
        return componenteDAO.obtenerComponentes();
    }
    
    public boolean eliminarComponente(int id) {
        return componenteDAO.eliminarComponente(id);
    }
}
