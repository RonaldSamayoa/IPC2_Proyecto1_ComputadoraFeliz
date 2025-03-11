package modelo;

public class Ensamblaje {
    private int id_ensamblaje;
    private int id_computadora;  // FK: Computadora asociada
    private int id_componente;   // FK: Componente asociado
    private int cantidad;        // Cantidad de componentes usados

    // Constructor vacío
    public Ensamblaje() {}

    // Constructor con parámetros
    public Ensamblaje(int id_ensamblaje, int id_computadora, int id_componente, int cantidad) {
        this.id_ensamblaje = id_ensamblaje;
        this.id_computadora = id_computadora;
        this.id_componente = id_componente;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getId_ensamblaje() {
        return id_ensamblaje;
    }

    public void setId_ensamblaje(int id_ensamblaje) {
        this.id_ensamblaje = id_ensamblaje;
    }

    public int getId_computadora() {
        return id_computadora;
    }

    public void setId_computadora(int id_computadora) {
        this.id_computadora = id_computadora;
    }

    public int getId_componente() {
        return id_componente;
    }

    public void setId_componente(int id_componente) {
        this.id_componente = id_componente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        this.cantidad = cantidad;
    }
}
