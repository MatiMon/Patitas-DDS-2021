package apiRefugioDds;

import org.codehaus.jackson.annotate.JsonProperty;

public class Admisiones { //quizas pueda ser un enum con comportamiento
  @JsonProperty("perros")
  private boolean perros;

  @JsonProperty("gatos")
  private boolean gatos;

  public boolean admitePerros() {
    return perros;
  }

  public boolean admiteGatos() {
    return gatos;
  }
}
