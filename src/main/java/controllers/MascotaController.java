package controllers;

import model.caracteristicas.RepositorioCaracteristicasIdeales;
import model.caracteristicas.definidas.CaracteristicaDefinida;
import model.caracteristicas.ideales.*;
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
import java.util.stream.Collectors;

public class MascotaController extends Controller implements WithGlobalEntityManager, TransactionalOps {

  public Map<String, Object> descripcionCaracteristica(CaracteristicaIdeal caracteristicaIdeal) {
    Map<String, Object> descripcion = new HashMap<>();
    descripcion.put("Nombre", caracteristicaIdeal.getNombre());
    descripcion.put("Id", caracteristicaIdeal.getNombre().replace(" ", "-"));
    descripcion.put("Tipo", caracteristicaIdeal.getTipo());
    if (caracteristicaIdeal.esObligatoria()) {
      descripcion.put("esObligatoria", "Si");
    } else {
      descripcion.put("esObligatoria", "No");
    }
    descripcion.put(caracteristicaIdeal.getTipo().replace(" ", "-"), true);
    if (caracteristicaIdeal.getTipo().equals("Opcion multiple")) {
      descripcion.put("Respuestas", caracteristicaIdeal.getRespuestas());
    }
    //descripcion.put("Respuestas", caracteristicaIdeal.getOpciones());
    return descripcion;
  }

  public ModelAndView mostrarFormularioMascota(Request request, Response response) {
    request.session().attribute("redirect_login", "/mascotas/nueva");

    if (!estaIniciadaLaSesion(request)) {
      response.redirect("/login");
      return null;
    }

    Map<String, Object> modelo = getModelo(request, response);
    modelo.put("sexo", Sexo.values());
    modelo.put("tamanio", Tamanio.values());


    modelo.put("caracteristicas", RepositorioCaracteristicasIdeales.getInstancia().listar()
        .stream().map(c -> descripcionCaracteristica(c)).collect(Collectors.toList()));


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

    List<CaracteristicaIdeal> caracteristicas = RepositorioCaracteristicasIdeales.getInstancia().listar();
    try{
      caracteristicas.forEach(c -> caracteristicaDefinidas.add(crear(c, request)));
    }catch (Exception e){
      response.redirect("/mascota-error");
    }


    Long userid = request.session().attribute("user_id");
    /*List<Duenio> duenios = entityManager().createQuery("from Duenios", Duenio.class).getResultList();
    Duenio duenio = duenios.stream().filter(u -> u.getUsuarioId().equals(userid)).findFirst().orElse(null);*/
    Duenio duenio = obtenerDuenio(userid);
    Mascota mascota = new Mascota(nombre, apodo, edad, sexo, tipoAnimal, descripcionFisica, fotos, caracteristicaDefinidas, duenio, null, tamanio);

    try {
      withTransaction(() -> {
        caracteristicaDefinidas.forEach(c -> entityManager().persist(c));
        entityManager().persist(mascota);

      });
    } catch (Exception e) {
      response.redirect("/mascota-error");
    }

    response.redirect("/"); //TODO definir a donde redireccionar despues de crear la mascota
    return null;
  }

  private CaracteristicaDefinida crear(CaracteristicaIdeal c, Request request) {
    if (c.getTipo().equals("De respuesta si o no")) {
      String cosa = request.queryParams(c.getNombre().replace(" ", "-"));
      Boolean valor = cosa.equals("Si"); //TODO
      return c.crearCaracteristica(valor);
    }
    if (c.getTipo().equals("Numerica")) {//TODO
      int valor = Integer.parseInt(request.queryParams(c.getNombre().replace(" ", "-")));
      return c.crearCaracteristica(valor);
    }
    return c.crearCaracteristica(request.queryParams(c.getNombre().replace(" ", "-")));
  }


  public Duenio obtenerDuenio(Long userid) {
    List<Duenio> duenios = entityManager().createQuery("from Duenios", Duenio.class).getResultList();
    return duenios.stream().filter(u -> u.getUsuarioId().equals(userid)).findFirst().orElse(null);
  }

  public ModelAndView crearMascotaError(Request request, Response response) {
    Map<String, Object> parametros = new HashMap<>();
    parametros.put("mascotaError", true);
    return new ModelAndView(parametros, "formulario-mascota.html.hbs");
  }

  public ModelAndView mostrarMascotas(Request request, Response response) {
    Map<String, Object> model = this.getModelo(request, response);
    RepositorioMascotas repoMascotas = RepositorioMascotas.getInstancia();
    model.put("mascotas", repoMascotas.obtenerMascotasUser(request.session().attribute("user_id")));
    return new ModelAndView(model, "mascotas.html.hbs");
  }
}
