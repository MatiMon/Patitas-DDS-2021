package controllers;

import model.duenio.TipoDocumento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class RescateController extends Controller{

  public ModelAndView mostrarFormularioRescate(Request request, Response response) {
    Map<String, Object> modelo = getModelo(request, response);
    modelo.put("tipoDocumento", TipoDocumento.values());
    request.session().attribute("redirect_login", "/rescates/nuevo");
    return new ModelAndView(modelo, "formulario-rescate.html.hbs");
  }

}
