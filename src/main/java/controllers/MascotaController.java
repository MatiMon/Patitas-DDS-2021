package controllers;

import model.mascota.Sexo;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class MascotaController {

  public ModelAndView registrarMascota(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();

    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    modelo.put("sexo", Sexo.values());
    return new ModelAndView(modelo, "formulario-mascota.html.hbs");
  }
}
