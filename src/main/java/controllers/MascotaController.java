package controllers;

import model.caracteristicas.definidas.CaracteristicaDefinida;
import model.duenio.Duenio;
import model.mascota.*;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MascotaController implements WithGlobalEntityManager, TransactionalOps {

  public ModelAndView mostrarFormularioMascota(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();

    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    modelo.put("sexo", Sexo.values());
    return new ModelAndView(modelo, "formulario-mascota.html.hbs");
  }

  public Void crearMascota(Request request, Response response) {
    String nombre = request.queryParams("Nombre de mascota");
    String apodo = request.queryParams("Apodo");
    int edad = Integer.parseInt(request.queryParams("Edad aproximada"));
    Sexo sexo = Sexo.valueOf(request.queryParams("sexo"));
    TipoAnimal tipoAnimal = TipoAnimal.valueOf(request.queryParams("Tipo de mascota"));
    String descripcionFisica = request.queryParams("Descripcion fisica");
    List<String> fotos = new ArrayList<>(); //TODO ver como persistir esto
    List< CaracteristicaDefinida > caracteristicaDefinidas = new ArrayList<>(); //TODO ver como persistir esto
    //Duenio duenio = request.queryParams("");
    //String id = request.queryParams("");
    //Tamanio tamanio = request.queryParams("");

    Mascota mascota = new Mascota(nombre, apodo, edad, sexo, tipoAnimal, descripcionFisica, fotos, caracteristicaDefinidas, null, null, Tamanio.CHICO);

    withTransaction(() -> {
      RepositorioMascotas.getInstancia().agregarMascota(mascota);
    });

    response.redirect("/"); //TODO definir a donde redireccionar despues de crear la mascota
    return null;
  }

}
