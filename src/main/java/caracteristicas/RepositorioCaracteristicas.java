package caracteristicas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCaracteristicas {
  private List<Caracteristica> caracteristicasObligatorias = new ArrayList<>();
  private List<Caracteristica> caracteristicasOpcionales = new ArrayList<>();
  private static final RepositorioCaracteristicas INSTANCIA = new RepositorioCaracteristicas();


  //agregar a listas
  public void agregarCaracteristicaObligatoria(Caracteristica caracteristicaObligatoria){
    this.caracteristicasObligatorias.add(caracteristicaObligatoria);
  }

  public void agregarCaracteristicaOpcional(Caracteristica caracteristicaOpcional){
    this.caracteristicasOpcionales.add(caracteristicaOpcional);
  }

  //getter
  public List<Caracteristica> listarCaracterisitcasObligatorias(){
    return this.caracteristicasObligatorias;
  }

  public List<Caracteristica> listarCaracteristicasOpcionales() {
    return caracteristicasOpcionales;
  }

  public static RepositorioCaracteristicas getInstancia() {
    return INSTANCIA;
  }
}
