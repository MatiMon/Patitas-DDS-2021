package controllers;

import model.caracteristicas.RepositorioCaracteristicasIdeales;
import model.caracteristicas.TipoCaracteristica;
import model.caracteristicas.ideales.*;
import model.contacto.Contacto;
import model.duenio.Duenio;
import model.duenio.TipoDocumento;
import model.ubicacion.Ubicacion;
import model.usuario.*;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.convert.LocalDateConverter;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class UserController extends Controller implements WithGlobalEntityManager, TransactionalOps {

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

  public Void crearUsuario(Request request, Response response) {
    ValidacionDeContrasenia validacion = new ValidacionDeCaracteresConsecutivos();

    ValidadorContrasenia validador = new ValidadorContrasenia(Arrays.asList(validacion));
    String nombreUsuario = request.queryParams("username");
    String contrasenia = request.queryParams("password");
    Usuario usuario = null;
    try{
      usuario = new Usuario(nombreUsuario, contrasenia, validador);
    }catch (Exception e){
      //TODO hacer algo con esto
      return null;
    }
    String nombre = request.queryParams("Nombre");
    String apellido = request.queryParams("Apellido");
    LocalDate fechaNacimiento = LocalDate.parse(request.queryParams("Fecha De Nacimiento"), DateTimeFormatter.ISO_LOCAL_DATE);
    TipoDocumento tipoDocumento = TipoDocumento.valueOf(request.queryParams("Tipo de Documento").toUpperCase(Locale.ROOT));
    double documento = Double.valueOf(request.queryParams("Numero Documento"));
    String nombre1 = request.queryParams("nombre");
    String apellido1 = request.queryParams("apellido");
    int telefono = Integer.parseInt(request.queryParams("telefono"));
    String email = request.queryParams("email");
    Contacto contactoPrincipal = new Contacto(nombre1, apellido1, telefono, email);
    Ubicacion ubicacion = new Ubicacion("mi casa", 12, 12);


    Duenio duenio = new Duenio(nombre, apellido, fechaNacimiento, tipoDocumento, documento, contactoPrincipal,
        ubicacion, usuario);

    try{
      this.beginTransaction();
      entityManager().persist(contactoPrincipal);
      entityManager().persist(usuario);
      entityManager().persist(duenio);
      this.commitTransaction();
    }catch (Exception e){
      //TODO
    }
    request.session().attribute("user_id", usuario.getId());
    response.redirect("/");
    return null;
  }

}
