package controlador;

import modelo.Ensamblaje;
import modelo.dao.EnsamblajeDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletEnsamblaje")
public class ServletEnsamblaje extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EnsamblajeDAO ensamblajeDAO = new EnsamblajeDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if (accion == null) {
                listarEnsamblajes(request, response);
            } else {
                switch (accion) {
                    case "eliminar":
                        eliminarEnsamblaje(request, response);
                        break;
                    default:
                        listarEnsamblajes(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/error.jsp?mensaje=Error en el servidor");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if ("registrar".equals(accion)) {
                registrarEnsamblaje(request, response);
            } else {
                response.sendRedirect("jsp/error.jsp?mensaje=Accion no reconocida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/error.jsp?mensaje=Error en el servidor");
        }
    }

    private void listarEnsamblajes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Ensamblaje> listaEnsamblajes = ensamblajeDAO.obtenerEnsamblajes();
        request.setAttribute("listaEnsamblajes", listaEnsamblajes);
        request.getRequestDispatcher("jsp/listarEnsamblajes.jsp").forward(request, response);
    }

    private void registrarEnsamblaje(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        int idComputadora = Integer.parseInt(request.getParameter("id_computadora"));
        int idComponente = Integer.parseInt(request.getParameter("id_componente"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Obtener el último ID utilizado y sumarle 1
        int nuevoId = ensamblajeDAO.obtenerUltimoId() + 1;

        // Crear el objeto Ensamblaje
        Ensamblaje ensamblaje = new Ensamblaje(nuevoId, idComputadora, idComponente, cantidad);
        boolean registrado = ensamblajeDAO.agregarEnsamblaje(ensamblaje);

        if (registrado) {
            response.sendRedirect("ServletEnsamblaje");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo registrar el ensamblaje");
        }
    }

    private void eliminarEnsamblaje(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean eliminado = ensamblajeDAO.eliminarEnsamblaje(id);

        if (eliminado) {
            response.sendRedirect("ServletEnsamblaje");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo eliminar el ensamblaje");
        }
    }
}