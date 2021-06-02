package hogares;

import caracteristicas.CaracteristicaDefinida;
import mascota.TipoAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioHogares {
  List<HogarDeTransito> hogares = new ArrayList<>();

  private List<HogarDeTransito> obtenerHogaresDisponibles(){
    return hogares.stream().filter((hogar)->hogar.tieneLugaresDisponibles()).collect(Collectors.toList());
  }

/*
  public List<HogarDeTransito> obtenerHogaresDisponiblesDentroDelRadio(Ubicacion ubicacion, double radio){
    return obtenerHogaresDisponibles.stream().filter((hogar)->hogar.estaDentroDelRadio(ubicacion, radio)).collect(Collectors.toList());
  }
*/

}
