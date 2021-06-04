package rescate;

import mascota.Mascota;

import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaSinRegistrar extends RescateDeMascota {
  private boolean estadoDeAprobacion;
  private int numeroDePublicacion;

  public RescateDeMascotaSinRegistrar(List<String> fotos, String descripcion, String ubicacion,
                                      InvolucradoEnRescate rescatista, LocalDateTime fecha, int numeroDePublicacion) {
    super(fotos, descripcion, ubicacion, rescatista, fecha);
    this.estadoDeAprobacion = false;
    this.numeroDePublicacion = numeroDePublicacion;
  }

  public void aprobarPublicacion() {
    this.estadoDeAprobacion = true;
  }

  public boolean getEstadoDeAprobacion() {
    return estadoDeAprobacion;
  }
}
