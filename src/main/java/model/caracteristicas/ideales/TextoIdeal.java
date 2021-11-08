package model.caracteristicas.ideales;

import model.caracteristicas.definidas.TextoDefinida;
import model.caracteristicas.TipoCaracteristica;
import model.excepciones.ValorCaracteristicaInvalidoException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Text")
public class TextoIdeal extends TipoCaracteristica {
    public TextoDefinida crearCaracteristica(String nombre, Object valor){
        String _valor;
        try{
            _valor = (String)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("de tipo String");
        }
        return new TextoDefinida(nombre, _valor);
    }
}
