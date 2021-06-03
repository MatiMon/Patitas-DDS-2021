package apiRefugioDds;

import org.codehaus.jackson.annotate.JsonProperty;

public class Ubicacion {
  @JsonProperty("direccion")
  private String direccion;

  @JsonProperty("lat")
  private Double latitud;

  @JsonProperty("long")
  private Double longitud;

  public String getDireccion() {
    return direccion;
  }

  public Double getLatitud() {
    return latitud;
  }

  public Double getLongitud() {
    return longitud;
  }
}
