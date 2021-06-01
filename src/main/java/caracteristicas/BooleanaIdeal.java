package caracteristicas;

import excepciones.ValorCaracteristicaInvalidoException;

public class BooleanaIdeal implements TipoCaracteristica{

    public BooleanaDefinida crearCaracteristica(String nombre, Object valor){
        boolean _valor;
        try{
            _valor = (boolean)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("Boolean");
        }
        return new BooleanaDefinida(nombre, _valor);
    }
}
