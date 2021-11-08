package model.caracteristicas.ideales;

import model.caracteristicas.definidas.EnumeradaDefinida;
import model.caracteristicas.TipoCaracteristica;
import model.excepciones.ValorCaracteristicaInvalidoException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("Enum")
public class EnumeradaIdeal extends TipoCaracteristica {

    @ElementCollection
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
