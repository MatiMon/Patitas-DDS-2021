package model.asociacion;

import model.usuario.Usuario;

import javax.persistence.*;

@Entity(name = "Voluntarios")
public class Voluntario {
  @Id
  @GeneratedValue
  private Long id;
  @OneToOne
  @JoinColumn(name = "Usuario_Id")
  Usuario usuario;
  @ManyToOne
  @JoinColumn(name = "Asociacion_id")
  Asociacion asociacion;

  public Long getId() {
    return id;
  }

}
