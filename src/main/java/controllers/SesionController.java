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

public class SesionController extends Controller{
  // TODO GRAN TODO: notar que las responsabildades
  // de saber si una personas está con sesión inciada,
  // de saber le usuarie actual, etc, probablmente se vayan a repetir
  // y convendrá generalizarlas

  public ModelAndView mostrarLogin(Request request, Response response) {
    if (estaIniciadaLaSesion(request)) {
      response.redirect("/");
      return null;
    }
    Map<String, Object> modelo = getModelo(request, response);
    return new ModelAndView(modelo, "formulario-login.html.hbs");
  }

  public Void crearSesion(Request request, Response response) {
    try {
      Usuario usuario = RepositorioUsuarios.getInstancia().buscarPorUsuarioYContrasenia(
          request.queryParams("username"),
          request.queryParams("password"));

      request.session().attribute("user_id", usuario.getId());

      response.redirect(request.session().attribute("redirect_login")); // TODO aca va a convenir leer el origen
      return null;
    } catch (Exception e) {
      response.redirect("/login-error"); // TODO redirigir agregando un mensaje de error
      return null;
    }
  }

  public Response cerrarSesion(Request request, Response response) {
    request.session().removeAttribute("user_id");
    response.redirect("/");
    return response;
  }

  public ModelAndView crearSesionError(Request request, Response response) {
    Map<String, Object> parametros = new HashMap<>();
    parametros.put("mensajeError", true);
    return new ModelAndView(parametros, "formulario-login.html.hbs");
  }
}