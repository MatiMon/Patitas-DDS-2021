package controllers;

import model.usuario.RepositorioUsuarios;
import model.usuario.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeController {

  public ModelAndView getHome(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();
    modelo.put("anio", LocalDate.now().getYear());
    modelo.put("esAdmin", esUsuarioAdministrador(request, response));
    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    return new ModelAndView(modelo, "home.html.hbs");
  }

  public Boolean esUsuarioAdministrador(Request request, Response response) {
    Usuario usuario = RepositorioUsuarios.getInstancia().listar().stream()
            .filter(u -> u.getId().equals(request.session().attribute("user_id"))).findFirst().orElse(null);
    if(usuario != null){
      return usuario.getEsAdministrador();
    } else return false;
  }
}