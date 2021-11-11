package controllers;

import model.caracteristicas.definidas.CaracteristicaDefinida;
import model.contacto.Contacto;
import model.duenio.Duenio;
import model.duenio.TipoDocumento;
import model.mascota.*;
import model.ubicacion.Ubicacion;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MascotaController extends Controller implements WithGlobalEntityManager, TransactionalOps {

  public ModelAndView mostrarFormularioMascota(Request request, Response response) {
    if (!estaIniciadaLaSesion(request)) {
      response.redirect("/");
      return null;
    }
    request.session().attribute("redirect_login", "/mascotas/nueva");
    Map<String, Object> modelo = getModelo(request, response);
    modelo.put("sexo", Sexo.values());
    return new ModelAndView(modelo, "formulario-mascota.html.hbs");
  }

  public Void crearMascota(Request request, Response response) {
    String nombre = request.queryParams("Nombre de mascota");
    String apodo = request.queryParams("Apodo");
    int edad = Integer.parseInt(request.queryParams("Edad aproximada"));
    Sexo sexo = Sexo.valueOf(request.queryParams("sexo"));
    //TipoAnimal tipoAnimal = TipoAnimal.valueOf(request.queryParams("Tipo de mascota"));
    TipoAnimal tipoAnimal = TipoAnimal.PERRO; //TODO ver como obtener este dato del formulario
    String descripcionFisica = request.queryParams("Descripcion fisica");
    List<String> fotos = new ArrayList<>(); //TODO ver como obtener este dato del formulario
    fotos.add("una foto"); //TODO
    List< CaracteristicaDefinida > caracteristicaDefinidas = new ArrayList<>(); //TODO ver como obtener este dato del formulario

    Contacto contactoPrincipal = new Contacto("al", "go", 1234, "algo@gmail");
    Ubicacion ubicacion = new Ubicacion("String", 123, 456);
    Duenio duenio = new Duenio("a", "b", LocalDate.now(), TipoDocumento.DNI, 12365454, contactoPrincipal, ubicacion);
    entityManager().persist(contactoPrincipal);
    entityManager().persist(duenio); //TODO obtener el duenio con el id de usuario logueado
    //String id = request.queryParams("");
    //Tamanio tamanio = request.queryParams("");

    Mascota mascota = new Mascota(nombre, apodo, edad, sexo, tipoAnimal, descripcionFisica, fotos, caracteristicaDefinidas, duenio, null, Tamanio.CHICO);

    withTransaction(() -> {
      RepositorioMascotas.getInstancia().agregarMascota(mascota);
    });

    response.redirect("/"); //TODO definir a donde redireccionar despues de crear la mascota
    return null;
  }

}
