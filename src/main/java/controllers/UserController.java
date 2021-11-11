package controllers;

import model.duenio.TipoDocumento;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class UserController extends Controller{

  public ModelAndView mostrarFormularioNuevoUsuario(Request request, Response response) {
    if (estaIniciadaLaSesion(request)) {
      response.redirect("/");
      return null;
    }
    request.session().attribute("redirect_login", "/");
    Map<String, Object> modelo = getModelo(request, response);
    modelo.put("tipoDocumento", TipoDocumento.values());
    return new ModelAndView(modelo, "formulario-usuario.html.hbs");
  }
}
