package Asociacion;

import Asociacion.Asociacion;
import caracteristicas.RepositorioCaracteristicasIdeales;
import rescate.RescateDeMascota;
import ubicacion.Ubicacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioAsociaciones {
  private List<Asociacion> asociaciones = new ArrayList<>();

  private static final RepositorioAsociaciones INSTANCIA = new RepositorioAsociaciones();

  public List<RescateDeMascota> ultimasMascotasEncontradas (int dias) {
    List<RescateDeMascota> rescatesGlobales = new ArrayList<>();
    this.asociaciones.forEach(asociacion -> rescatesGlobales.addAll(asociacion.ultimasMascotasEncontradas(dias)));
    return rescatesGlobales;
  }

  public List<RescateDeMascota> ultimasMascotasEncontradasEnTodasLasAsociaciones(int dias) {
    List<RescateDeMascota> rescatesGlobales = new ArrayList<>();
    this.asociaciones.forEach(asociacion -> rescatesGlobales.addAll(asociacion.ultimasMascotasEncontradas(dias)));
    return rescatesGlobales;
  }


  public Asociacion asociacionMasCercana (Ubicacion ubicacion) {

    this.asociaciones.sort(Comparator.comparing(asociacion -> asociacion.ubicacion.calcularDistancia(ubicacion)));
    //@TODO ver de manejar mejor este error en caso que el REPO este VACIO.
    return asociaciones.stream().findFirst().orElse(null);

  }

  public static RepositorioAsociaciones getInstancia() {
    return INSTANCIA;
  }

  public void agregarAsociacion(Asociacion asociacion){
    this.asociaciones.add(asociacion);
  }

  public void removerAsociacion(Asociacion asociacion){
    this.asociaciones.remove(asociacion);
  }
}
