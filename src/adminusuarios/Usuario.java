package adminusuarios;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private int idUsuario;
  private String nombre;
  private String password;

  private String email;
  private List<String> roles;

  public Usuario(int idUsuario, String nombre, String email, String password) {
    this.idUsuario = idUsuario;
    this.nombre = nombre;
    this.password = password;
    this.email = email;
  }

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }
}
