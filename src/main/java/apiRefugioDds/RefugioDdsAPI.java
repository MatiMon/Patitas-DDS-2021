package apiRefugioDds;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;

public class RefugioDdsAPI {
  private Client client;
  private static final String API_REFUGIO_DDS = "https://api.refugiosdds.com.ar/api";
  private static final String RESOURCE_HOGARES = "hogares";
  private static final String RESOURCE_USUARIOS = "usuarios";
  private int maxElementosPorPagina = 10;

  //https://app.swaggerhub.com/apis-docs/ezequieloscarescobar/hogares-transito-mascotas/1.0-oas3#/
  //bearer token: pR0GYdKrgvKfVehIfRtFxZddIRYvxIynays7X4P6l07rNQcmovyAmmE9ZXJJ

  public RefugioDdsAPI() {
    ClientConfig clientConfig = new DefaultClientConfig();
    clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    this.client = Client.create(clientConfig);
  }

  public ClientResponse generarToken(String email) {
    String jsonBody = "{ \"email\": \"" + email + "\" }";

    return this.client.resource(API_REFUGIO_DDS).path(RESOURCE_USUARIOS)
        .header("Content-Type", "application/json")
        .accept(MediaType.APPLICATION_JSON)
        .post(ClientResponse.class, jsonBody);
  }

  public ClientResponse getPaginaDeHogares(String pagina, String bearerToken) {
    return this.client.resource(API_REFUGIO_DDS).path(RESOURCE_HOGARES)
        .queryParam("offset", pagina).header("Authorization", "Bearer " + bearerToken)
        .accept(MediaType.APPLICATION_JSON)
        .get(ClientResponse.class);
  }

  public int getMaxElementosPorPagina() {
    return maxElementosPorPagina;
  }
}
