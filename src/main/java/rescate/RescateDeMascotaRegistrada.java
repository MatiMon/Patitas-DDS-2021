package rescate;

import mascota.Mascota;
import mascota.RepositorioMascotas;
import ubicacion.Ubicacion;
import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaRegistrada extends RescateDeMascota {
  private Mascota mascota;
  
  public RescateDeMascotaRegistrada(List<String> fotos, String descripcion, Ubicacion ubicacion, Rescatista rescatista, LocalDateTime fecha, Mascota mascota) {
    super(fotos, descripcion, ubicacion, rescatista, fecha);
    this.mascota = mascota;
  }

  public void notificarEncuentroAlDuenio() { //TODO Test - manejo de error si falle notif
   mascota.notificarEncuentroAlDuenio("¡Encontraron a " + mascota.getNombre()
       + "! Podés contactar al rescatista: " + this.rescatista.obtenerTarjetaDePresentacion());
  }
}
