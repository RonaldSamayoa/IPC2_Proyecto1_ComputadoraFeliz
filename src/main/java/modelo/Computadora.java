package modelo;
import java.time.LocalDate;

public class Computadora {
    private int id_computadora;
    private String nombre_computadora;
    private double precio_venta;
    private LocalDate fecha_ensamblaje;
    private int id_usuario;  // FK: Usuario que ensambló la computadora

    // Constructor vacío
    public Computadora() {}

    // Constructor con parámetros
    public Computadora(int id_computadora, String nombre_computadora, double precio_venta, LocalDate fecha_ensamblaje, int id_usuario) {
        this.id_computadora = id_computadora;
        this.nombre_computadora = nombre_computadora;
        this.precio_venta = precio_venta;
        this.fecha_ensamblaje = fecha_ensamblaje;
        this.id_usuario = id_usuario;
    }

    // Getters y Setters
    public int getId_computadora() {
        return id_computadora;
    }

    public void setId_computadora(int id_computadora) {
        this.id_computadora = id_computadora;
    }

    public String getNombre_computadora() {
        return nombre_computadora;
    }

    public void setNombre_computadora(String nombre_computadora) {
        this.nombre_computadora = nombre_computadora;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        if (precio_venta < 0) {
            throw new IllegalArgumentException("El precio de venta no puede ser negativo");
        }
        this.precio_venta = precio_venta;
    }


    public LocalDate getFecha_ensamblaje() {
        return fecha_ensamblaje;
    }

    public void setFecha_ensamblaje(LocalDate fecha_ensamblaje) {
        this.fecha_ensamblaje = fecha_ensamblaje;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}

