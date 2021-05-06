package caracteristicas;

import java.util.ArrayList;
import java.util.List;

public class CaracteristicaIdeal{
    String nombre;
    Boolean esObligatoria;
    TipoCaracteristica tipo;
    List<String> opciones = new ArrayList<>();

    public CaracteristicaIdeal(String nombre, Boolean esObligatoria, TipoCaracteristica tipo) {
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

    public CaracteristicaSensible crearCaracteristica(){
        return tipo.crearCaracteristica(nombre);
    }
}

//new CaracteristicaIdeal("esta castrada", true, Booleana)