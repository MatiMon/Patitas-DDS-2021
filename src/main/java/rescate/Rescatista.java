package rescate;

import contacto.Contacto;
import duenio.TipoDocumento;
import excepciones.RescatistaInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rescatista {
  private String nombre;
  private String apodo;
  private LocalDate fechaNacimiento;
  private TipoDocumento tipoDocumento;
  private String direccion;
  private List<Contacto> contactos = new ArrayList<>();

  public Rescatista(String nombre, String apodo, LocalDate fechaNacimiento, TipoDocumento tipoDocumento, String direccion, List<Contacto> contactos) {
    if(contactos.size()<1){
      throw new RescatistaInvalidoException("debe tener al menos un contacto");
    }
    this.nombre = nombre;
    this.apodo = apodo;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.direccion = direccion;
    this.contactos = contactos;
  }

  public void agregarContacto(Contacto contacto){
    this.contactos.add(contacto);
  }
}
