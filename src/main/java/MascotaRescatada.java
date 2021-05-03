import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MascotaRescatada {
  List<String> fotos = new ArrayList<>();
  String descripcion;
  String ubicacion;
  Rescatista rescatista;
  LocalDateTime fecha;

  public MascotaRescatada(List<String> fotos, String descripcion, String ubicacion, Rescatista rescatista, LocalDateTime fecha) {
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

}
