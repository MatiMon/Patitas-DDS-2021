package controllers;

import model.duenio.TipoDocumento;
import model.usuario.RepositorioUsuarios;
import model.usuario.Usuario;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public abstract class Controller {
  public Map<String, Object> getModelo(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();

    modelo.put("sesionIniciada", estaIniciadaLaSesion(request));
    modelo.put("esAdmin", esUsuarioAdministrador(request));
    return modelo;
  }

  public Boolean esUsuarioAdministrador(Request request) {
    Usuario usuario = RepositorioUsuarios.getInstancia().listar().stream()
        .filter(u -> u.getId().equals(request.session().attribute("user_id"))).findFirst().orElse(null);
    if(usuario != null){
      return usuario.getEsAdministrador();
    } else return false;
  }

  public Boolean estaIniciadaLaSesion(Request request){
    return request.session().attribute("user_id") != null;
  }

}
