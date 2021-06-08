package hogares;

import caracteristicas.TextoDefinida;
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

  public List<HogarDeTransito> obtenerHogaresValidosAnimal(TipoAnimal tipoAnimal,Tamanio tamanio, double radio , Ubicacion ubicacion, TextoDefinida personalidad){
    return hogares.stream().filter((hogar)->hogar.admiteAnimal(tipoAnimal, tamanio,  radio , ubicacion, personalidad)).collect(Collectors.toList());
  }


}
