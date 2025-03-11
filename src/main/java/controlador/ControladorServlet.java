package controlador;
import modelo.Usuario;
import modelo.controlador.ControladorDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorServlet", urlPatterns = {"/ControladorServlet"})
public class ControladorServlet extends HttpServlet {
    private ControladorDAO controlador;

    @Override
    public void init() throws ServletException {
        controlador = new ControladorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {
            case "listar":
                listarUsuarios(request, response);
                break;
            case "eliminar":
                eliminarUsuario(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        switch (accion) {
            case "registrar":
                registrarUsuario(request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = controlador.obtenerUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        Usuario usuario = new Usuario(id, nombre, password, rol);
        controlador.agregarUsuario(usuario);
        response.sendRedirect("ControladorServlet?accion=listar");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        controlador.eliminarUsuario(id);
        response.sendRedirect("ControladorServlet?accion=listar");
    }
}
