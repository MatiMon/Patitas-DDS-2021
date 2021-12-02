package model.caracteristicas.ideales;

import model.caracteristicas.definidas.CaracteristicaDefinida;
import model.caracteristicas.TipoCaracteristica;

import javax.persistence.*;
import java.util.List;

@Entity (name = "CaracteristicasIdeales")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CaracteristicaIdeal {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    private String nombre;
    private Boolean esObligatoria;


    @ManyToOne
    @JoinColumn(name = "tipoCaracteristica_id")
    private TipoCaracteristica tipo;

    public CaracteristicaIdeal(String nombre, Boolean esObligatoria, TipoCaracteristica tipo) {
        this.nombre = nombre;
        this.esObligatoria = esObligatoria;
        this.tipo = tipo;
    }

    public CaracteristicaIdeal() {

    }

    public String getTipo(){ return tipo.getNombre();}

    public String getNombre() {
        return nombre;
    }

    public Boolean esObligatoria(){
        return esObligatoria;
    }

    public String getOpciones(){
        return tipo.getOpciones();
    }

    public List<String> getRespuestas(){
        return tipo.getRespuestas();
    }

    public CaracteristicaDefinida crearCaracteristica(Object valor){
        return tipo.crearCaracteristica(nombre, valor);
    }

    public Long getId() {
        return id;
    }
}