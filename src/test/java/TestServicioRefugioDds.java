import model.apiRefugioDds.*;
import com.sun.jersey.api.client.ClientResponse;
import model.hogares.HogarDeTransito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class TestServicioRefugioDds {
  RefugioDdsAPI api;
  ServicioRefugioDds servicio;
  String bearerToken = "pR0GYdKrgvKfVehIfRtFxZddIRYvxIynays7X4P6l07rNQcmovyAmmE9ZXJJ";

  @BeforeEach
  public void setUp() throws Exception {
    this.api = new RefugioDdsAPI(10);
    this.servicio = new ServicioRefugioDds(api, bearerToken);
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

  /*
  @Test
  public void intentoMocking() {
    RefugioDdsAPI apiMockeada = mock(RefugioDdsAPI.class);
    ServicioRefugioDds nuevoServicio = new ServicioRefugioDds(apiMockeada);
    Client client = new Client();
    client = client.create();

    // OPCION 1:
    ClientResponse clientResponse = client.resource("").path("")
        .queryParam("", "")
        .accept(MediaType.APPLICATION_JSON)
        .get(ClientResponse.class); //aca esta haciendo un get si o si

    // OPCION 2:
    Response.StatusType statusType = new Response.StatusType() {
      @Override
      public int getStatusCode() {
        return 0;
      }

      @Override
      public Response.Status.Family getFamily() {
        return null;
      }

      @Override
      public String getReasonPhrase() {
        return null;
      }
    }
    InBoundHeaders headers = new InBoundHeaders();
    InputStream entity = new InputStream() { // <---------- FEO
      @Override
      public int read() throws IOException {
        return 0;
      }
    };
    ProviderServices providerServices = new ProviderServices(); // <-------- Y ESTO?
    MessageBodyWorkers workers = new MessageBodyFactory(); // <-------- Y ESTO?

    ClientResponse clientResponse2 = new ClientResponse(statusType, headers, entity, workers);

    // RESULTADOS:
    when(apiMockeada.generarToken("mail@invalido")).thenReturn(clientResponse);
    Assertions.assertThrows(GenerarUsuarioException.class, () -> servicio.generarNuevoUsuario("mail@invalido"));
  }*/

}
