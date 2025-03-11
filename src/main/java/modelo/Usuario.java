package modelo;

public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String password;
    private String rol;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(int id_usuario, String nombre_usuario, String password, String rol) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.rol = rol;
    }

    // Getters y Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

