package controlador;

import modelo.Componente;
import modelo.dao.ComponenteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletComponente")
public class ServletComponente extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ComponenteDAO componenteDAO = new ComponenteDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if (accion == null) {
                listarComponentes(request, response);
            } else {
                switch (accion) {
                    case "eliminar":
                        eliminarComponente(request, response);
                        break;
                    default:
                        listarComponentes(request, response);
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
                registrarComponente(request, response);
            } else {
                response.sendRedirect("jsp/error.jsp?mensaje=Accion no reconocida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/error.jsp?mensaje=Error en el servidor");
        }
    }

    private void listarComponentes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Componente> listaComponentes = componenteDAO.obtenerComponentes();
        request.setAttribute("listaComponentes", listaComponentes);
        request.getRequestDispatcher("jsp/listarComponentes.jsp").forward(request, response);
    }

    private void registrarComponente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String nombreComponente = request.getParameter("nombre_componente");
        double costo = Double.parseDouble(request.getParameter("costo"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Obtener el último ID utilizado y sumarle 1
        int nuevoId = componenteDAO.obtenerUltimoId() + 1;

        // Crear el objeto Componente
        Componente componente = new Componente(nuevoId, nombreComponente, costo, cantidad);
        boolean registrado = componenteDAO.agregarComponente(componente);

        if (registrado) {
            response.sendRedirect("ServletComponente");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo registrar el componente");
        }
    }

    private void eliminarComponente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean eliminado = componenteDAO.eliminarComponente(id);

        if (eliminado) {
            response.sendRedirect("ServletComponente");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo eliminar el componente");
        }
    }
}