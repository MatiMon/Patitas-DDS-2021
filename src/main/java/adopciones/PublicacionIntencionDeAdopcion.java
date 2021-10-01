package adopciones;

import caracteristicas.definidas.CaracteristicaDefinida;
import duenio.Duenio;
import mascota.Sexo;
import mascota.Tamanio;
import mascota.TipoAnimal;

import javax.persistence.*;
import java.util.List;

@Entity(name = "PublicacionesIntencionDeAdopcion")
public class PublicacionIntencionDeAdopcion {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    @JoinColumn(name = "publicacionIntencionDeAdopcionComodidad_Id", referencedColumnName = "id")
    private List<CaracteristicaDefinida> comodidades;
    @OneToMany
    @JoinColumn(name = "publicacionIntencionDeAdopcionCaracteristica_Id", referencedColumnName = "id")
    private List<CaracteristicaDefinida> caracteristicasMascota;

    @ManyToOne
    @JoinColumn(name = "DuenioId", referencedColumnName = "id")
    private Duenio posibleDuenio;
    @Enumerated(EnumType.ORDINAL)
    private TipoAnimal tipoAnimal;
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexoMascota;
    @Enumerated(EnumType.ORDINAL)
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

    public void recomendarMascotas(String mensajeDeNotificacion) {
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
        return caracteristicas.stream().
            filter(unaCaracteristica -> unaCaracteristica.getNombre().equals(nombreCaracteristica)).findAny().orElse(null);
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
