package rescate;

import asociacion.Asociacion;
import asociacion.RepositorioAsociaciones;
import excepciones.MascotaRescatadaInvalidaException;
import ubicacion.Ubicacion;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class RescateDeMascota {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  @ElementCollection
  private List<String> fotos = new ArrayList<>();
  private String descripcion;

  @Embedded
  Ubicacion ubicacion;

  @ManyToOne
  @JoinColumn(name = "rescatista_id")
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

  public void registrar(){
    Asociacion asociacionMasCercada = RepositorioAsociaciones.getInstancia().asociacionMasCercana(ubicacion);
    registrarEn(asociacionMasCercada);
  }

  abstract public void registrarEn(Asociacion asociacion);
}


