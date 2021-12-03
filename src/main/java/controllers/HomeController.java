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

public class HomeController extends Controller{

  public ModelAndView getHome(Request request, Response response) {
    Map<String, Object> modelo = getModelo(request, response);
    request.session().attribute("redirect_login", "/");
    if(response.status() == 201){
      modelo.put("rescateExitoso", true);
    }
    return new ModelAndView(modelo, "home.html.hbs");
  }

}