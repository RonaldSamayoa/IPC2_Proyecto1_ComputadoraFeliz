package controlador;

import modelo.Usuario;
import modelo.dao.UsuarioDAO;
import util.ConexionBD;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletPruebaConexion", urlPatterns = {"/ServletPruebaConexion"})
public class ServletPruebaConexion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = ConexionBD.getConnection();
        if (conn != null) {
            System.out.println("🚀 Conexión exitosa en el Servlet.");
        } else {
            System.out.println("❌ Error en la conexión.");
        }

        // Obtener la lista de usuarios desde la BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();

        // Imprimir en consola los usuarios obtenidos
        for (Usuario usuario : listaUsuarios) {
            System.out.println("Usuario: " + usuario.getId_usuario() + " - " + usuario.getNombre_usuario());
        }

        // Enviar la lista de usuarios al JSP
        request.setAttribute("usuarios", listaUsuarios);
        request.getRequestDispatcher("vistas/pruebaConexion.jsp").forward(request, response);
    }
}
