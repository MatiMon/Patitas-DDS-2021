package asociacion;

import usuario.Usuario;

import javax.persistence.*;

@Entity
public class Voluntario {
  @Id
  @GeneratedValue
  private Long id;
  @Transient
  Usuario usuario;
  @ManyToOne
  @JoinColumn(name = "Asociacion_id", referencedColumnName = "id")
  Asociacion asociacion;
}
