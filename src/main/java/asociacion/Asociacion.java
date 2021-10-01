package asociacion;

import adopciones.PublicacionIntencionDeAdopcion;
import adopciones.PublicacionMascotaEnAdopcion;
import caracteristicas.ComodidadIdeal;
import rescate.RescateDeMascota;
import rescate.RescateDeMascotaRegistrada;
import rescate.RescateDeMascotaSinRegistrar;
import ubicacion.Ubicacion;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Entity
public class Asociacion {
    @Id
    @GeneratedValue
    private Long id;

    String nombre;

    @Embedded
    Ubicacion ubicacion;

    @Transient
    List<RescateDeMascotaSinRegistrar> rescatesDeMascotasSinRegistrar;
    @Transient
    List<RescateDeMascotaRegistrada> rescatesDeMascotasRegistradas;
    @OneToMany
    @JoinColumn(name = "AsociacionId", referencedColumnName = "id")
    List<PublicacionMascotaEnAdopcion> mascotasEnAdopcion;
    @OneToMany
    @JoinColumn(name = "AsociacionId", referencedColumnName = "id")
    List<PublicacionIntencionDeAdopcion> intencionesDeAdoptar;

    @Transient
    List<ComodidadIdeal> comodidadesPersonalizadas;


    public Asociacion(String nombre, Ubicacion ubicacion,
                      List<RescateDeMascotaSinRegistrar> rescateDeMascotasSinRegistrar,
                      List<RescateDeMascotaRegistrada> rescateDeMascotasRegistradas,
                      List<PublicacionMascotaEnAdopcion> mascotasEnAdopcion,
                      List<PublicacionIntencionDeAdopcion> intencionesDeAdoptar) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.rescatesDeMascotasSinRegistrar = rescateDeMascotasSinRegistrar;
        this.rescatesDeMascotasRegistradas = rescateDeMascotasRegistradas;
        this.mascotasEnAdopcion = mascotasEnAdopcion;
        this.intencionesDeAdoptar = intencionesDeAdoptar;
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

    public void agregarIntencionDeAdopcion(PublicacionIntencionDeAdopcion intencion) {
        this.intencionesDeAdoptar.add(intencion);
    }

    public void agregarMascotaEnAdopcion(PublicacionMascotaEnAdopcion adopcion){
        this.mascotasEnAdopcion.add(adopcion);
    }

    public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesRescatesSinAprobar() {
        return rescatesDeMascotasSinRegistrar.stream().filter(rescateDeMascotaSinRegistrar -> !rescateDeMascotaSinRegistrar.getEstadoDeAprobacion()).collect(Collectors.toList());
    }

    public List<RescateDeMascotaSinRegistrar> obtenerPublicacionesRescatesAprobadas() {
        return rescatesDeMascotasSinRegistrar.stream().filter(rescateDeMascotaSinRegistrar -> rescateDeMascotaSinRegistrar.getEstadoDeAprobacion()).collect(Collectors.toList());
    }

    public void darDeBaja(PublicacionIntencionDeAdopcion intencion) {
        this.intencionesDeAdoptar.remove(intencion);
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


    public List<PublicacionMascotaEnAdopcion> getMascotasEnAdopcion() {
        return mascotasEnAdopcion;
    }

    public List<PublicacionIntencionDeAdopcion> getIntencionesDeAdoptar() {
        return intencionesDeAdoptar;
    }

    public List<ComodidadIdeal> getComodidadesPersonalizadas() {
        return comodidadesPersonalizadas;
    }

    public void agregarComodidad(ComodidadIdeal comodidadIdeal){
        comodidadesPersonalizadas.add(comodidadIdeal);
    }

    public void removerComodidad(ComodidadIdeal comodidadIdeal){
        comodidadesPersonalizadas.remove(comodidadIdeal);
    }
}
