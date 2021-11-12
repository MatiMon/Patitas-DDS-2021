package model.caracteristicas;

import model.caracteristicas.definidas.CaracteristicaDefinida;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity(name = "TiposCaraacteritica")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class TipoCaracteristica {
    @Id
    @GeneratedValue
    private Long id;

    public TipoCaracteristica() {
    }

    public abstract CaracteristicaDefinida crearCaracteristica(String nombre, Object valor);
    public abstract String getNombre();

    public String getOpciones() {
        return " - ";
    }

    public List<String> getRespuestas(){
        return null;
    }
}
