package rescate;

import excepciones.MascotaRescatadaInvalidaException;
import mascota.Mascota;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RescateDeMascota {
  private List<String> fotos = new ArrayList<>();
  private String descripcion;
  private String ubicacion;
  private Rescatista rescatista;
  private LocalDateTime fecha;
  private Mascota mascota;

  public RescateDeMascota(List<String> fotos, String descripcion, String ubicacion, Rescatista rescatista, LocalDateTime fecha, Mascota mascota) {
    if(fotos.size()<1){
      throw new MascotaRescatadaInvalidaException("debe tener al menos una foto");
    }
    // VALIDAR DESCRIPCION Y UBICACION?
    this.fotos = fotos;
    this.descripcion = descripcion;
    this.ubicacion = ubicacion;
    this.rescatista = rescatista;
    this.fecha = fecha;
    this.mascota = mascota;
  }

  public void agregarFoto(String foto){
    this.fotos.add(foto);
  }

  public LocalDateTime getFecha() {
    return fecha;
  }
}


