package caracteristicas;

import excepciones.ValorCaracteristicaInvalidoException;

public class TextoIdeal implements TipoCaracteristica{
    public TextoDefinida crearCaracteristica(String nombre, Object valor){
        String _valor;
        try{
            _valor = (String)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("String");
        }
        return new TextoDefinida(nombre, _valor);
    }
}
