package rescate;

import mascota.Mascota;

import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaSinRegistrar extends RescateDeMascota {
  public RescateDeMascotaSinRegistrar(List<String> fotos, String descripcion, String ubicacion, InvolucradoEnRescate rescatista, LocalDateTime fecha, Mascota mascota) {
    super(fotos, descripcion, ubicacion, rescatista, fecha, mascota);
  }
}
