package model.contacto;

import javax.persistence.*;

@Entity(name = "Contactos")

public class Contacto {
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String nombre;

  @Column
  private String apellido;

  @Column
  private String telefono;

  @Column
  private String email;

  @Transient //TODO OneToOne? ver
  private MedioDeNotificacion medioDeNotificacionPreferido;

  public Contacto(String nombre, String apellido, String telefono, String email) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.email = email;
  }

  public void notificar(String mensaje) { //TODO tests w/mocks
    this.medioDeNotificacionPreferido.enviarNotificacion(this, mensaje);
  }

  public String obtenerDatoDeContactoPreferido() {
    return this.medioDeNotificacionPreferido.obtenerDatoDeContacto();
  }

  /* setter */
  public void setMedioDeNotificacionPreferido(MedioDeNotificacion medioDeNotificacionPreferido) {
    this.medioDeNotificacionPreferido = medioDeNotificacionPreferido;
  }

  public Long getId() {
    return id;
  }

  public Contacto() {
  }
}
