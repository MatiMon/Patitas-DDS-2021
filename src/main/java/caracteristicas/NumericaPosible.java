package caracteristicas;

public class NumericaPosible implements TipoCaracteristica{
    public NumericoDefinida crearCaracteristica(String nombre, Object valor){
        return new NumericoDefinida(nombre, (int)valor);
    }
}
