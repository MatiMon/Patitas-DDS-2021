package rescate;

import mascota.Mascota;

import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaSinRegistrar extends RescateDeMascota {
  private boolean estadoDeAprobacion;
  private int numeroDePublicacion;
  private InvolucradoEnRescate duenioSinRegistrar;

  public RescateDeMascotaSinRegistrar(List<String> fotos, String descripcion, String ubicacion,
                                      InvolucradoEnRescate rescatista, LocalDateTime fecha, Mascota mascota, int numeroDePublicacion) {
    super(fotos, descripcion, ubicacion, rescatista, fecha, mascota);
    this.estadoDeAprobacion = false;
    this.numeroDePublicacion = numeroDePublicacion;
  }

  public void aprobarPublicacion(boolean estadoDeAprobacion) {
    this.estadoDeAprobacion = estadoDeAprobacion;
  }

  public boolean getEstadoDeAprobacion() {
    return estadoDeAprobacion;
  }

  public int getNumeroDePublicacion() {
    return numeroDePublicacion;
  }

  public InvolucradoEnRescate getDuenioSinRegistrar() {
    return duenioSinRegistrar;
  }

  public void setDuenioSinRegistrar(InvolucradoEnRescate duenioSinRegistrar) {
    this.duenioSinRegistrar = duenioSinRegistrar;
  }
}
