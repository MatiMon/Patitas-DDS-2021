package hogares;

import caracteristicas.CaracteristicaDefinida;
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

  public boolean aceptaMascota(TipoAnimal tipoAnimal, List<CaracteristicaDefinida> caracteristicasDeMascota) {
    return admiteTipoAnimal(tipoAnimal); //&& admiteCaracteristicas(caracteristicasDeMascota);
  }

/*  private boolean admiteCaracteristicas(List<CaracteristicaDefinida> caracteristicasDeMascota) {

  }*/


  private boolean admiteTipoAnimal (TipoAnimal tipoAnimal){
    return animalesAdmitidos.contains(tipoAnimal);
  }

  public boolean tieneLugaresDisponibles() {
    return lugaresDisponibles > 0;
  }
}
