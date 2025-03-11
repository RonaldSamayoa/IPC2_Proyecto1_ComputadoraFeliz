package controlador;
import modelo.Venta;
import modelo.dao.VentaDAO;
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
@WebServlet("/ServletVenta")
public class ServletVenta extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private VentaDAO ventaDAO = new VentaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listarVentas(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("registrar".equals(accion)) {
            registrarVenta(request, response);
        }
    }

    private void listarVentas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venta> listaVentas = ventaDAO.obtenerVentas();
        request.setAttribute("listaVentas", listaVentas);
        request.getRequestDispatcher("jsp/listarVentas.jsp").forward(request, response);
    }

    private void registrarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fechaVenta = request.getParameter("fecha_venta");
        double totalVenta = Double.parseDouble(request.getParameter("total_venta"));
        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));

        Venta venta = new Venta(0, fechaVenta, totalVenta, idCliente, idUsuario);
        ventaDAO.agregarVenta(venta);

        response.sendRedirect("ServletVenta");
    }
}
