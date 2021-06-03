package rescate;

import mascota.Mascota;

import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaRegistrada extends RescateDeMascota {
  private String codigoQR;
  
  public RescateDeMascotaRegistrada(List<String> fotos, String descripcion, String ubicacion, InvolucradoEnRescate rescatista, LocalDateTime fecha, Mascota mascota, String QR) {
    super(fotos, descripcion, ubicacion, rescatista, fecha, mascota);
    this.codigoQR = QR;
  }
}
