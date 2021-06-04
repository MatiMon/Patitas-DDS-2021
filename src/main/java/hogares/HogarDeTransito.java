package hogares;

import apiRefugioDds.Admisiones;
import caracteristicas.CaracteristicaDefinida;
import mascota.Tamanio;
import mascota.TipoAnimal;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import ubicacion.Ubicacion;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"id"})
public class HogarDeTransito {
  @JsonProperty("patio")
  Boolean tienePatio;

  @JsonProperty("nombre")
  String nombre;

  @JsonProperty("capacidad")
  int Capacidad;

  @JsonProperty("ubicacion")
  Ubicacion ubicacion;

  @JsonProperty("telefono")
  String telefono;

  @JsonProperty("admisiones")
  //List<String> admisiones;
  private Admisiones admisiones; //unificar

  List<TipoAnimal> animalesAdmitidos = new ArrayList<>();

  @JsonProperty("lugares_disponibles")
  int lugaresDisponibles;

  @JsonProperty("caracteristicas")
  List<String> caracteristicasPuntuales = new ArrayList<>();

  public HogarDeTransito(Boolean tienePatio, int capacidad, Ubicacion ubicacion, String telefono, List<TipoAnimal> animalesAdmitidos, int lugaresDisponibles, List<String> caracteristicasPuntuales) {
    this.tienePatio = tienePatio;
    Capacidad = capacidad;
    this.ubicacion = ubicacion;
    this.telefono = telefono;
    this.animalesAdmitidos = animalesAdmitidos;
    this.lugaresDisponibles = lugaresDisponibles;
    this.caracteristicasPuntuales = caracteristicasPuntuales;
  }

  public HogarDeTransito() {

  }

  public boolean admiteTipoAnimal (TipoAnimal tipoAnimal){
    return animalesAdmitidos.contains(tipoAnimal);
  }

  private boolean tieneLugaresDisponibles() {
    return lugaresDisponibles > 0;
  }

  public boolean admiteTamanio(Tamanio tamanio) {
    return !(tamanio.necesitaPatio() ^ tienePatio);
  }

  public boolean estaDisponibleYcercaDe(Ubicacion ubicacionRescate, double radio) {
    return ubicacion.estaDentroDelRadio(ubicacionRescate, radio) && tieneLugaresDisponibles();
  }

  /* OPCION 2 */
/*  public boolean admiteAnimal(TipoAnimal tipoAnimal, Tamanio tamanio, double radio , Ubicacion ubicacionRescate){
    return tieneLugaresDisponibles() && admiteTamanio(tamanio) && admiteTipoAnimal(tipoAnimal)
        && ubicacion.estaDentroDelRadio(ubicacionRescate, radio);
  }*/

  public String getNombre() {
    return nombre;
  }

  public Ubicacion getUbicacion() {
    return ubicacion;
  }

  public List<String> getCaracteristicas() {
    return caracteristicasPuntuales;
  }
}
