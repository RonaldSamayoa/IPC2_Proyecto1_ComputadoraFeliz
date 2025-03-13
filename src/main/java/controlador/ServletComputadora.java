package controlador;

import modelo.Computadora;
import modelo.dao.ComputadoraDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletComputadora")
public class ServletComputadora extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ComputadoraDAO computadoraDAO = new ComputadoraDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        try {
            if (accion == null) {
                listarComputadoras(request, response);
            } else {
                switch (accion) {
                    case "eliminar":
                        eliminarComputadora(request, response);
                        break;
                    default:
                        listarComputadoras(request, response);
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
                registrarComputadora(request, response);
            } else {
                response.sendRedirect("jsp/error.jsp?mensaje=Accion no reconocida");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/error.jsp?mensaje=Error en el servidor");
        }
    }

    private void listarComputadoras(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Computadora> listaComputadoras = computadoraDAO.obtenerComputadoras();
        request.setAttribute("listaComputadoras", listaComputadoras);
        request.getRequestDispatcher("jsp/listarComputadoras.jsp").forward(request, response);
    }

    private void registrarComputadora(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String nombreComputadora = request.getParameter("nombre_computadora");
        double precioVenta = Double.parseDouble(request.getParameter("precio_venta"));
        LocalDate fechaEnsamblaje = LocalDate.parse(request.getParameter("fecha_ensamblaje"));
        int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));

        // Obtener el último ID utilizado y sumarle 1
        int nuevoId = computadoraDAO.obtenerUltimoId() + 1;

        // Crear el objeto Computadora
        Computadora computadora = new Computadora(nuevoId, nombreComputadora, precioVenta, fechaEnsamblaje, idUsuario);
        boolean registrado = computadoraDAO.agregarComputadora(computadora);

        if (registrado) {
            response.sendRedirect("ServletComputadora");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo registrar la computadora");
        }
    }

    private void eliminarComputadora(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean eliminado = computadoraDAO.eliminarComputadora(id);

        if (eliminado) {
            response.sendRedirect("ServletComputadora");
        } else {
            response.sendRedirect("jsp/error.jsp?mensaje=No se pudo eliminar la computadora");
        }
    }
}

