package asociacion;

import mascota.PublicacionIntencionDeAdopcion;
import mascota.PublicacionMascotaEnAdopcion;
import rescate.RescateDeMascota;
import rescate.RescateDeMascotaRegistrada;
import rescate.RescateDeMascotaSinRegistrar;
import ubicacion.Ubicacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Asociacion {

    String nombre;
    Ubicacion ubicacion;
    List<RescateDeMascotaSinRegistrar> rescatesDeMascotasSinRegistrar;
    List<RescateDeMascotaRegistrada> rescatesDeMascotasRegistradas;
    List<PublicacionMascotaEnAdopcion> mascotasEnAdopcion;
    List<PublicacionIntencionDeAdopcion> intencionesDeAdoptar;

    public Asociacion(String nombre, Ubicacion ubicacion,
                      List<RescateDeMascotaSinRegistrar> rescateDeMascotasSinRegistrar,
                      List<RescateDeMascotaRegistrada> rescateDeMascotasRegistradas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.rescatesDeMascotasSinRegistrar = rescateDeMascotasSinRegistrar;
        this.rescatesDeMascotasRegistradas = rescateDeMascotasRegistradas;
    }

    public List<RescateDeMascota> ultimasMascotasEncontradas(int dias) {
        List<RescateDeMascota> rescateDeMascotas = new ArrayList<>();
        rescateDeMascotas.addAll(this.ultimasMascotasSinRegistrarAprobadasEncontradas(dias));
        rescateDeMascotas.addAll(this.ultimasMascotasRegistradasEncontradas(dias));
        return rescateDeMascotas;
    }

    public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesSinAprobar() {
        return this.rescatesDeMascotasSinRegistrar.stream()
                .filter(publicaciones -> !publicaciones.getEstadoDeAprobacion())
                .collect(Collectors.toList());
    }

    public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesAprobadas() {
        return this.rescatesDeMascotasSinRegistrar.stream()
                .filter(RescateDeMascotaSinRegistrar::getEstadoDeAprobacion)
                .collect(Collectors.toList());
    }

    public void agregarRescateDeMascotaSinRegistar(RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar) {
        this.rescatesDeMascotasSinRegistrar.add(rescateDeMascotaSinRegistrar);
    }

    public void agregarRescateDeMascotaRegistrada(RescateDeMascotaRegistrada rescateDeMascotaRegistrada) {
        this.rescatesDeMascotasRegistradas.add(rescateDeMascotaRegistrada);
    }

    public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesRescatesSinAprobar() {
        return rescatesDeMascotasSinRegistrar.stream().filter(rescateDeMascotaSinRegistrar -> !rescateDeMascotaSinRegistrar.getEstadoDeAprobacion()).collect(Collectors.toList());
    }

    public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesRescatesAprobadas() {
        return rescatesDeMascotasSinRegistrar.stream().filter(rescateDeMascotaSinRegistrar -> rescateDeMascotaSinRegistrar.getEstadoDeAprobacion()).collect(Collectors.toList());
    }


    /*Metodos Privados*/
    private List<RescateDeMascotaRegistrada> ultimasMascotasRegistradasEncontradas(int dias) {
        return this.rescatesDeMascotasRegistradas.stream()
                .filter(rescateDeMascota -> rescateDeMascota.getFecha().isAfter(LocalDateTime.now().minusDays(dias + 1)))
                .collect(Collectors.toList());
    }

    private List<RescateDeMascotaSinRegistrar> ultimasMascotasSinRegistrarAprobadasEncontradas(int dias) {
        return this.rescatesDeMascotasSinRegistrar.stream()
                .filter(rescateDeMascota -> rescateDeMascota.getEstadoDeAprobacion() && rescateDeMascota.getFecha().isAfter(LocalDateTime.now().minusDays(dias + 1)))
                .collect(Collectors.toList());
    }

    public String getNombre() {
        return nombre;
    }

    public double calcularDistanciaA(Ubicacion ubicacionRescate) {
        return ubicacion.calcularDistancia(ubicacionRescate);
    }

}
