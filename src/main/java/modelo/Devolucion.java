package modelo;

public class Devolucion {
    private int id_devolucion;
    private String fecha_devolucion;
    private double perdida;
    private int id_venta;  // FK: Venta asociada a la devolución

    // Constructor vacío
    public Devolucion() {}

    // Constructor con parámetros
    public Devolucion(int id_devolucion, String fecha_devolucion, double perdida, int id_venta) {
        this.id_devolucion = id_devolucion;
        this.fecha_devolucion = fecha_devolucion;
        this.perdida = perdida;
        this.id_venta = id_venta;
    }

    // Getters y Setters
    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public double getPerdida() {
        return perdida;
    }

    public void setPerdida(double perdida) {
        if (perdida < 0) {
            throw new IllegalArgumentException("La pérdida no puede ser negativa");
        }
        this.perdida = perdida;
    }


    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
}

