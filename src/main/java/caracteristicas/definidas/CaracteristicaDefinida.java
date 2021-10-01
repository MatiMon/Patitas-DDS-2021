package caracteristicas.definidas;



import javax.persistence.*;

@Entity(name = "CaracteristicasDefinidas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class CaracteristicaDefinida {
    @Id @GeneratedValue
    private Long id;
    String nombre;

    public String getNombre() {
        return nombre;
    }
    public Boolean esCompatibleCon(CaracteristicaDefinida comodidad){
        return comodidad == null || compatibilidad(comodidad);
    }

    public abstract boolean compatibilidad(CaracteristicaDefinida comodidad);
}
