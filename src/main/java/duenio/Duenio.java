package duenio;

import asociacion.Asociacion;
import asociacion.RepositorioAsociaciones;
import contacto.Contacto;
import ubicacion.Ubicacion;
import usuario.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
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
    if (!contactosSecundarios.isEmpty())
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
}
