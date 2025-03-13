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

/**
 *
 * @author ronald
 */
@WebServlet("/ServletDevolucion")
public class ServletDevolucion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DevolucionDAO devolucionDAO = new DevolucionDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listarDevoluciones(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if ("registrar".equals(accion)) {
                registrarDevolucion(request, response);
            } else {
                // Acción no reconocida
                response.sendRedirect("jsp/error.jsp?mensaje=Accion no reconocida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Redirigir a una página de error en caso de excepción
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
        // Obtener parámetros
        String fechaDevolucionStr = request.getParameter("fecha_devolucion");
        double perdida = Double.parseDouble(request.getParameter("perdida"));
        int idVenta = Integer.parseInt(request.getParameter("id_venta"));

        // Convertir fecha de String a LocalDate
        LocalDate fechaDevolucion = LocalDate.parse(fechaDevolucionStr); // Formato esperado: yyyy-MM-dd

        // Crear objeto Devolucion
        Devolucion devolucion = new Devolucion(0, fechaDevolucion, perdida, idVenta);

        // Registrar en la base de datos
        boolean registrado = devolucionDAO.agregarDevolucion(devolucion);

        if (registrado) {
            // Redirigir al listado de devoluciones si todo está bien
            response.sendRedirect("ServletDevolucion");
        } else {
            // Redirigir a una página de error si no se pudo registrar
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo registrar la devolucion");
        }
    }
}
