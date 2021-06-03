package apiRefugioDds;


import mascota.TipoAnimal;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({"id"})
public class HogarDeTransito {

  @JsonProperty("nombre")
  private String nombre;

  @JsonProperty("ubicacion")
  private Ubicacion ubicacion;

  @JsonProperty("telefono")
  private String telefono;

  @JsonProperty("admisiones")
  private Admisiones admisiones;

  @JsonProperty("capacidad")
  private int capacidad;

  @JsonProperty("lugares_disponibles")
  private int lugaresDisponibles;

  @JsonProperty("patio")
  private boolean poseePatio;

  @JsonProperty("caracteristicas")
  private List<String> caracteristicas;

  public HogarDeTransito() {
  }

  public String getNombre() {
    return nombre;
  }

  public Ubicacion getUbicacion() {
    return ubicacion;
  }

  public String getTelefono() {
    return telefono;
  }

  public Admisiones getAdmision() {
    return admisiones;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public int getLugaresDisponibles() {
    return lugaresDisponibles;
  }

  public boolean tienePatio() {
    return poseePatio;
  }

  public List<String> getCaracteristicas() {
    return caracteristicas;
  }
}
