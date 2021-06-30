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



    public void recomendarMascotas(List<PublicacionMascotaEnAdopcion> posiblesMascotas) {
        //TODO
    }
    public CaracteristicaDefinida valorCaracteristica(String nombreCaracteristica) {
        //TODO
        return null;
    }
    public CaracteristicaDefinida valorComodidad(String nombreComodidad) {
        //TODO
        return null;
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
