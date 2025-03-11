package controlador;
import modelo.Devolucion;
import modelo.dao.DevolucionDAO;
import java.io.IOException;
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

        if ("registrar".equals(accion)) {
            registrarDevolucion(request, response);
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
        String fechaDevolucion = request.getParameter("fecha_devolucion");
        double perdida = Double.parseDouble(request.getParameter("perdida"));
        int idVenta = Integer.parseInt(request.getParameter("id_venta"));

        Devolucion devolucion = new Devolucion(0, fechaDevolucion, perdida, idVenta);
        devolucionDAO.agregarDevolucion(devolucion);

        response.sendRedirect("ServletDevolucion");
    }
}
