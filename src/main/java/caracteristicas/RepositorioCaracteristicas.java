package caracteristicas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCaracteristicas {
  private static List<CaracteristicaIdeal> caracteristicas = new ArrayList<>();

  private static final RepositorioCaracteristicas INSTANCIA = new RepositorioCaracteristicas();


  //agregar a listas
  public void agregarCaracterisitcaIdeal(CaracteristicaIdeal caracteristica){
    caracteristicas.add(caracteristica);
  }

  //getter
  public static List<CaracteristicaIdeal> getCaracteristicas(){
    return caracteristicas;
  }

  public static RepositorioCaracteristicas getInstancia() {
    return INSTANCIA;
  }
}
