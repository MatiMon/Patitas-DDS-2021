package rescate;

import asociacion.Asociacion;
import caracteristicas.CaracteristicaDefinida;
import duenio.Duenio;
import mascota.Tamanio;
import mascota.TipoAnimal;
import ubicacion.Ubicacion;
import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaSinRegistrar extends RescateDeMascota {
  private Duenio duenio;
  private boolean estadoDeAprobacion;
  private Integer numeroIdentificatorio; //TODO calcular el nro de publicacion
  private TipoAnimal tipoAnimal;
  private Tamanio tamanio;
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

  public void notificarEncuentroAlRescatista(String nombreDuenio, String apellidoDuenio, String datoDeContacto) { //TODO test -> el dueño se tiene que registrar
    this.rescatista.notificarEncuentro("¡La mascota de la publicación " + this.numeroIdentificatorio.toString() +
        " fue encontrada por su dueño! Los datos del mismo son: *Nombre: " + nombreDuenio + " " + apellidoDuenio +
        " *Dato de contacto: " + datoDeContacto);
  }

  public boolean getEstadoDeAprobacion() {
    return estadoDeAprobacion;
  }

  @Override
  public void registrarEn(Asociacion asociacion){
    asociacion.agregarRescateDeMascotaSinRegistar(this);
  }


}