package rescate;

import mascota.Mascota;

import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaRegistrada extends RescateDeMascota {
  public RescateDeMascotaRegistrada(List<String> fotos, String descripcion, String ubicacion, Rescatista rescatista, LocalDateTime fecha, Mascota mascota) {
    super(fotos, descripcion, ubicacion, rescatista, fecha, mascota);
  }
}
