import asociacion.RepositorioAsociaciones;

import java.util.List;

public class RecomendadorMascotas {

  public List<PublicacionMascotaEnAdopcion> publicacionesMascotasEnAdopcionCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion) {
    List<PublicacionMascotaEnAdopcion> mascotasAdopcion = RepositorioAsociaciones.getInstancia().publicacionesEnAdopcion();
    return mascotasAdopcion.stream().filter(mascota -> mascota.esCompatible(intencionDeAdopcion));
  }

  public void generarRecomendaciones(){

  }
}
