package caracteristicas;

public class NumericaIdeal implements TipoCaracteristica{
    public NumericoSensible crearCaracteristica(String nombre){
        return new NumericoSensible(nombre);
    }
}
