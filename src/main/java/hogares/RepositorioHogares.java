package hogares;

import caracteristicas.CaracteristicaDefinida;
import mascota.TipoAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioHogares {
  List<HogarDeTransito> hogares = new ArrayList<>();

  public List<HogarDeTransito> obtenerHogaresPosibles(List <CaracteristicaDefinida> caracteristicasDeMascota, TipoAnimal tipoAnimal, /*Ubicacion ubicacion,*/ double radio){
    List<HogarDeTransito> hogaresDentroDelRadio = hogares; //obtenerHogaresDisponiblesDentroDelRadio(ubicacion, radio);
    return hogaresDentroDelRadio.stream().filter((hogar)->hogar.aceptaMascota(tipoAnimal, caracteristicasDeMascota)).collect(Collectors.toList());
  }

  private List<HogarDeTransito> obtenerHogaresDisponibles(){
    return hogares.stream().filter((hogar)->hogar.tieneLugaresDisponibles()).collect(Collectors.toList());
  }

/*
  private List<HogarDeTransito> obtenerHogaresDisponiblesDentroDelRadio(Ubicacion ubicacion, double radio){
    return obtenerHogaresDisponibles.stream().filter((hogar)->hogar.estaDentroDelRadio(ubicacion, radio)).collect(Collectors.toList());
  }
*/

}
