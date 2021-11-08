package caracteristicas;

import caracteristicas.definidas.CaracteristicaDefinida;

import javax.persistence.*;

@Entity(name = "TiposCaraacteritica")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class TipoCaracteristica {
    @Id
    @GeneratedValue
    private Long id;
    public abstract CaracteristicaDefinida crearCaracteristica(String nombre, Object valor);
}
