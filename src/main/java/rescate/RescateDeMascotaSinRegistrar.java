package rescate;

import asociacion.Asociacion;
import asociacion.RepositorioAsociaciones;
import caracteristicas.CaracteristicaDefinida;
import mascota.Tamanio;
import mascota.TipoAnimal;
import ubicacion.Ubicacion;
import java.time.LocalDateTime;
import java.util.List;

public class RescateDeMascotaSinRegistrar extends RescateDeMascota {
  private boolean estadoDeAprobacion;
  private Integer numeroDePublicacion;
  private TipoAnimal tipoAnimal;
  private Tamanio tamanio;
  private CaracteristicaDefinida personalidad; //texto libre

  public RescateDeMascotaSinRegistrar(List<String> fotos, String descripcion, Ubicacion ubicacion,
                                      Rescatista rescatista, LocalDateTime fecha, int numeroDePublicacion, Tamanio tamanio, TipoAnimal tipoAnimal, CaracteristicaDefinida personalidad) {
    super(fotos, descripcion, ubicacion, rescatista, fecha);
    this.estadoDeAprobacion = false;
    this.numeroDePublicacion = numeroDePublicacion;
    this.tipoAnimal = tipoAnimal;
    this.tamanio = tamanio;
    this.personalidad = personalidad;
  }

  public void aprobarPublicacion() {
    this.estadoDeAprobacion = true;
  }

  public void notificarEncuentroAlRescatista(String nombreDuenio, String apellidoDuenio, String datoDeContacto) { //TODO test -> el dueño se tiene que registrar
    this.rescatista.notificarEncuentro("¡La mascota de la publicación " + this.numeroDePublicacion.toString() +
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