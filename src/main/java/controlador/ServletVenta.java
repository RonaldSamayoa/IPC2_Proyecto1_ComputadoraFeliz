package controlador;

import modelo.Venta;
import modelo.dao.VentaDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        try {
            if ("registrar".equals(accion)) {
                registrarVenta(request, response);
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

    private void listarVentas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venta> listaVentas = ventaDAO.obtenerVentas();
        request.setAttribute("listaVentas", listaVentas);
        request.getRequestDispatcher("jsp/listarVentas.jsp").forward(request, response);
    }

    private void registrarVenta(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // Obtener parámetros
        String fechaVentaStr = request.getParameter("fecha_venta");
        double totalVenta = Double.parseDouble(request.getParameter("total_venta"));
        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));

        // Convertir fecha
        LocalDate fechaVenta = LocalDate.parse(fechaVentaStr);

        // Crear objeto Venta
        Venta venta = new Venta(0, fechaVenta, totalVenta, idCliente, idUsuario);

        // Registrar en la base de datos
        boolean registrado = ventaDAO.agregarVenta(venta);

        if (registrado) {
            // Redirigir al listado de ventas si todo está bien
            response.sendRedirect("ServletVenta");
        } else {
            // Redirigir a una página de error si no se pudo registrar
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo registrar la venta");
        }
    }
}
