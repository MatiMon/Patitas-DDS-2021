package controllers;

import model.caracteristicas.RepositorioCaracteristicasIdeales;
import model.caracteristicas.TipoCaracteristica;
import model.caracteristicas.definidas.CaracteristicaDefinida;
import model.caracteristicas.ideales.*;
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
import java.util.*;

public class CharacteristicsController extends Controller implements WithGlobalEntityManager, TransactionalOps {
  public ModelAndView mostrarCaracteristicas(Request request, Response response) {
    if (!estaIniciadaLaSesion(request) || !esUsuarioAdministrador(request)) {
      response.redirect("/");
      return null;
    }
    Map<String, Object> modelo = getModelo(request, response);

    CaracteristicaIdeal caracteristica = new CaracteristicaIdeal("Edad", false, new NumericaIdeal());
    CaracteristicaIdeal comidaFavorita = new CaracteristicaIdeal("Comida Favorita",
        true, new NumericaIdeal());
    List<CaracteristicaIdeal> lista = Arrays.asList(caracteristica, comidaFavorita,
        caracteristica, comidaFavorita,caracteristica, comidaFavorita);
    modelo.put("caracteristicas", lista);
    return new ModelAndView(modelo, "caracteristicas.html.hbs");

  }


  public ModelAndView registrarNuevaCaracteristica(Request request,Response response){
    if (!estaIniciadaLaSesion(request) || !esUsuarioAdministrador(request)) {
      response.redirect("/");
      return null;
    }
    Map<String, Object> modelo = getModelo(request, response);
    return new ModelAndView(modelo, "formulario-caracteristica.html.hbs");
  }

  public Void crearCaracteristica(Request request, Response response) {
    String nombre = request.queryParams("Nombre de la caracteristica");
    String esObligatoria = request.queryParams("obligatoria");
    String tipoCaracteristica = request.queryParams("Tipo de caracteristica");
    String opcion1 = request.queryParams("Opcion1");
    String opcion2 = request.queryParams("Opcion2");

    Boolean obligatoria = false;

    if(esObligatoria == "Si"){
      obligatoria = true;
    }

    TipoCaracteristica unTipoCaracteristica = new TextoIdeal();

    if(tipoCaracteristica == "Texto"){
      unTipoCaracteristica = new TextoIdeal();
    }
    if(tipoCaracteristica == "Numerica"){
      unTipoCaracteristica = new NumericaIdeal();
    }
    if(tipoCaracteristica == "De respuesta si o no"){
      unTipoCaracteristica = new BooleanaIdeal();
    }
    if(tipoCaracteristica == "Opcion multiple"){
      List<String> opciones = new ArrayList<String>();
      opciones.add(opcion1);
      opciones.add(opcion2);
      unTipoCaracteristica = new EnumeradaIdeal(opciones);
    }

    CaracteristicaIdeal unaCaracteristica = new CaracteristicaIdeal(nombre,obligatoria,unTipoCaracteristica);

    withTransaction(() -> {
      RepositorioCaracteristicasIdeales.getInstancia().agregarCaracteristicaIdeal(unaCaracteristica);
    });

    response.redirect("/caracteristicas");
    return null;
  }


}
