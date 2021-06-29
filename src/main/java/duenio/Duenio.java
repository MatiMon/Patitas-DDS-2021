package duenio;

import contacto.Contacto;
import usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

public class Duenio {
  private String nombre;
  private String apellido;
  private LocalDate fechaNacimiento;
  private TipoDocumento tipoDocumento;
  private double documento;
  private Contacto contactoPrincipal;
  private List<Contacto> contactosSecundarios;
  private Usuario usuario;

  public Duenio(String nombre, String apellido, LocalDate fechaNacimiento, TipoDocumento tipoDocumento, double documento, Contacto contactoPrincipal) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.contactoPrincipal = contactoPrincipal;
    this.documento = documento;
  }

  public void notificarEncuentro(String mensaje) {
    this.contactosSecundarios.forEach(contacto -> contacto.notificar(mensaje));
  }

  public void agregarContactoSecundario(Contacto contacto){
    this.contactosSecundarios.add(contacto);
  }
}
