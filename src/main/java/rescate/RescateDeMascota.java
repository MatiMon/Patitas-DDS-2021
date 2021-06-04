package rescate;

import excepciones.MascotaRescatadaInvalidaException;
import ubicacion.Ubicacion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class RescateDeMascota {
  private List<String> fotos = new ArrayList<>();
  private String descripcion;
  private Ubicacion ubicacion;
  protected Rescatista rescatista;
  private LocalDateTime fecha;

  public RescateDeMascota(List<String> fotos, String descripcion, Ubicacion ubicacion, Rescatista rescatista, LocalDateTime fecha) {
    if(fotos.size()<1){
      throw new MascotaRescatadaInvalidaException("debe tener al menos una foto");
    }
    // VALIDAR DESCRIPCION Y UBICACION?
    this.fotos = fotos;
    this.descripcion = descripcion;
    this.ubicacion = ubicacion;
    this.rescatista = rescatista;
    this.fecha = fecha;
  }

  public void agregarFoto(String foto){
    this.fotos.add(foto);
  }

  public LocalDateTime getFecha() {
    return fecha;
  }
}


