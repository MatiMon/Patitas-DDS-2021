package duenio;

import java.time.LocalDate;
import java.util.List;

public class Duenio {
  String nombre;
  String apellido;
  LocalDate fechaNacimiento;
  TipoDocumento tipoDocumento;
  double documento;
  List<Contacto> contactos;


  public Duenio(String nombre, String apodo, LocalDate fechaNacimiento, TipoDocumento tipoDocumento, double Documento, List<Contacto> contactos) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.contactos = contactos;
    this.documento = documento;
  }
}
