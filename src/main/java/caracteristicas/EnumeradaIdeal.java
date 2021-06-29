package caracteristicas;

import excepciones.ValorCaracteristicaInvalidoException;

import java.util.List;
import java.util.Objects;

public class EnumeradaIdeal implements TipoCaracteristica{
    List<String> opciones;

    public EnumeradaIdeal(List<String> opciones) {
        this.opciones = Objects.requireNonNull(opciones, "Debe ingresar una lista de opciones posibles");
    }

    public EnumeradaDefinida crearCaracteristica(String nombre, Object valor){
        String _valor;
        try{
            _valor = (String)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("de tipo String");
        }
        validarCaracteristica(_valor);
        return new EnumeradaDefinida(nombre, _valor);
    }

    private void validarCaracteristica(String valor){
        if(!opciones.contains(valor)){
            throw new ValorCaracteristicaInvalidoException("parte de las opciones.");
        }
    }
}
