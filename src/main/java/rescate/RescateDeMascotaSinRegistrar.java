package rescate;

import ubicacion.Ubicacion;
import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaSinRegistrar extends RescateDeMascota {
  private boolean estadoDeAprobacion;
  private Integer numeroDePublicacion;

  public RescateDeMascotaSinRegistrar(List<String> fotos, String descripcion, Ubicacion ubicacion,
                                      Rescatista rescatista, LocalDateTime fecha, int numeroDePublicacion) {
    super(fotos, descripcion, ubicacion, rescatista, fecha);
    this.estadoDeAprobacion = false;
    this.numeroDePublicacion = numeroDePublicacion;
  }

  public void aprobarPublicacion() {
    this.estadoDeAprobacion = true;
  }

  public void notificarEncuentroAlRescatista(String nombreDuenio, String apellidoDuenio, String datoDeContacto) {
    this.rescatista.notificarEncuentro("¡La mascota de la publicación " + this.numeroDePublicacion.toString() +
        " fue encontrada por su dueño! Los datos del mismo son: *Nombre: " + nombreDuenio + " " + apellidoDuenio +
        " *Dato de contacto: " + datoDeContacto);
  }

  public boolean getEstadoDeAprobacion() {
    return estadoDeAprobacion;
  }
}
