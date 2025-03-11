package modelo;

public class Cliente {
    private int id_cliente;
    private String nit;
    private String nombre;
    private String direccion;

    // Constructor vacío
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(int id_cliente, String nit, String nombre, String direccion) {
        this.id_cliente = id_cliente;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Getters y Setters
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
