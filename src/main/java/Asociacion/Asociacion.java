package Asociacion;

import rescate.RescateDeMascota;
import rescate.RescateDeMascotaRegistrada;
import rescate.RescateDeMascotaSinRegistrar;
import ubicacion.Ubicacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Asociacion {

  private String nombre;
  Ubicacion ubicacion;
  List<RescateDeMascotaSinRegistrar> rescatesDeMascotasSinRegistrar = new ArrayList<>();
  List<RescateDeMascotaRegistrada> rescatesDeMascotasRegistradas = new ArrayList<>();;

  public Asociacion(String nombre, Ubicacion ubicacion,
                    List<RescateDeMascotaSinRegistrar> rescateDeMascotasSinRegistrar,
                    List<RescateDeMascotaRegistrada> rescateDeMascotasRegistradas) {
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.rescatesDeMascotasSinRegistrar = rescateDeMascotasSinRegistrar;
    this.rescatesDeMascotasRegistradas = rescateDeMascotasRegistradas;
  }

  //@TODO ver el tema de asociar una Publicacion con la Asociacion MAS CERCANA
   public List<RescateDeMascota> ultimasMascotasEncontradas(int dias) {
    List<RescateDeMascota> rescateDeMascotas = new ArrayList<>();
    rescateDeMascotas.addAll(this.ultimasMascotasSinRegistrarAprobadasEncontradas(dias));
    rescateDeMascotas.addAll(this.ultimasMascotasRegistradasEncontradas(dias));
    return rescateDeMascotas;
  }

  public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesSinAprobar() {
    return this.rescatesDeMascotasSinRegistrar.stream()
            .filter(publicaciones -> !publicaciones.getEstadoDeAprobacion())
            .collect(Collectors.toList());
  }

  public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesAprobadas() {
    return this.rescatesDeMascotasSinRegistrar.stream()
            .filter(RescateDeMascotaSinRegistrar::getEstadoDeAprobacion)
            .collect(Collectors.toList());
  }

  public void agregarRescateDeMascotaSinRegistar(RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar) {
    this.rescatesDeMascotasSinRegistrar.add(rescateDeMascotaSinRegistrar);
  }

  public void agregarRescateDeMascotaRegistrada(RescateDeMascotaRegistrada rescateDeMascotaRegistrada) {
    this.rescatesDeMascotasRegistradas.add(rescateDeMascotaRegistrada);
  }


  /*Metodos Privados*/
  private List<RescateDeMascotaRegistrada> ultimasMascotasRegistradasEncontradas(int dias){
    return this.rescatesDeMascotasRegistradas.stream()
            .filter(rescateDeMascota -> rescateDeMascota.getFecha().isAfter(LocalDateTime.now().minusDays(dias+1)))
            .collect(Collectors.toList());
  }
  private List<RescateDeMascotaSinRegistrar> ultimasMascotasSinRegistrarAprobadasEncontradas(int dias){
    return this.rescatesDeMascotasSinRegistrar.stream()
            .filter(rescateDeMascota -> rescateDeMascota.getEstadoDeAprobacion() && rescateDeMascota.getFecha().isAfter(LocalDateTime.now().minusDays(dias+1)))
            .collect(Collectors.toList());
  }

}
