package caracteristicas;

import java.util.ArrayList;
import java.util.List;

public class CaracteristicaPosible {
    String nombre;
    Boolean esObligatoria;
    TipoCaracteristica tipo;
    List<String> opciones = new ArrayList<>();

    public CaracteristicaPosible(String nombre, Boolean esObligatoria, TipoCaracteristica tipo) {
        this.nombre = nombre;
        this.esObligatoria = esObligatoria;
        this.tipo = tipo;
    }

    public void agregarOpcion(String opcion){
        opciones.add(opcion);
    }

    public String getNombre() {
        return nombre;
    }

    public CaracteristicaDefinida crearCaracteristica(Object valor){
        return tipo.crearCaracteristica(nombre, valor);
    }
}

//new CaracteristicaIdeal("esta castrada", true, Booleana)