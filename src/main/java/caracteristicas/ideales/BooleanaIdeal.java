package caracteristicas.ideales;

import caracteristicas.definidas.BooleanaDefinida;
import caracteristicas.TipoCaracteristica;
import excepciones.ValorCaracteristicaInvalidoException;

public class BooleanaIdeal implements TipoCaracteristica {

    public BooleanaDefinida crearCaracteristica(String nombre, Object valor){
        boolean _valor;
        try{
            _valor = (boolean)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("de tipo Boolean");
        }
        return new BooleanaDefinida(nombre, _valor);
    }
}
