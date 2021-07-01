package mascota;

import caracteristicas.CaracteristicaDefinida;
import duenio.Duenio;
import excepciones.CaracteristicaInexistenteException;

import java.util.List;

public class PublicacionIntencionDeAdopcion {
    private List<CaracteristicaDefinida> comodidades;
    private List<CaracteristicaDefinida> caracteristicasMascota;
    private Duenio posibleDuenio;
    private TipoAnimal tipoAnimal;
    private Sexo sexoMascota;
    private Tamanio tamanioMascota;
    private String linkDeBaja;

    public PublicacionIntencionDeAdopcion(List<CaracteristicaDefinida> comodidades,
                                          List<CaracteristicaDefinida> caracteristicasMascota,
                                          Duenio posibleDuenio, TipoAnimal tipoAnimal, Sexo sexoMascota,
                                          Tamanio tamanioMascota, String linkDeBaja) {
        this.comodidades = comodidades;
        this.caracteristicasMascota = caracteristicasMascota;
        this.posibleDuenio = posibleDuenio;
        this.tipoAnimal = tipoAnimal;
        this.sexoMascota = sexoMascota;
        this.tamanioMascota = tamanioMascota;
        this.linkDeBaja = linkDeBaja;
    }

    public void recomendarMascotas(List<PublicacionMascotaEnAdopcion> mascotasRecomendadas) { //TODO el mensaje se deberia armar aca
        String mensajeDeNotificacion = "";
        this.notificarAlPosibleDuenio(mensajeDeNotificacion);
    }

    public void enviarLinkDeBaja() {
        this.notificarAlPosibleDuenio("Se ha creado tu publicación, podés darla de baja con el siguiente link: " + this.linkDeBaja);
    }

    private void notificarAlPosibleDuenio(String mensaje) {
        this.posibleDuenio.notificar(mensaje);
    }

    public CaracteristicaDefinida valorCaracteristica(String nombreCaracteristica) {
        return obtenerCaracteristica(this.caracteristicasMascota, nombreCaracteristica);
    }

    public CaracteristicaDefinida valorComodidad(String nombreComodidad) {
        return obtenerCaracteristica(this.comodidades, nombreComodidad);
    }

    private CaracteristicaDefinida obtenerCaracteristica(List<CaracteristicaDefinida> caracteristicas, String nombreCaracteristica) {
        CaracteristicaDefinida caracteristica = caracteristicas.stream().
            filter(unaCaracteristica -> unaCaracteristica.getNombre().equals(nombreCaracteristica)).findAny().orElse(null);
        //TODO me parece que esto no va if (caracteristica == null) throw new CaracteristicaInexistenteException("las características/comodidades de esta publicación");
        return  caracteristica;
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
