package controlador;
import modelo.Cliente;
import modelo.dao.ClienteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para gestionar Clientes
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ClienteDAO clienteDAO = new ClienteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion == null) {
            listarClientes(request, response);
        } else {
            switch (accion) {
                case "eliminar":
                    eliminarCliente(request, response);
                    break;
                default:
                    listarClientes(request, response);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("registrar".equals(accion)) {
            registrarCliente(request, response);
        }
    }

    private void listarClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();
        request.setAttribute("listaClientes", listaClientes);
        request.getRequestDispatcher("jsp/listarClientes.jsp").forward(request, response);
    }

    private void registrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nit = request.getParameter("nit");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");

        Cliente cliente = new Cliente(0, nit, nombre, direccion);
        clienteDAO.agregarCliente(cliente);

        response.sendRedirect("ServletCliente");
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        clienteDAO.eliminarCliente(id);
        response.sendRedirect("ServletCliente");
    }
}
