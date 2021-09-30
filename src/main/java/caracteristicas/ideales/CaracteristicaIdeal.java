package caracteristicas.ideales;

import caracteristicas.definidas.CaracteristicaDefinida;
import caracteristicas.TipoCaracteristica;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CaracteristicaIdeal {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private Boolean esObligatoria;

    @ManyToOne
    @JoinColumn(name = "tipoCaracteristica_id", referencedColumnName = "id")
    private TipoCaracteristica tipo;

    public CaracteristicaIdeal(String nombre, Boolean esObligatoria, TipoCaracteristica tipo) {
        this.nombre = nombre;
        this.esObligatoria = esObligatoria;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean esObligatoria(){
        return esObligatoria;
    }

    public CaracteristicaDefinida crearCaracteristica(Object valor){
        return tipo.crearCaracteristica(nombre, valor);
    }
}