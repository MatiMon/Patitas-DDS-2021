package mascota;

import caracteristicas.CaracteristicaDefinida;
import duenio.Duenio;

import java.util.List;

public class PublicacionIntencionDeAdopcion {
    private List<CaracteristicaDefinida> comodidades;
    private List<CaracteristicaDefinida> caracteristicasMascota;
    private Duenio posibleDuenio;
    private TipoAnimal tipoAnimal;
    private Sexo sexoMascota;
    private Tamanio tamanioMascota;

    public PublicacionIntencionDeAdopcion(List<CaracteristicaDefinida> comodidades, List<CaracteristicaDefinida> caracteristicasMascota,
                                          Duenio posibleDuenio, TipoAnimal tipoAnimal, Sexo sexoMascota, Tamanio tamanioMascota) {
        this.comodidades = comodidades;
        this.caracteristicasMascota = caracteristicasMascota;
        this.posibleDuenio = posibleDuenio;
        this.tipoAnimal = tipoAnimal;
        this.sexoMascota = sexoMascota;
        this.tamanioMascota = tamanioMascota;
    }

    public void recomendarMascotas(String mensajeDeNotificacion) {
        this.posibleDuenio.notificar(mensajeDeNotificacion);
    }

    public CaracteristicaDefinida valorCaracteristica(String nombreCaracteristica) {
        return obtenerCaracteristica(this.caracteristicasMascota, nombreCaracteristica);
    }

    public CaracteristicaDefinida valorComodidad(String nombreComodidad) {
        return obtenerCaracteristica(this.comodidades, nombreComodidad);
    }

    private CaracteristicaDefinida obtenerCaracteristica(List<CaracteristicaDefinida> caracteristicas, String nombreCaracteristica) {
        return caracteristicas.stream().
            filter(caracteristica -> caracteristica.getNombre().equals(nombreCaracteristica)).findAny().orElse(null);
    }

    public void darDeBaja(String linkDeBaja) {
        this.posibleDuenio.notificar("Se ha creado tu publicación, podés darla de baja con el siguiente link: " + linkDeBaja);
    }

    public TipoAnimal getTipoAnimal() {
        return this.tipoAnimal;
    }

    public Sexo getSexo() {
        return this.sexoMascota;
    }

    public Tamanio getTamanio() {
        return this.tamanioMascota;
    }

}
