package model.caracteristicas.ideales;

import model.caracteristicas.definidas.NumericoDefinida;
import model.caracteristicas.TipoCaracteristica;
import model.excepciones.ValorCaracteristicaInvalidoException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Num")
public class NumericaIdeal extends TipoCaracteristica {

    private String nombre = "Numerica";

    public NumericoDefinida crearCaracteristica(String nombre, Object valor){
        int _valor;
        try{
            _valor = (int)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("de tipo Int");
        }
        return new NumericoDefinida(nombre, _valor);
    }

    public String getNombre() {
        return nombre;
    }
}
