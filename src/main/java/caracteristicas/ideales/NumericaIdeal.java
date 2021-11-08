package caracteristicas.ideales;

import caracteristicas.definidas.NumericoDefinida;
import caracteristicas.TipoCaracteristica;
import excepciones.ValorCaracteristicaInvalidoException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Num")
public class NumericaIdeal extends TipoCaracteristica {
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
