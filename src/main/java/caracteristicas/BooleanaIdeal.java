package caracteristicas;

public class BooleanaIdeal implements TipoCaracteristica{

    public BooleanaSensible crearCaracteristica(String nombre){
        return new BooleanaSensible(nombre);
    }
}
