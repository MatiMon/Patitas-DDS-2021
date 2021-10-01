package rescate;

import asociacion.Asociacion;
import caracteristicas.definidas.CaracteristicaDefinida;
import duenio.Duenio;
import mascota.Tamanio;
import mascota.TipoAnimal;
import ubicacion.Ubicacion;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "RescateDeMascotaSinRegistrar")
public class RescateDeMascotaSinRegistrar extends RescateDeMascota {

  @ManyToOne
  @JoinColumn(name = "duenio_id", referencedColumnName = "id")
  private Duenio duenio;
  private boolean estadoDeAprobacion;
  private Integer numeroIdentificatorio;

  @Enumerated(EnumType.ORDINAL)
  private TipoAnimal tipoAnimal;
  @Enumerated(EnumType.ORDINAL)
  private Tamanio tamanio;

  @OneToOne
  @JoinColumn(name = "caracteristicaDefinida_id", referencedColumnName = "id")
  private CaracteristicaDefinida personalidad; //texto libre

  public RescateDeMascotaSinRegistrar(List<String> fotos, String descripcion, Ubicacion ubicacion,
                                      Rescatista rescatista, LocalDateTime fecha, Tamanio tamanio,
                                      TipoAnimal tipoAnimal, CaracteristicaDefinida personalidad, Duenio duenio) {
    super(fotos, descripcion, ubicacion, rescatista, fecha);
    this.estadoDeAprobacion = false;
    this.tipoAnimal = tipoAnimal;
    this.tamanio = tamanio;
    this.personalidad = personalidad;
    this.duenio = duenio;
  }

  public void aprobarPublicacion() {
    this.estadoDeAprobacion = true;
  }

  public void notificarEncuentroAlRescatista() { //TODO test -> el dueño se tiene que registrar
    this.rescatista.notificarEncuentro("¡La mascota de la publicación " + this.numeroIdentificatorio.toString() +
        " fue encontrada por su dueño! Los datos del mismo son: " + this.duenio.obtenerTarjetaDePresentacion());
  }

  public boolean getEstadoDeAprobacion() {
    return estadoDeAprobacion;
  }

  @Override
  public void registrarEn(Asociacion asociacion){
    asociacion.agregarRescateDeMascotaSinRegistar(this);
  }

  public void setNumeroIdentificatorio(Integer numeroIdentificatorio) {
    this.numeroIdentificatorio = numeroIdentificatorio;
  }
}