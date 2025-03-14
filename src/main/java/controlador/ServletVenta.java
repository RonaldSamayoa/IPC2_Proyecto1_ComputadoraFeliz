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
        String accion = request.getParameter("accion");

        try {
            if (accion == null) {
                listarVentas(request, response);
            } else {
                switch (accion) {
                    case "eliminar":
                        eliminarVenta(request, response);
                        break;
                    default:
                        listarVentas(request, response);
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
                registrarVenta(request, response);
            } else {
                response.sendRedirect("jsp/error.jsp?mensaje=Accion no reconocida");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        // Obtener los parámetros del formulario
        String fechaVentaStr = request.getParameter("fecha_venta");
        double totalVenta = Double.parseDouble(request.getParameter("total_venta"));
        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));

        // Convertir fecha de String a LocalDate
        LocalDate fechaVenta = LocalDate.parse(fechaVentaStr); // Formato esperado: yyyy-MM-dd

        // Obtener el último ID utilizado y sumarle 1
        int nuevoId = ventaDAO.obtenerUltimoId() + 1;

        // Crear el objeto Venta
        Venta venta = new Venta(nuevoId, fechaVenta, totalVenta, idCliente, idUsuario);
        boolean registrado = ventaDAO.agregarVenta(venta);

        if (registrado) {
            response.sendRedirect("ServletVenta");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo registrar la venta");
        }
    }

    private void eliminarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean eliminado = ventaDAO.eliminarVenta(id);

        if (eliminado) {
            response.sendRedirect("ServletVenta");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo eliminar la venta");
        }
    }
}