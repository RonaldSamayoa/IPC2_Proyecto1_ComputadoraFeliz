package controlador;

import modelo.Devolucion;
import modelo.dao.DevolucionDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletDevolucion")
public class ServletDevolucion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DevolucionDAO devolucionDAO = new DevolucionDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if (accion == null) {
                listarDevoluciones(request, response);
            } else {
                switch (accion) {
                    case "eliminar":
                        eliminarDevolucion(request, response);
                        break;
                    default:
                        listarDevoluciones(request, response);
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
                registrarDevolucion(request, response);
            } else {
                response.sendRedirect("jsp/error.jsp?mensaje=Accion no reconocida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/error.jsp?mensaje=Error en el servidor");
        }
    }

    private void listarDevoluciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Devolucion> listaDevoluciones = devolucionDAO.obtenerDevoluciones();
        request.setAttribute("listaDevoluciones", listaDevoluciones);
        request.getRequestDispatcher("jsp/listarDevoluciones.jsp").forward(request, response);
    }

    private void registrarDevolucion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String fechaDevolucionStr = request.getParameter("fecha_devolucion");
        double perdida = Double.parseDouble(request.getParameter("perdida"));
        int idVenta = Integer.parseInt(request.getParameter("id_venta"));

        // Convertir fecha de String a LocalDate
        LocalDate fechaDevolucion = LocalDate.parse(fechaDevolucionStr); // Formato esperado: yyyy-MM-dd

        // Obtener el último ID utilizado y sumarle 1
        int nuevoId = devolucionDAO.obtenerUltimoId() + 1;

        // Crear el objeto Devolucion
        Devolucion devolucion = new Devolucion(nuevoId, fechaDevolucion, perdida, idVenta);
        boolean registrado = devolucionDAO.agregarDevolucion(devolucion);

        if (registrado) {
            response.sendRedirect("ServletDevolucion");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo registrar la devolucion");
        }
    }

    private void eliminarDevolucion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean eliminado = devolucionDAO.eliminarDevolucion(id);

        if (eliminado) {
            response.sendRedirect("ServletDevolucion");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo eliminar la devolucion");
        }
    }
}