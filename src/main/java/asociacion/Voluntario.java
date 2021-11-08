package asociacion;

import usuario.Usuario;

import javax.persistence.*;

@Entity(name = "Voluntarios")
public class Voluntario {
  @Id
  @GeneratedValue
  private Long id;
  @OneToOne
  @JoinColumn(name = "Usuario_Id", referencedColumnName = "id")
  Usuario usuario;
  @ManyToOne
  @JoinColumn(name = "Asociacion_id", referencedColumnName = "id")
  Asociacion asociacion;

  public Long getId() {
    return id;
  }

}
