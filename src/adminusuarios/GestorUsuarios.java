package adminusuarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
  private List<Usuario> usuarios;

  public GestorUsuarios() {
    this.usuarios = new ArrayList<>();
  }

  // Método para obtener el próximo ID de usuario disponible
  public int obtenerNuevoIdUsuario() {
    if (usuarios.isEmpty()) {
      return 1;
    } else {
      return usuarios.get(usuarios.size() - 1).getIdUsuario() + 1;
    }
  }

  // Método para crear un nuevo usuario
  public void crearUsuario(int idUsuario, String nombre, String email, String pass) {
    Usuario nuevoUsuario = new Usuario(idUsuario, nombre, email, pass);
    usuarios.add(nuevoUsuario);
  }

  // Método para editar los datos de un usuario existente
  public void editarUsuario(int idUsuario, String nuevosDatos) {
    Usuario usuario = buscarUsuarioPorId(idUsuario);
    if (usuario != null) {
      // Implementar lógica para editar los datos del usuario
    } else {
      System.out.println("Usuario no encontrado.");
    }
  }

  // Método para eliminar un usuario por su ID
  public void eliminarUsuario(int idUsuario) {
    Usuario usuario = buscarUsuarioPorId(idUsuario);
    if (usuario != null) {
      usuarios.remove(usuario);
      System.out.println("Usuario eliminado correctamente.");
    } else {
      System.out.println("Usuario no encontrado.");
    }
  }

  // Método para asignar roles a un usuario
  public void asignarRoles(int idUsuario, List<String> roles) {
    Usuario usuario = buscarUsuarioPorId(idUsuario);
    if (usuario != null) {
      usuario.setRoles(roles);
      System.out.println("Roles asignados correctamente.");
    } else {
      System.out.println("Usuario no encontrado.");
    }
  }

  // Método para autenticar un usuario por su email y contraseña
  public boolean autenticarUsuario(String email, String contraseña) {
    for (Usuario usuario : usuarios) {
      if (usuario.getEmail().equals(email) && usuario.getPassword().equals(contraseña)) {
        return true;
      }
    }
    return false;
  }

  // Método para cargar usuarios desde un archivo CSV
  public void cargarUsuariosDesdeCSV(String rutaArchivo) {
    try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
      String linea;
      while ((linea = reader.readLine()) != null) {
        String[] datos = linea.split(",");

        int idUsuario = Integer.parseInt(datos[0].trim());
        String nombre = datos[1].trim();
        String email = datos[2].trim();
        String pass = datos[3].trim();

        // Crear el usuario y agregarlo a la lista
        Usuario usuario = new Usuario(idUsuario, nombre, email,pass);
        usuarios.add(usuario);
      }
      System.out.println("Usuarios cargados correctamente desde el archivo CSV.");
    } catch (IOException e) {
      System.out.println("Error al cargar usuarios desde el archivo CSV: " + e.getMessage());
    }
  }

  // Método auxiliar para buscar un usuario por su ID
  private Usuario buscarUsuarioPorId(int idUsuario) {
    for (Usuario usuario : usuarios) {
      if (usuario.getIdUsuario() == idUsuario) {
        return usuario;
      }
    }
    return null;
  }
}
