package mascota;

import asociacion.RepositorioAsociaciones;
import mascota.PublicacionIntencionDeAdopcion;
import mascota.PublicacionMascotaEnAdopcion;

import java.util.List;
import java.util.stream.Collectors;

public class RecomendadorMascotas {
  private static RecomendadorMascotas INSTANCIA = new RecomendadorMascotas();

  public static RecomendadorMascotas getInstancia(){
    return INSTANCIA;
  }

  public static List<PublicacionMascotaEnAdopcion> publicacionesMascotasEnAdopcionCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion) {
    List<PublicacionMascotaEnAdopcion> mascotasAdopcion = RepositorioAsociaciones.getInstancia().publicacionesMascotasEnAdopcion();
    return mascotasAdopcion.stream().filter(mascota -> mascota.esCompatible(intencionDeAdopcion)).collect(Collectors.toList());
  }

  public static void generarRecomendaciones(){
    RepositorioAsociaciones.getInstancia().publicacionesIntencionDeAdopcion().
        forEach(intencionAdopcion -> intencionAdopcion.recomendarMascotas(publicacionesMascotasEnAdopcionCompatibles(intencionAdopcion)));
  }
}
