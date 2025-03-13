package controlador;

import modelo.Usuario;
import modelo.dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion == null) {
            listarUsuarios(request, response);
        } else {
            switch (accion) {
                case "agregar":
                    mostrarFormularioRegistro(request, response);
                    break;
                case "eliminar":
                    eliminarUsuario(request, response);
                    break;
                default:
                    listarUsuarios(request, response);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("registrar".equals(accion)) {
            agregarUsuario(request, response);
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();
        request.setAttribute("usuarios", listaUsuarios);
        request.getRequestDispatcher("jsp/listarUsuarios.jsp").forward(request, response);
    }

    private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("jsp/registrarUsuario.jsp").forward(request, response);
    }

    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre_usuario");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        Usuario usuario = new Usuario(0, nombre, password, rol); // ID en 0 porque es autoincremental
        usuarioDAO.agregarUsuario(usuario);
        response.sendRedirect("ServletUsuario");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        usuarioDAO.eliminarUsuario(id);
        response.sendRedirect("ServletUsuario");
    }
}

