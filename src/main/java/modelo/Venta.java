package modelo;

public class Venta {
    private int id_venta;
    private String fecha_venta;
    private double total_venta;
    private int id_cliente;  // FK: Cliente que realizó la compra
    private int id_usuario;  // FK: Usuario que registró la venta

    // Constructor vacío
    public Venta() {}

    // Constructor con parámetros
    public Venta(int id_venta, String fecha_venta, double total_venta, int id_cliente, int id_usuario) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.total_venta = total_venta;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
    }

    // Getters y Setters
    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        if (total_venta < 0) {
            throw new IllegalArgumentException("El total de la venta no puede ser negativo");
        }
        this.total_venta = total_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}

