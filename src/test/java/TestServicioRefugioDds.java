import apiRefugioDds.*;
import com.sun.jersey.api.client.ClientResponse;
import hogares.HogarDeTransito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ubicacion.Ubicacion;

import java.util.ArrayList;
import java.util.List;


public class TestServicioRefugioDds {
  RefugioDdsAPI api;
  ServicioRefugioDds servicio;
  String bearerToken = "pR0GYdKrgvKfVehIfRtFxZddIRYvxIynays7X4P6l07rNQcmovyAmmE9ZXJJ";

  @BeforeEach
  public void setUp() throws Exception {
    this.api = new RefugioDdsAPI(10);
    this.servicio = new ServicioRefugioDds(api);
  }

  @Test
  public void generarUsuarioConMailInvalidoDaError() {
    ClientResponse response = this.api.generarToken("mail@invalido");
    Assertions.assertEquals(response.getStatus(), 422);
  }

  @Test
  public void generarUsuarioConMailYaRegistradoDaError() {
    ClientResponse response = this.api.generarToken("matimon@frba.utn.edu.ar");
    Assertions.assertEquals(response.getStatus(), 409);
  }

   /*
   PARA COMPLETAR LOS SIGUIENTES TEST DEBERIA PODER MOCKEAR ClientResponse
  @Test
  public void generarUsuarioNuevoDevuelveUnToken() {
    ClientResponse response = this.api.generarToken("matimon@frba.utn.edu.ar");
    Assertions.assertEquals(response.getStatus(), 200);
  }

  @Test
  public void generoUsuarioLoGuardoYDespuesLoPuedoBuscarParaObtenerHogares() {

  }*/

  @Test
  public void puedoObtenerUnaPaginaDeHogaresConUnBearerToken() {
    ClientResponse response = this.api.getPaginaDeHogares("1", bearerToken);
    Assertions.assertEquals(response.getStatus(), 200);
  }

  @Test
  public void puedoObtenerUnaPaginaDeHogaresYMapearlaAListaDeHogaresDeTransito() {
    ClientResponse response = this.api.getPaginaDeHogares("1", bearerToken);
    Assertions.assertEquals(response.getStatus(), 200);

    RespuestaRefugioDdsAPI respuesta = response.getEntity(RespuestaRefugioDdsAPI.class);
    List<HogarDeTransito> hogares = new ArrayList<>();
    hogares.addAll(respuesta.getHogares());
    Assertions.assertNotEquals(hogares.size(), 0);
  }

  @Test
  public void puedoObtenerTodosLosHogares() {
    List<HogarDeTransito> hogares = servicio.obtenerTodosLosHogares(bearerToken);
    Assertions.assertNotEquals(hogares.size(), 0);
  }

  @Test
  public void intentoObtenerUnaPaginaQueNoExiste() {
    ClientResponse response = this.api.getPaginaDeHogares("0", bearerToken);
    Assertions.assertEquals(response.getStatus(), 400);
  }

  @Test
  public void intentoObtenerUnaPaginaConUnTokenInvalido() {
    ClientResponse response = this.api.getPaginaDeHogares("1", "token invalido");
    Assertions.assertEquals(response.getStatus(), 401);
  }

}
