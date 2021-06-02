package hogares;

import caracteristicas.CaracteristicaDefinida;
import mascota.Tamanio;
import mascota.TipoAnimal;

import java.util.ArrayList;
import java.util.List;

public class HogarDeTransito {
  Boolean tienePatio;
  int Capacidad;
  //Ubicacion ubicacion;
  String telefono;
  List<TipoAnimal> animalesAdmitidos = new ArrayList<>();
  int lugaresDisponibles;
  List<CaracteristicaDefinida> caracteristicasPuntuales = new ArrayList<>();

  public boolean admiteTipoAnimal (TipoAnimal tipoAnimal){
    return animalesAdmitidos.contains(tipoAnimal);
  }

  public boolean tieneLugaresDisponibles() {
    return lugaresDisponibles > 0;
  }

  public boolean admiteTamanio(Tamanio tamanio) {
    return !(tamanio.necesitaPatio() ^ tienePatio);
  }

  public boolean admiteAnimal(TipoAnimal tipoAnimal, Tamanio tamanio, double radio /*Ubicacion ubicancionRescate*/){
    return tieneLugaresDisponibles() && admiteTamanio(tamanio) && admiteTipoAnimal(tipoAnimal);
    //&& ubicacion.estaDentroDelRadio(ubicacionRescate, radio);
  }
}
