import caracteristicas.CaracteristicaDefinida;
import mascota.Mascota;

import java.util.List;

public class PublicacionMascotaEnAdopcion {

  private int numeroPublicacion;
  private List<CaracteristicaDefinida> comodidades;
  private Mascota mascota;
  public boolean esCompatible(PublicacionIntencionDeAdopcion intencionDeAdopcion) {
    return comodidadesCompatibles(intencionDeAdopcion) && caracteristicasPersonalizadasCompatibles(intencionDeAdopcion) && caracteristicasBasicasCompatibles(intencionDeAdopcion);
  }

  private boolean comodidadesCompatibles(PublicacionMascotaEnAdopcion intencionDeAdopcion){
    return comodidades.stream().allMatch(comodidad -> comodidad.esCompatibleCon(intencionDeAdopcion.valorComodidad(comodidad.getNombre())));
  }

  private boolean caracteristicasPersonalizadasCompatibles(PublicacionMascotaEnAdopcion intencionDeAdopcion){
    return mascota.getCaracteristicaDefinidas().stream().allMatch(caracteristica -> caracteristica.esCompatibleCon(intencionDeAdopcion.valorCaracteristica(caracteristica.getNombre())));
  }

  private boolean caracteristicasBasicasCompatibles(PublicacionMascotaEnAdopcion intencionDeAdopcion){
    return mascota.caracteristicasCompatiblesCon(intencionDeAdopcion);
  }
}
