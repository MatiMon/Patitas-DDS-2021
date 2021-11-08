package model.rescate;

import model.contacto.Contacto;
import model.duenio.TipoDocumento;
import model.excepciones.RescatistaInvalidoException;
import org.uqbarproject.jpa.java8.extras.convert.LocalDateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Rescatista")
@Table(name = "Rescatista")
public class Rescatista {
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String nombre;

  @Column
  private String apellido;

  @Column(name = "fecha_nacimiento")
  @Convert(converter = LocalDateConverter.class)
  private LocalDate fechaNacimiento;

  @Column(name = "tipo_documento")
  @Enumerated(EnumType.ORDINAL)
  private TipoDocumento tipoDocumento;

  @Column
  private String direccion;

  @OneToOne
  private Contacto contactoPrincipal;

  @OneToMany
  @JoinColumn(name = "rescatistaId")
  private List<Contacto> contactosSecundarios = new ArrayList<>();

  public Rescatista(String nombre, String apellido, LocalDate fechaNacimiento, TipoDocumento tipoDocumento, String direccion, Contacto contactoPrincipal) {
    if(contactoPrincipal == null){
      throw new RescatistaInvalidoException("debe tener al menos un model.contacto");
    }
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.direccion = direccion;
    this.contactoPrincipal = contactoPrincipal;
  }

  public void agregarContactoSecundario(Contacto contacto){
    this.contactosSecundarios.add(contacto);
  }

  public void notificarEncuentro(String mensaje) {
    this.contactoPrincipal.notificar(mensaje);
  }

  public String obtenerTarjetaDePresentacion() {
    return ("Nombre completo: " + this.nombre + " " + this.apellido + " - Contacto: " + this.contactoPrincipal.obtenerDatoDeContactoPreferido());
  }

  public Long getId() {
    return id;
  }
}
