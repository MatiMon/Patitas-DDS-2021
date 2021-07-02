package caracteristicas.ideales;

import caracteristicas.definidas.NumericoDefinida;
import caracteristicas.TipoCaracteristica;
import excepciones.ValorCaracteristicaInvalidoException;

public class NumericaIdeal implements TipoCaracteristica {
    public NumericoDefinida crearCaracteristica(String nombre, Object valor){
        int _valor;
        try{
            _valor = (int)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("de tipo Int");
        }
        return new NumericoDefinida(nombre, _valor);
    }
}
