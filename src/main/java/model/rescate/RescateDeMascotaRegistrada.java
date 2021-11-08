package model.rescate;

import model.asociacion.Asociacion;
import model.mascota.Mascota;
import model.ubicacion.Ubicacion;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "RescatesDeMascotaRegistrada")
public class RescateDeMascotaRegistrada extends RescateDeMascota {
  @OneToOne
  @JoinColumn(name = "mascota_id")
  private Mascota mascota;
  
  public RescateDeMascotaRegistrada(List<String> fotos, String descripcion, Ubicacion ubicacion, Rescatista rescatista, LocalDateTime fecha, Mascota mascota) {
    super(fotos, descripcion, ubicacion, rescatista, fecha);
    this.mascota = mascota;
  }

  public void notificarEncuentroAlDuenio() {
   mascota.notificarAlDuenio("¡Encontraron a " + mascota.getNombre()
       + "! Podés contactar al rescatista: " + this.rescatista.obtenerTarjetaDePresentacion());
  }

  @Override
  public void registrarEn(Asociacion asociacion){
    asociacion.agregarRescateDeMascotaRegistrada(this);
  }
}
