package duenio;

import asociacion.Asociacion;
import asociacion.RepositorioAsociaciones;
import contacto.Contacto;
import ubicacion.Ubicacion;
import usuario.Usuario;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "duenio")
public class Duenio {
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private String nombre;

  @Column
  private String apellido;

  @Column(name = "fecha_nacimiento")
  private LocalDate fechaNacimiento;

  @Column(name = "tipo_documento")
  @Enumerated(EnumType.ORDINAL)
  private TipoDocumento tipoDocumento;

  @Column
  private double documento;

  @OneToOne
  private Contacto contactoPrincipal;

  @OneToMany
  @JoinColumn(name = "duenioId", referencedColumnName = "id")
  private List<Contacto> contactosSecundarios;

  @Transient //TODO @OneToOne
  private Usuario usuario;

  @Transient
  private Ubicacion ubicacion;

  public Duenio(String nombre, String apellido, LocalDate fechaNacimiento, TipoDocumento tipoDocumento, double documento, Contacto contactoPrincipal, Ubicacion ubicacion) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.contactoPrincipal = contactoPrincipal;
    this.documento = documento;
    this.ubicacion = ubicacion;
  }

  public void notificar(String mensaje) {
    contactoPrincipal.notificar(mensaje);
    if (contactosSecundarios != null)
      this.contactosSecundarios.forEach(contacto -> contacto.notificar(mensaje));
  }

  public void agregarContactoSecundario(Contacto contacto){
    if (contactosSecundarios == null) {
      this.contactosSecundarios = new ArrayList<>();
    }
    this.contactosSecundarios.add(contacto);
  }

  public Asociacion obtenerAsociacionMasCercana(){
   return RepositorioAsociaciones.getInstancia().asociacionMasCercana(ubicacion);
  }

  public String obtenerTarjetaDePresentacion() {
    return ("Nombre completo: " + this.nombre + " " + this.apellido + " - Contacto: " + this.contactoPrincipal.obtenerDatoDeContactoPreferido());
  }

  public Long getId() {
    return id;
  }

}
