package hogares;

import caracteristicas.CaracteristicaDefinida;
import mascota.Tamanio;
import mascota.TipoAnimal;
import ubicacion.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class HogarDeTransito {
  Boolean tienePatio;
  int Capacidad;
  Ubicacion ubicacion;
  String telefono;
  List<TipoAnimal> animalesAdmitidos = new ArrayList<>();
  int lugaresDisponibles;
  List<CaracteristicaDefinida> caracteristicasPuntuales = new ArrayList<>();

  public HogarDeTransito(Boolean tienePatio, int capacidad, Ubicacion ubicacion, String telefono, List<TipoAnimal> animalesAdmitidos, int lugaresDisponibles, List<CaracteristicaDefinida> caracteristicasPuntuales) {
    this.tienePatio = tienePatio;
    Capacidad = capacidad;
    this.ubicacion = ubicacion;
    this.telefono = telefono;
    this.animalesAdmitidos = animalesAdmitidos;
    this.lugaresDisponibles = lugaresDisponibles;
    this.caracteristicasPuntuales = caracteristicasPuntuales;
  }

  public boolean admiteTipoAnimal (TipoAnimal tipoAnimal){
    return animalesAdmitidos.contains(tipoAnimal);
  }

  public boolean tieneLugaresDisponibles() {
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
}
