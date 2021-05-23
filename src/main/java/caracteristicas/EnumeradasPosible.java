package caracteristicas;

import java.util.List;
import java.util.Objects;

public class EnumeradasPosible implements TipoCaracteristica{
    List<String> opciones;

    public EnumeradasPosible(List<String> opciones) {
        this.opciones = Objects.requireNonNull(opciones, "Debe ingresar una lista de opciones posibles");
    }

    public TextoDefinida crearCaracteristica(String nombre, Object valor){
        validarCaracteristica((String) valor);
        return new TextoDefinida(nombre, (String) valor);
    }

    private void validarCaracteristica(String valor){
       if(!opciones.contains(valor)){
           //TODO crear excepcion
       }
    }

    public List<String> getOpciones() {
        return opciones;
    }
}
