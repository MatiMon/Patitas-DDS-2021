package mascota;

import asociacion.RepositorioAsociaciones;
import mascota.PublicacionIntencionDeAdopcion;
import mascota.PublicacionMascotaEnAdopcion;

import java.util.List;
import java.util.stream.Collectors;

public class RecomendadorMascotas {

  public List<PublicacionMascotaEnAdopcion> publicacionesMascotasEnAdopcionCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion) {
    List<PublicacionMascotaEnAdopcion> mascotasAdopcion = RepositorioAsociaciones.getInstancia().publicacionesMascotasEnAdopcion();
    return mascotasAdopcion.stream().filter(mascota -> mascota.esCompatible(intencionDeAdopcion)).collect(Collectors.toList());
  }

  public void generarRecomendaciones(){
    RepositorioAsociaciones.getInstancia().publicacionesIntencionDeAdopcion().
        forEach(intencionAdopcion -> intencionAdopcion.recomendarMascotas(this.publicacionesMascotasEnAdopcionCompatibles(intencionAdopcion)));
  }
}
