package hogares;

import mascota.Tamanio;
import mascota.TipoAnimal;
import ubicacion.Ubicacion;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioHogares {
  List<HogarDeTransito> hogares = new ArrayList<>();
  private static RepositorioHogares instancia = new RepositorioHogares();

  public RepositorioHogares getInstancia(){
    return instancia;
  }

  public void agregarHogar(HogarDeTransito hogar){
    hogares.add(hogar);
  }

  /* OPCION 1 */

  private List<HogarDeTransito> obtenerHogaresValidos(Tamanio tamanio, TipoAnimal tipoAnimal, double radio , Ubicacion ubicacion){
    List<HogarDeTransito> hogaresDisponiblesDentroDelRadio = obtenerHogaresDisponiblesDentroDelRadio(ubicacion, radio);
    List<HogarDeTransito> hogaresValidosTipoAnimal = obtenerHogaresSegunTipoAnimal(hogaresDisponiblesDentroDelRadio, tipoAnimal);
    return obtenerHogaresSegunTamanio(hogaresValidosTipoAnimal, tamanio);
  }

  public List<HogarDeTransito> obtenerHogaresSegunTamanio(List<HogarDeTransito> hogares, Tamanio tamanio){
    return hogares.stream().filter((hogar)->hogar.admiteTamanio(tamanio)).collect(Collectors.toList());
  }

  public List<HogarDeTransito> obtenerHogaresSegunTipoAnimal(List<HogarDeTransito> hogares, TipoAnimal tipoAnimal){
    return hogares.stream().filter((hogar)->hogar.admiteTipoAnimal(tipoAnimal)).collect(Collectors.toList());
  }

  public List<HogarDeTransito> obtenerHogaresDisponiblesDentroDelRadio(Ubicacion ubicacionRescate, double radio){
    return hogares.stream().filter((hogar)->hogar.estaDisponibleYcercaDe(ubicacionRescate, radio)).collect(Collectors.toList());
  }

  /* OPCION 2 */
  public List<HogarDeTransito> obtenerHogaresValidosAnimal(TipoAnimal tipoAnimal,Tamanio tamanio, double radio , Ubicacion ubicacion){
    return hogares.stream().filter((hogar)->hogar.admiteAnimal(tipoAnimal, tamanio,  radio , ubicacion)).collect(Collectors.toList());
  }


}
