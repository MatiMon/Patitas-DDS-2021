package controllers;

import model.duenio.TipoDocumento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class RescateController {

  public ModelAndView registrarRescate(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();

    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    modelo.put("tipoDocumento", TipoDocumento.values());
    return new ModelAndView(modelo, "formulario-rescate-datos-personales.html.hbs");
  }

  public ModelAndView registrarDatosMascota(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();

    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    return new ModelAndView(modelo, "formulario-rescate-datos-mascota.html.hbs");
  }
}
