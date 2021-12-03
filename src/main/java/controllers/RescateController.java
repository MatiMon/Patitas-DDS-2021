package controllers;

import model.asociacion.Asociacion;
import model.contacto.Contacto;
import model.duenio.TipoDocumento;
import model.mascota.Mascota;
import model.mascota.Tamanio;
import model.mascota.TipoAnimal;
import model.rescate.RescateDeMascotaRegistrada;
import model.rescate.RescateDeMascotaSinRegistrar;
import model.rescate.Rescatista;
import model.ubicacion.Ubicacion;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RescateController extends Controller implements WithGlobalEntityManager, TransactionalOps {

  public ModelAndView mostrarFormularioRescate(Request request, Response response) {
    Map<String, Object> modelo = getModelo(request, response);
    modelo.put("tipoDocumento", TipoDocumento.values());
    modelo.put("tipoAnimal", TipoAnimal.values());
    modelo.put("tamanioAnimal", Tamanio.values());
    request.session().attribute("redirect_login", "/rescates/nuevo");
    return new ModelAndView(modelo, "formulario-rescate.html.hbs");
  }

  public Void crearRescate(Request request, Response response) {
    //Rescatista
    String nombre = request.queryParams("Nombre");
    String apellido = request.queryParams("Apellido");
    LocalDate fechaDeNacimiento = LocalDate.parse(request.queryParams("Fecha De Nacimiento"), DateTimeFormatter.ISO_LOCAL_DATE);
    TipoDocumento tipoDocumento = TipoDocumento.valueOf(request.queryParams("Tipo de Documento").toUpperCase(Locale.ROOT));
    String nroDocumento = request.queryParams("Numero Documento");
    String direccion = request.queryParams("direccion-calle") + " " + request.queryParams("direccion-altura") + " " + request.queryParams("direccion-piso-dpto");

    //Contacto
    String nombre1 = request.queryParams("nombre");
    String apellido1 = request.queryParams("apellido");
    String telefono = (request.queryParams("telefono"));
    String email = request.queryParams("email");
    Contacto contactoPrincipal = new Contacto(nombre1, apellido1, telefono, email);

    //Mascota
    Boolean tieneChapita = (request.queryParams("Tiene chapita")) != null;
    String descripcion = request.queryParams("estado mascota");
    String lugarMascota = request.queryParams("lugar mascota");
    List<String> fotos = new ArrayList<>();
    String foto = request.queryParams("fotos");
    fotos.add(foto);

    //TODO esto está con valores random pues no tenemos una api de geocodificación ni el mapa juas juas
    Ubicacion ubicacionMascota = new Ubicacion(lugarMascota, 0.000000, 0.000000);

    Rescatista rescatista = new Rescatista(nombre, apellido, fechaDeNacimiento, tipoDocumento,nroDocumento, direccion, contactoPrincipal);
    RescateDeMascotaRegistrada rescateRegistrado = null;
    RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar = null;

    if(tieneChapita){
      String idMascota = request.queryParams("chapita");
      rescateRegistrado = new RescateDeMascotaRegistrada(fotos, descripcion, ubicacionMascota, rescatista, LocalDateTime.now(), obtenerMascota(idMascota, response));
    }else{
      Tamanio tamanio = Tamanio.valueOf(request.queryParams("Tamaño del animal").toUpperCase(Locale.ROOT));
      TipoAnimal tipoAnimal = TipoAnimal.valueOf(request.queryParams("Tipo del animal").toUpperCase(Locale.ROOT));

      rescateDeMascotaSinRegistrar = new RescateDeMascotaSinRegistrar(fotos, descripcion, ubicacionMascota,
          rescatista, LocalDateTime.now(), tamanio, tipoAnimal,null, null); //no tiene dueño pues esta perdida
    }



    try{
      this.beginTransaction();
      entityManager().persist(contactoPrincipal);
      entityManager().persist(rescatista);
      if(tieneChapita){
        entityManager().persist(rescateRegistrado);
      }else{
        entityManager().persist(rescateDeMascotaSinRegistrar);
      }
      this.commitTransaction();
    }catch (Exception e){
      response.redirect("/rescate-error");
    }

    response.redirect("/rescate-exitoso"); //TODO definir a donde redireccionar despues de crear la mascota
    return null;
  }

  //TODO como no tenemos la parte de asociaciones, ahora mismo todos los rescates van a ir a la misma asociacion
  //la asociacion está creada por un test que está en el test de persistencia
  public Asociacion obtenerAsociacion(){
    List<Asociacion> asociaciones = entityManager().createQuery("from asociaciones", Asociacion.class).getResultList();
    return asociaciones.stream().filter(asociacion -> asociacion.getId() == 1).findFirst().orElse(null);
  }

  public Mascota obtenerMascota(String idMascota, Response response){
    Mascota mascota = null;
    try{
      List<Mascota> mascotas = entityManager().createQuery("from Mascotas", Mascota.class).getResultList();
      mascota = mascotas.stream().filter(m -> m.getIdMascota().equals(idMascota)).findFirst().orElse(null);
    }catch (Exception e){
      response.redirect("/mascota-inexistente");
    }

    return mascota;
  }

  public ModelAndView obtenerMascotaError(Request request, Response response) {
    Map<String, Object> parametros = new HashMap<>();
    parametros.put("mascotaInexistente", true);
    return new ModelAndView(parametros, "formulario-rescate.html.hbs");
  }

  public ModelAndView crearRescateError(Request request, Response response) {
    Map<String, Object> parametros = new HashMap<>();
    parametros.put("rescateError", true);
    return new ModelAndView(parametros, "formulario-rescate.html.hbs");
  }

  public ModelAndView crearRescateExitoso(Request request, Response response) {
    Map<String, Object> parametros = new HashMap<>();
    parametros.put("rescateExitoso", true);
    return new ModelAndView(parametros, "home.html.hbs");
  }

}
