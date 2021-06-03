package apiRefugioDds;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class UsuarioAPI {

  @JsonIgnore
  private String email;

  @JsonProperty("bearer_token")
  private String bearerToken;

  public UsuarioAPI() {
  }

  public String getBearerToken() {
    return bearerToken;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
