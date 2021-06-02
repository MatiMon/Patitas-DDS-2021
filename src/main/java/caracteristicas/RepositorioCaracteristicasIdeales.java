package caracteristicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioCaracteristicasIdeales {
  private static List<CaracteristicaIdeal> caracteristicas = new ArrayList<>();

  private static final RepositorioCaracteristicasIdeales INSTANCIA = new RepositorioCaracteristicasIdeales();

  public void agregarCaracteristicaIdeal(CaracteristicaIdeal caracteristica){
    caracteristicas.add(caracteristica);
  }

  public static List<CaracteristicaIdeal> getCaracteristicas(){
    return caracteristicas;
  }

  public static List<CaracteristicaIdeal> getCaractetisticasObligatorias(){
    return caracteristicas.stream().filter(CaracteristicaIdeal::esObligatoria).collect(Collectors.toList());
  }

  public static List<String> getNombresCaracteristicasObligatorias(){
    return getCaractetisticasObligatorias().stream().map(CaracteristicaIdeal::getNombre).collect(Collectors.toList());
  }

  public static RepositorioCaracteristicasIdeales getInstancia() {
    return INSTANCIA;
  }
}
