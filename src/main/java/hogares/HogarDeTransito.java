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

  public boolean aceptaTipoAnimal(TipoAnimal tipoAnimal) {
    return admiteTipoAnimal(tipoAnimal);
  }

/*  public boolean aceptaTamanioAnimal(){
    if(tienePatio )
  }
  public List<TamanioAnimal> tamanioAnimalAceptados{
    if (tienePatio) return [TamanioAnimal.MEDIANO, TamanioAnimal.GRANDE];
    return [TamanioAnimal.CHICO];
  }*/

  private boolean admiteTipoAnimal (TipoAnimal tipoAnimal){
    return animalesAdmitidos.contains(tipoAnimal);
  }

  public boolean tieneLugaresDisponibles() {
    return lugaresDisponibles > 0;
  }
}
