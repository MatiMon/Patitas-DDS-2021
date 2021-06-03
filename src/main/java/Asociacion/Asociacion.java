package Asociacion;

import rescate.RescateDeMascota;
import rescate.RescateDeMascotaRegistrada;
import rescate.RescateDeMascotaSinRegistrar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Asociacion {

  private String nombre;
  //Ubicacion ubicacion;
  List<RescateDeMascotaSinRegistrar> rescatesDeMascotasSinRegistrar = new ArrayList<>();
  List<RescateDeMascotaRegistrada> rescatesDeMascotasRegistradas = new ArrayList<>();;

  public Asociacion(String nombre, /*Ubicacion ubicacion,*/
                    List<RescateDeMascotaSinRegistrar> rescateDeMascotasSinRegistrar,
                    List<RescateDeMascotaRegistrada> rescateDeMascotasRegistradas) {
    this.nombre = nombre;
    /*this.ubicacion = ubicacion;*/
    this.rescatesDeMascotasSinRegistrar = rescateDeMascotasSinRegistrar;
    this.rescatesDeMascotasRegistradas = rescateDeMascotasRegistradas;
  }

  //@TODO ver el tema de asociar una Publicacion con la Asociacion MAS CERCANA
  //@TODO ver si funciona, ahora al tener que mostrar TODOS los rescates, es una combinacion de ambas listas
  public List<RescateDeMascota> ultimasMascotasEncontradas(int dias) {
    List<RescateDeMascota> rescateDeMascotas = new ArrayList<>();
    rescateDeMascotas.addAll(this.ultimasMascotasSinRegistrarEncontradas(dias));
    rescateDeMascotas.addAll(this.ultimasMascotasRegistradasEncontradas(dias));
    return rescateDeMascotas;
  }

  //@TODO agregar metodo (getter) a la clase, redundante comparar true o false?
  /*
  public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesSinAprobar() {
    return this.rescatesDeMascotasSinRegistrar.stream()
            .filter(publicaciones -> publicaciones.estaAprobada() == true)
            .collect(Collectors.toList());
  }

  public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesAprobadas() {
    return this.rescatesDeMascotasSinRegistrar.stream()
            .filter(publicaciones -> publicaciones.estaAprobada() == false)
            .collect(Collectors.toList());
  }*/


  //TODO ver si se abstrae la logica repetida de la búsqueda
  private List<RescateDeMascotaRegistrada> ultimasMascotasRegistradasEncontradas(int dias){
    return this.rescatesDeMascotasRegistradas.stream()
            .filter(rescateDeMascota -> rescateDeMascota.getFecha().isAfter(LocalDateTime.now().minusDays(dias+1)))
            .collect(Collectors.toList());
  }
  private List<RescateDeMascotaSinRegistrar> ultimasMascotasSinRegistrarEncontradas(int dias){
    return this.rescatesDeMascotasSinRegistrar.stream()
            .filter(rescateDeMascota -> rescateDeMascota.getFecha().isAfter(LocalDateTime.now().minusDays(dias+1)))
            .collect(Collectors.toList());
  }
}
