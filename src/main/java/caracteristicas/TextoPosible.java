package caracteristicas;

public class TextoPosible implements TipoCaracteristica{
    public TextoDefinida crearCaracteristica(String nombre, Object valor){
        return new TextoDefinida(nombre, (String) valor);
    }
}
