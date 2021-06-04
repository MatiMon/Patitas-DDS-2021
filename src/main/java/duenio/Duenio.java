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
  private List<Contacto> contactos;
  private Usuario usuario;


  public Duenio(String nombre, String apellido, LocalDate fechaNacimiento, TipoDocumento tipoDocumento, double documento, List<Contacto> contactos) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.contactos = contactos;
    this.documento = documento;
  }
}
