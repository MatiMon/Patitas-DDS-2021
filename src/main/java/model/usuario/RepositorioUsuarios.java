package model.usuario;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositorioUsuarios implements WithGlobalEntityManager {

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  List<Usuario> usuarios = new ArrayList<>();
  private static RepositorioUsuarios instancia = new RepositorioUsuarios();

  public static RepositorioUsuarios getInstancia(){
    return instancia;
  }

  public void agregarUsuario(Usuario usuario){
    entityManager().persist(usuario);
  }

  public List<Usuario> listar() {
    return entityManager()//
            .createQuery("from Usuarios", Usuario.class) //
            .getResultList();
  }

  public Usuario buscarPorUsuarioYContrasenia(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
    Usuario usuario = listar().stream().filter(u -> u.getNombreUsuario().equals(username)).findFirst().orElse(null);
    if(usuario.autorizarContrasenia(password) && Objects.nonNull(usuario)) return usuario;
    throw new RuntimeException("Contraseña invalida");
  }

}
