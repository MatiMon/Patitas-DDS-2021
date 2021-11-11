package controllers;

import model.usuario.RepositorioUsuarios;
import model.usuario.Usuario;
import model.usuario.RepositorioUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class SesionController {
  // TODO GRAN TODO: notar que las responsabildades
  // de saber si una personas está con sesión inciada,
  // de saber le usuarie actual, etc, probablmente se vayan a repetir
  // y convendrá generalizarlas

  public ModelAndView mostrarLogin(Request request, Response response) {
    if (request.session().attribute("user_id") != null) {
      response.redirect("/");
      return null;
    }
    Map<String, Object> modelo = new HashMap<>();
    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    return new ModelAndView(modelo, "formulario-login.html.hbs");
  }

  public Void crearSesion(Request request, Response response) {
    try {
      Usuario usuario = RepositorioUsuarios.getInstancia().buscarPorUsuarioYContrasenia(
          request.queryParams("username"),
          request.queryParams("password"));

      request.session().attribute("user_id", usuario.getId());

      response.redirect("/"); // TODO aca va a convenir leer el origen
      return null;
    } catch (Exception e) {
      response.redirect("/error"); // TODO redirigir agregando un mensaje de error
      return null;
    }
  }

  public Response cerrarSesion(Request request, Response response) {
    request.session().removeAttribute("user_id");
    response.redirect("/");
    return response;
  }
}