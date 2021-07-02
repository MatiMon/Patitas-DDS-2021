package caracteristicas;

import caracteristicas.definidas.CaracteristicaDefinida;

public interface TipoCaracteristica {
    CaracteristicaDefinida crearCaracteristica(String nombre, Object valor);
}
