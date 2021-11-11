package controllers;

import model.caracteristicas.RepositorioCaracteristicasIdeales;
import model.caracteristicas.ideales.CaracteristicaIdeal;
import model.caracteristicas.ideales.EnumeradaIdeal;
import model.caracteristicas.ideales.NumericaIdeal;
import model.mascota.Sexo;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class characteristicsController {
  public static ModelAndView mostrarCaracteristicas(Request request, Response response) {
    Map<String, Object> modelo = new HashMap<>();

    CaracteristicaIdeal caracteristica = new CaracteristicaIdeal("Edad", false, new NumericaIdeal());
    CaracteristicaIdeal comidaFavorita = new CaracteristicaIdeal("Comida Favorita",
        true, new NumericaIdeal());
    List<CaracteristicaIdeal> lista = Arrays.asList(caracteristica, comidaFavorita,
        caracteristica, comidaFavorita,caracteristica, comidaFavorita);
    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);
    //modelo.put("esAdmin", )
    modelo.put("caracteristicas", lista);
    return new ModelAndView(modelo, "caracteristicas.html.hbs");

  }

  public static ModelAndView registrarNuevaCaracteristica(Request request,Response response){
    Map<String, Object> modelo = new HashMap<>();

    modelo.put("sesionIniciada", request.session().attribute("user_id") != null);

    return new ModelAndView(modelo, "formulario-caracteristica.html.hbs");
  }

}
