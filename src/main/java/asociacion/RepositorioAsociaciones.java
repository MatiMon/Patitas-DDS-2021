package asociacion;

import mascota.PublicacionIntencionDeAdopcion;
import mascota.PublicacionMascotaEnAdopcion;
import rescate.RescateDeMascota;
import rescate.RescateDeMascotaSinRegistrar;
import ubicacion.Ubicacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepositorioAsociaciones {
  private List<Asociacion> asociaciones = new ArrayList<>();

  private static final RepositorioAsociaciones INSTANCIA = new RepositorioAsociaciones();

  public List<RescateDeMascotaSinRegistrar> publicacionesRescatesAprobados() {
    List<RescateDeMascotaSinRegistrar> publicaciones = new ArrayList<>();
    this.asociaciones.forEach(asociacion -> publicaciones.addAll(asociacion.obtenerPublicacionesAprobadas()));
    return publicaciones;
  }

  // VER SI QUEDA ESTE METODO EN BASE A LOS REQUERIMIENTOS - TODO esto no va creo
  public List<RescateDeMascota> ultimasMascotasEncontradas(int dias) {
    List<RescateDeMascota> rescatesGlobales = new ArrayList<>();
    this.asociaciones.forEach(asociacion -> rescatesGlobales.addAll(asociacion.ultimasMascotasEncontradas(dias)));
    return rescatesGlobales;
  }

  public Asociacion asociacionMasCercana (Ubicacion ubicacion) {
    this.asociaciones.sort(Comparator.comparing(asociacion -> asociacion.calcularDistanciaA(ubicacion)));
    //TODO ver de manejar mejor este error en caso que el REPO este VACIO.
    return asociaciones.stream().findFirst().orElse(null);
  }

  public List<PublicacionMascotaEnAdopcion> publicacionesMascotasEnAdopcion() {
    List<PublicacionMascotaEnAdopcion> mascotasEnAdopcionGlobales = new ArrayList<>();
    this.asociaciones.forEach(asociacion -> mascotasEnAdopcionGlobales.addAll(asociacion.getMascotasEnAdopcion()));
    return mascotasEnAdopcionGlobales;
  }

  public List<PublicacionIntencionDeAdopcion> publicacionesIntencionDeAdopcion() {
    List<PublicacionIntencionDeAdopcion> intencionesDeAdoptarGlobales = new ArrayList<>();
    this.asociaciones.forEach(asociacion -> intencionesDeAdoptarGlobales.addAll(asociacion.getIntencionesDeAdoptar()));
    return intencionesDeAdoptarGlobales;
  }

  public static RepositorioAsociaciones getInstancia() {
    return INSTANCIA;
  }

  public void agregarAsociacion(Asociacion asociacion){
    this.asociaciones.add(asociacion);
  }

  public void removerAsociacion(Asociacion asociacion){
    this.asociaciones.remove(asociacion);
  }
}
