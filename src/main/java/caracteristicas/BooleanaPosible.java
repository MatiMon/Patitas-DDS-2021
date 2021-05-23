package caracteristicas;

public class BooleanaPosible implements TipoCaracteristica{

    public BooleanaDefinida crearCaracteristica(String nombre, Object valor){
        return new BooleanaDefinida(nombre, (Boolean) valor);
    }
}
