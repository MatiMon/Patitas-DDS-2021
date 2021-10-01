package usuario;

import javax.persistence.*;

@Entity(name = "validaciones")
@Table(name = "validaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class ValidacionDeContrasenia extends Persistence {
  @Id @GeneratedValue
  private Long id;

  abstract boolean esContraseniaValida(String password);
  abstract public String getIdentificador();

}
