package caracteristicas;

import excepciones.ValorCaracteristicaInvalidoException;

import java.util.List;
import java.util.Objects;

public class EnumeradaIdeal implements TipoCaracteristica{
    List<String> opciones;

    public EnumeradaIdeal(List<String> opciones) {
        this.opciones = Objects.requireNonNull(opciones, "Debe ingresar una lista de opciones posibles");
    }

    public TextoDefinida crearCaracteristica(String nombre, Object valor){
        String _valor;
        try{
            _valor = (String)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("String");
        }
        //TODO validarCaracteristica(_valor);
        return new TextoDefinida(nombre, _valor);
    }
    public List<String> getOpciones() {
        return opciones;
    }
}
