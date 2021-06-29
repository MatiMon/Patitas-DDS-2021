package caracteristicas;

import java.util.function.Predicate;

public abstract class CaracteristicaDefinida {
    String nombre;

    public String getNombre() {
        return nombre;
    }
    public abstract Boolean esCompatibleCon(CaracteristicaDefinida comodidad);

}
