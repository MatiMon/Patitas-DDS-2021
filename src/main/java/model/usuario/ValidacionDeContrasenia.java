package model.usuario;

import javax.persistence.*;

@Entity(name = "Validaciones")
@Table(name = "Validaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class ValidacionDeContrasenia extends Persistence {
  @Id @GeneratedValue
  private Long id;

  abstract boolean esContraseniaValida(String password);
  abstract public String getIdentificador();

}
