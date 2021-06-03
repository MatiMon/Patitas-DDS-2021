package apiRefugioDds;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class RespuestaRefugioDdsAPI {
  @JsonProperty("total")
  private int totalHogares;

  @JsonProperty("offset")
  private String numeroPagina = "1";

  @JsonProperty("hogares")
  private List<HogarDeTransito> hogares;

  public RespuestaRefugioDdsAPI() {
  }

  public int getTotalHogares() {
    return totalHogares;
  }

  public List<HogarDeTransito> getHogares() {
    return hogares;
  }
}
