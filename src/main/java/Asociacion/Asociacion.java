package Asociacion;

import rescate.RescateDeMascota;
import rescate.RescateDeMascotaRegistrada;
import rescate.RescateDeMascotaSinRegistrar;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Asociacion {

  private String nombre;
  Ubicacion ubicacion;
  List<RescateDeMascotaSinRegistrar> rescateDeMascotasSinRegistrar;
  List<RescateDeMascotaRegistrada> rescateDeMascotasRegistradas;

  public Asociacion(String nombre, Ubicacion ubicacion,
                    List<RescateDeMascotaSinRegistrar> rescateDeMascotasSinRegistrar,
                    List<RescateDeMascotaRegistrada> rescateDeMascotasRegistradas) {
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.rescateDeMascotasSinRegistrar = rescateDeMascotasSinRegistrar;
    this.rescateDeMascotasRegistradas = rescateDeMascotasRegistradas;
  }
  public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesSinAprobar() {
    //TODO filtrar
    return this.rescateDeMascotasSinRegistrar;
  }
  public List<RescateDeMascotaRegistrada> ultimasMascotasEncontradas(int dias){
    return this.rescatesDeMascotasRegistradas.stream()
            .filter(rescateDeMascota -> rescateDeMascota.getFecha().isAfter(LocalDateTime.now().minusDays(dias+1)))
            .collect(Collectors.toList());
  }
}
