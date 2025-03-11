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
                    case "buscar":
                        buscarUsuario(request, response);
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
            agregarUsuario(request, response);
        }

        private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
            List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();
            request.setAttribute("usuarios", listaUsuarios);
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        }

        private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
            request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
        }

        private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            String rol = request.getParameter("rol");

            Usuario usuario = new Usuario(id, nombre, password, rol);
            usuarioDAO.agregarUsuario(usuario);
            response.sendRedirect("ServletUsuario");
        }

        private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);

            if (usuario != null) {
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("detalleUsuario.jsp").forward(request, response);
            } else {
                response.sendRedirect("ServletUsuario");
            }
        }

        private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            usuarioDAO.eliminarUsuario(id);
            response.sendRedirect("ServletUsuario");
        }
}
