package apiRefugioDds;

import apiRefugioDds.exceptions.GenerarUsuarioException;
import apiRefugioDds.exceptions.ObtenerTodosLosHogaresException;
import com.sun.jersey.api.client.ClientResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioRefugioDds implements ServicioRefugio {
  private RefugioDdsAPI api; //hacerlo singleton?
  private List<UsuarioAPI> usuariosAPI;

  public ServicioRefugioDds(RefugioDdsAPI api) {
    this.api = api;
  }

  @Override
  public List<HogarDeTransito> obtenerHogares(String email) {
    if (!tieneTokenGenerado(email)) {
      this.generarNuevoUsuario(email);
    }
    String bearerToken = this.obtenerTokenDeUsuario(email);

    return obtenerTodosLosHogares(bearerToken);
  }

  public String obtenerTokenDeUsuario(String email) {
    List<UsuarioAPI> usuariosFiltrados = usuariosAPI.stream().filter(usuarioAPI -> usuarioAPI.getEmail().equals(email)).collect(Collectors.toList());
    return usuariosFiltrados.get(0).getBearerToken();
  }

  public boolean tieneTokenGenerado(String email) {
    return this.usuariosAPI.stream().anyMatch(usuarioAPI -> usuarioAPI.getEmail().equals(email));
  }

  public void generarNuevoUsuario(String email) {
    if (email == "") {
      throw new GenerarUsuarioException("debe ingresar un email.");
    }

    ClientResponse response = api.generarToken(email);
    validarCodigoRespuesta(response.getStatusInfo().getStatusCode());

    UsuarioAPI nuevoUsuario = response.getEntity(UsuarioAPI.class);
    nuevoUsuario.setEmail(email);
    usuariosAPI.add(nuevoUsuario);
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
        throw new ObtenerTodosLosHogaresException("se ingreso un numero de pagina mayor al que existe.");
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

}
