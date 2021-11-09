package model.usuario;

import model.hogares.HogarDeTransito;
import model.hogares.RepositorioHogares;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

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

  public Usuario buscarPorUsuarioYContrasenia(String username, String password) {
   //TODO
    return null;
  }
}
