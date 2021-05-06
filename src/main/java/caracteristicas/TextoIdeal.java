package caracteristicas;

public class TextoIdeal implements TipoCaracteristica{
    public TextoSensible crearCaracteristica(String nombre){
        return new TextoSensible(nombre);
    }
}
