package modelo.dao;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios;

    public UsuarioDAO() {
        this.usuarios = new ArrayList<>();
    }

    // Método para verificar si un ID ya existe
    private boolean existeId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId_usuario() == id) {
                return true;
            }
        }
        return false;
    }

    // Método para agregar un usuario manualmente con verificación de ID único
    public boolean agregarUsuario(Usuario usuario) {
        if (!existeId(usuario.getId_usuario())) {
            usuarios.add(usuario);
            return true; // Usuario agregado correctamente
        }
        return false; // No se agregó porque el ID ya existe
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    // Método para buscar un usuario por ID
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId_usuario() == id) {
                return usuario;
            }
        }
        return null; // Si no se encuentra
    }

    // Método para eliminar un usuario por ID
    public boolean eliminarUsuario(int id) {
        return usuarios.removeIf(usuario -> usuario.getId_usuario() == id);
    }
}
