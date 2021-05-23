package caracteristicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioCaracteristicasPosibles {
  private static List<CaracteristicaPosible> caracteristicas = new ArrayList<>();

  private static final RepositorioCaracteristicasPosibles INSTANCIA = new RepositorioCaracteristicasPosibles();


  //agregar a listas
  public void agregarCaracterisitcaIdeal(CaracteristicaPosible caracteristica){
    caracteristicas.add(caracteristica);
  }

  //getter
  public static List<CaracteristicaPosible> getCaracteristicas(){
    return caracteristicas;
  }

  public static CaracteristicaPosible getCaracteristicaIdeal(String nombre){
    Optional<CaracteristicaPosible> nuevaCaracteristica = caracteristicas.stream().filter(caracteristica -> caracteristica.getNombre() == nombre).findAny();
    if(!nuevaCaracteristica.isPresent()){
      //TODO tirar excepcion gg la caracteristica que quiere ingresar no existe
    }
    return nuevaCaracteristica.get();
  }

  public static RepositorioCaracteristicasPosibles getInstancia() {
    return INSTANCIA;
  }
}
