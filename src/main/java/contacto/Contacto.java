package contacto;

public class Contacto {
  private String nombre;
  private String apellido;

  private int telefono;
  private String email;
  private MedioDeNotificacion medioDeNotificacionPreferido;

  public Contacto(String nombre, String apellido, int telefono, String email) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.email = email;
  }

  public void notificar(String mensaje) {
    this.medioDeNotificacionPreferido.enviarNotificacion(this, mensaje);
  }

  public String obtenerDatoDeContactoPreferido() {
    return this.medioDeNotificacionPreferido.obtenerDatoDeContacto();
  }

  public int getTelefono() {
    return telefono;
  }

  public String getEmail() {
    return email;
  }
}
