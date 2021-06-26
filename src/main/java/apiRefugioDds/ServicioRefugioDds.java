package apiRefugioDds;

import excepciones.GenerarUsuarioException;
import excepciones.ObtenerTodosLosHogaresException;
import com.sun.jersey.api.client.ClientResponse;
import hogares.HogarDeTransito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioRefugioDds implements ServicioRefugio {
  private RefugioDdsAPI api; //hacerlo singleton?
  private String email = "matimonfrba.utn.edu.ar";
  private String bearerToken = "pR0GYdKrgvKfVehIfRtFxZddIRYvxIynays7X4P6l07rNQcmovyAmmE9ZXJJ";

  public ServicioRefugioDds(RefugioDdsAPI api, String bearerToken) {
    this.api = api;
  }

  @Override
  public List<HogarDeTransito> obtenerHogares(String email) {
    return obtenerTodosLosHogares(this.bearerToken);
  }

  public List<HogarDeTransito> obtenerTodosLosHogares(String bearerToken) {
    if (bearerToken == "") {
      throw new ObtenerTodosLosHogaresException("debe ingresar un token.");
    }
    ClientResponse response = this.api.getPaginaDeHogares("1", bearerToken);
    validarCodigoRespuesta(response.getStatusInfo().getStatusCode());
    RespuestaRefugioDdsAPI respuesta = response.getEntity(RespuestaRefugioDdsAPI.class);

    List<HogarDeTransito> hogares = new ArrayList<>();
    hogares.addAll(respuesta.getHogares());
    double iteraciones = (double) respuesta.getTotalHogares() / api.getMaxElementosPorPagina();
    iteraciones = Math.ceil(iteraciones);

    for (int i = 2; i <= iteraciones; i++) {
      response = this.api.getPaginaDeHogares("" + i, bearerToken);
      respuesta = response.getEntity(RespuestaRefugioDdsAPI.class);
      hogares.addAll(respuesta.getHogares());
    }
    return hogares;
  }

  public void validarCodigoRespuesta(int codigo) {
    switch (codigo) {
      case 200:
        break;
      case 400:
        throw new ObtenerTodosLosHogaresException("se ingreso un numero de pagina mayor al que existe o igual a cero.");
      case 401:
        throw new ObtenerTodosLosHogaresException("no se realizo la autenticacion o el token ingresado es invalido.");
      case 409:
        throw new GenerarUsuarioException("el email ya estaba registrado. Por favor use otro.");
      case 422:
        throw new GenerarUsuarioException("el email ingresado no es válido.");
      default:
        throw new RuntimeException("La api devolvio el siguiente codigo de error: " + codigo);
    }
  }

  public void cambiarEmail(String email) {
    ClientResponse response = api.generarToken(email);
    validarCodigoRespuesta(response.getStatusInfo().getStatusCode());
    this.setEmail(email);
    this.setBearerToken(response.getEntity(String.class));
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBearerToken(String bearerToken) {
    this.bearerToken = bearerToken;
  }
}
