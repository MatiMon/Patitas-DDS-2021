package caracteristicas;

import java.util.ArrayList;
import java.util.List;

public class CaracteristicaPosible {
    String nombre;
    Boolean esObligatoria;
    TipoCaracteristica tipo;

    public CaracteristicaPosible(String nombre, Boolean esObligatoria, TipoCaracteristica tipo) {
        this.nombre = nombre;
        this.esObligatoria = esObligatoria;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public CaracteristicaDefinida crearCaracteristica(Object valor){
        return tipo.crearCaracteristica(nombre, valor);
    }
}

//new CaracteristicaIdeal("esta castrada", true, Booleana)