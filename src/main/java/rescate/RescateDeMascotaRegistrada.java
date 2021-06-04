package rescate;

import ubicacion.Ubicacion;
import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaRegistrada extends RescateDeMascota {
  private String codigoQR;
  
  public RescateDeMascotaRegistrada(List<String> fotos, String descripcion, Ubicacion ubicacion, Rescatista rescatista, LocalDateTime fecha, String QR) {
    super(fotos, descripcion, ubicacion, rescatista, fecha);
    this.codigoQR = QR;
  }
}
