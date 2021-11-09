package model.usuario;

import model.hogares.HogarDeTransito;
import model.hogares.RepositorioHogares;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios implements WithGlobalEntityManager {

  List<Usuario> usuarios = new ArrayList<>();
  private static RepositorioUsuarios instancia = new RepositorioUsuarios();

  public static RepositorioUsuarios getInstancia(){
    return instancia;
  }

  public void agregarUsuario(Usuario usuario){
    entityManager().persist(usuario);
  }

  public Usuario buscarPorUsuarioYContrasenia(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
    Usuario usuario = usuarios.stream().filter(u -> u.getNombreUsuario().equals(username)).findFirst().orElse(null);
    if(usuario.autorizarContrasenia(password)) return usuario;
    else throw new RuntimeException("Contraseña invalida");
  //TODO cambiar esto
  }
}
