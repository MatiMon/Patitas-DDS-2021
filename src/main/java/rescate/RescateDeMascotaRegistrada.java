package rescate;

import mascota.Mascota;
import mascota.RepositorioQR;
import ubicacion.Ubicacion;
import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaRegistrada extends RescateDeMascota {
  private String codigoQR;
  //TODO Mascota mascota
  
  public RescateDeMascotaRegistrada(List<String> fotos, String descripcion, Ubicacion ubicacion, Rescatista rescatista, LocalDateTime fecha, String QR) {
    super(fotos, descripcion, ubicacion, rescatista, fecha);
    this.codigoQR = QR;
  }

  public void notificarEncuentroAlDuenio() { //TODO Test - manejo de error si falle notif
   Mascota mascota =  obtenerMascota();
   mascota.notificarEncuentroAlDuenio("¡Encontraron a " + mascota.getNombre()
       + "! Podés contactar al rescatista: " + this.rescatista.obtenerTarjetaDePresentacion());
  }

  private Mascota obtenerMascota() {
    return RepositorioQR.getInstancia().obtenerMascota(this.codigoQR);
  }
}
