package adopciones;

import asociacion.RepositorioAsociaciones;

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
        forEach(intencionAdopcion -> intencionAdopcion.recomendarMascotas(mensajeRecomendacion(publicacionesMascotasEnAdopcionCompatibles(intencionAdopcion))));
  }

  public static String mensajeRecomendacion(List<PublicacionMascotaEnAdopcion> publicacionesRecomendadas){
    String mensaje = "Le recomendamos las siguientes mascotas en adopcion: ";
    List<String> numerosPublicaciones = publicacionesRecomendadas.stream().map(PublicacionMascotaEnAdopcion::getNumeroPublicacion).collect(Collectors.toList());
    return mensaje.concat(String.join(", ", numerosPublicaciones));
  }
}
