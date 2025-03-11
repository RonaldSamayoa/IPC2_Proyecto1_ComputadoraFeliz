package modelo;

public class Componente {
    private int id_componente;
    private String nombre_componente;
    private double costo;
    private int cantidad;

    // Constructor vacío
    public Componente() {}

    // Constructor con parámetros
    public Componente(int id_componente, String nombre_componente, double costo, int cantidad) {
        this.id_componente = id_componente;
        this.nombre_componente = nombre_componente;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getId_componente() {
        return id_componente;
    }

    public void setId_componente(int id_componente) {
        this.id_componente = id_componente;
    }

    public String getNombre_componente() {
        return nombre_componente;
    }

    public void setNombre_componente(String nombre_componente) {
        this.nombre_componente = nombre_componente;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        if (costo < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo");
        }
        this.costo = costo;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

}

