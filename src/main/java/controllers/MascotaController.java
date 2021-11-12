package controllers;

import model.caracteristicas.definidas.CaracteristicaDefinida;
import model.contacto.Contacto;
import model.duenio.Duenio;
import model.duenio.TipoDocumento;
import model.mascota.*;
import model.ubicacion.Ubicacion;
import model.usuario.RepositorioUsuarios;
import model.usuario.Usuario;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.*;

public class MascotaController extends Controller implements WithGlobalEntityManager, TransactionalOps {

  public ModelAndView mostrarFormularioMascota(Request request, Response response) {
    request.session().attribute("redirect_login", "/mascotas/nueva");

    if (!estaIniciadaLaSesion(request)) {
      response.redirect("/login");
      return null;
    }

    Map<String, Object> modelo = getModelo(request, response);
    modelo.put("sexo", Sexo.values());
    modelo.put("tamanio", Tamanio.values());
    return new ModelAndView(modelo, "formulario-mascota.html.hbs");
  }

  public Void crearMascota(Request request, Response response) {
    String nombre = request.queryParams("Nombre de mascota");
    String apodo = request.queryParams("Apodo");
    int edad = Integer.parseInt(request.queryParams("Edad aproximada"));
    Sexo sexo = Sexo.valueOf(request.queryParams("sexo"));
    Tamanio tamanio = Tamanio.valueOf(request.queryParams("tamanio"));
    TipoAnimal tipoAnimal = TipoAnimal.valueOf(request.queryParams("tipo mascota").toUpperCase(Locale.ROOT));
    String descripcionFisica = request.queryParams("Descripcion fisica");
    List<String> fotos = new ArrayList<>();
    String foto = request.queryParams("fotos");
    fotos.add(foto);

    List<CaracteristicaDefinida> caracteristicaDefinidas = new ArrayList<>(); //TODO ver como obtener este dato del formulario

    Long userid = request.session().attribute("user_id");
    /*List<Duenio> duenios = entityManager().createQuery("from Duenios", Duenio.class).getResultList();
    Duenio duenio = duenios.stream().filter(u -> u.getUsuarioId().equals(userid)).findFirst().orElse(null);*/
    Duenio duenio = obtenerDuenio(userid);
    Mascota mascota = new Mascota(nombre, apodo, edad, sexo, tipoAnimal, descripcionFisica, fotos, caracteristicaDefinidas, duenio, null, tamanio);

    withTransaction(() -> {
      RepositorioMascotas.getInstancia().agregarMascota(mascota);
    });

    response.redirect("/"); //TODO definir a donde redireccionar despues de crear la mascota
    return null;
  }

  public Duenio obtenerDuenio(Long userid){
    List<Duenio> duenios = entityManager().createQuery("from Duenios", Duenio.class).getResultList();
    return duenios.stream().filter(u -> u.getUsuarioId().equals(userid)).findFirst().orElse(null);
  }

}
