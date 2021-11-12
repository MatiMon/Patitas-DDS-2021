package model.caracteristicas.ideales;

import model.caracteristicas.definidas.BooleanaDefinida;
import model.caracteristicas.TipoCaracteristica;
import model.excepciones.ValorCaracteristicaInvalidoException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bool")
public class BooleanaIdeal extends TipoCaracteristica {

    private String nombre = "De respuesta si o no";

    public BooleanaDefinida crearCaracteristica(String nombre, Object valor){
        boolean _valor;
        try{
            _valor = (boolean)valor;
        }catch (ClassCastException e) {
            throw new ValorCaracteristicaInvalidoException("de tipo Boolean");
        }
        return new BooleanaDefinida(nombre, _valor);
    }

    public String getNombre() {
        return nombre;
    }
}
