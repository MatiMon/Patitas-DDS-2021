package controllers;

import model.duenio.TipoDocumento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class UserController {

  public ModelAndView registrarUsuario(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();

    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    modelo.put("tipoDocumento", TipoDocumento.values());
    return new ModelAndView(modelo, "formulario-usuario.html.hbs");
  }
}
