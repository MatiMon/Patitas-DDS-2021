package mascota;

import caracteristicas.CaracteristicaDefinida;
import duenio.Duenio;

import java.util.List;

public class PublicacionIntencionDeAdopcion {
    List<CaracteristicaDefinida> comodidades;
    List<CaracteristicaDefinida> caracteristicasMascota;
    Duenio posibleDuenio;
    TipoAnimal tipoAnimal;
    Sexo sexo;
    Tamanio tamanio;

    public PublicacionIntencionDeAdopcion() {
        //TODO definir parametros del constructor, luego habra que agregarlos al TestAsociaciones
    }

    public void darDeBaja() {
        //TODO
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
        return tipoAnimal;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Tamanio getTamanio() {
        return tamanio;
    }
}
