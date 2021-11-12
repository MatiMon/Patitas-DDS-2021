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
import java.util.stream.Collectors;

public class CharacteristicsController extends Controller implements WithGlobalEntityManager, TransactionalOps {
  public ModelAndView mostrarCaracteristicas(Request request, Response response) {
    if (!estaIniciadaLaSesion(request) || !esUsuarioAdministrador(request)) {
      response.redirect("/");
      return null;
    }
    Map<String, Object> modelo = getModelo(request, response);
    List<CaracteristicaIdeal> lista = RepositorioCaracteristicasIdeales.getInstancia().listar();
/*    CaracteristicaIdeal caracteristica = new CaracteristicaIdeal("Edad", false, new NumericaIdeal());
    CaracteristicaIdeal comidaFavorita = new CaracteristicaIdeal("Comida Favorita",
        true, new NumericaIdeal());
    List<CaracteristicaIdeal> lista = Arrays.asList(caracteristica, comidaFavorita,
        caracteristica, comidaFavorita,caracteristica, comidaFavorita);*/
    modelo.put("caracteristicas", lista.stream().map(c -> descripcionCaracteristica(c)).collect(Collectors.toList()));
    return new ModelAndView(modelo, "caracteristicas.html.hbs");

  }

  public Map<String, Object> descripcionCaracteristica(CaracteristicaIdeal caracteristicaIdeal){
    Map<String, Object> descripcion = new HashMap<>();
    descripcion.put("Nombre", caracteristicaIdeal.getNombre());
    descripcion.put("Tipo",caracteristicaIdeal.getTipo());
    if(caracteristicaIdeal.esObligatoria()){
      descripcion.put("esObligatoria", "Si");
    }else{
      descripcion.put("esObligatoria", "No");
    }
    descripcion.put("Respuestas", caracteristicaIdeal.getOpciones());
    return descripcion;
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
    //System.out.println("El valor de obligatoria es:"+request.queryParams("obligatoria"));
    Boolean obligatoria = null != request.queryParams("obligatoria");

    String tipoCaracteristica = request.queryParams("Tipo de caracteristica");
    String opcion1 = request.queryParams("Opcion1");
    String opcion2 = request.queryParams("Opcion2");
    String opcion3 = request.queryParams("Opcion3");
    String opcion4 = request.queryParams("Opcion4");


    TipoCaracteristica unTipoCaracteristica = null;

    if(tipoCaracteristica.equals("Texto")){
      unTipoCaracteristica = new TextoIdeal();
    }
    if(tipoCaracteristica.equals("Numerica")){
     unTipoCaracteristica = new NumericaIdeal();
    }
    if(tipoCaracteristica.equals("De respuesta si o no")){
     unTipoCaracteristica = new BooleanaIdeal();
    }
    if(tipoCaracteristica.equals("Opcion multiple")){
      List<String> opciones = new ArrayList<String>();
      opciones.add(opcion1);
      opciones.add(opcion2);
      opciones.add(opcion3);
      opciones.add(opcion4);


      unTipoCaracteristica = new EnumeradaIdeal(opciones.stream().filter(c -> c != null && c.length() != 0).collect(Collectors.toList()));
    }

    entityManager().persist(unTipoCaracteristica);

    CaracteristicaIdeal unaCaracteristica = new CaracteristicaIdeal(nombre,obligatoria,unTipoCaracteristica);

    withTransaction(() -> {
      RepositorioCaracteristicasIdeales.getInstancia().agregarCaracteristicaIdeal(unaCaracteristica);
    });

    response.redirect("/caracteristicas");
    return null;
  }


}
