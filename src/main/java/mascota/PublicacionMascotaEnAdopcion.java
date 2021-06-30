package mascota;

import caracteristicas.CaracteristicaDefinida;

import java.util.List;

public class PublicacionMascotaEnAdopcion {

  private int numeroPublicacion; //@TODO idem rescate, calcularlo?
  private List<CaracteristicaDefinida> comodidades;
  private Mascota mascota;


  public PublicacionMascotaEnAdopcion(List<CaracteristicaDefinida> comodidades,Mascota mascota) {
    this.mascota = mascota;
    this.comodidades = comodidades;
  }

  public boolean esCompatible(PublicacionIntencionDeAdopcion intencionDeAdopcion) {
    return comodidadesCompatibles(intencionDeAdopcion) && caracteristicasPersonalizadasCompatibles(intencionDeAdopcion) && caracteristicasBasicasCompatibles(intencionDeAdopcion);
  }

  private boolean comodidadesCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion){
    return comodidades.stream().allMatch(comodidad -> comodidad.esCompatibleCon(intencionDeAdopcion.valorComodidad(comodidad.getNombre())));
  }

  private boolean caracteristicasPersonalizadasCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion){
    return mascota.getCaracteristicaDefinidas().stream().allMatch(caracteristica -> caracteristica.esCompatibleCon(intencionDeAdopcion.valorCaracteristica(caracteristica.getNombre())));
  }

  private boolean caracteristicasBasicasCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion){
    return mascota.caracteristicasCompatiblesCon(intencionDeAdopcion);
  }

  //@TODO terminar de revisar!!
  public void notificarAlDuenioPosibleAdopcion(String mensaje){
    this.mascota.notificarAlDuenio(mensaje);
  }
}
