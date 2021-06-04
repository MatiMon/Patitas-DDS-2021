package rescate;

import contacto.Contacto;
import duenio.TipoDocumento;
import excepciones.RescatistaInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rescatista {
  private String nombre;
  private String apellido;
  private LocalDate fechaNacimiento;
  private TipoDocumento tipoDocumento;
  private String direccion;
  private Contacto contactoPrincipal;
  private List<Contacto> contactosSecundarios = new ArrayList<>();

  public Rescatista(String nombre, String apellido, LocalDate fechaNacimiento, TipoDocumento tipoDocumento, String direccion, Contacto contactoPrincipal) {
    if(contactoPrincipal == null){
      throw new RescatistaInvalidoException("debe tener al menos un contacto");
    }
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.direccion = direccion;
    this.contactoPrincipal = contactoPrincipal;
  }

  public void agregarContacto(Contacto contacto){
    this.contactosSecundarios.add(contacto);
  }

  public void notificarEncuentro(String mensaje) {
    this.contactoPrincipal.notificar(mensaje);
  }

  public String obtenerTarjetaDePresentacion() {
    return ("Nombre completo: " + this.nombre + " " + this.apellido + " - Contacto: " + this.contactoPrincipal.obtenerDatoDeContactoPreferido());
  }
}
