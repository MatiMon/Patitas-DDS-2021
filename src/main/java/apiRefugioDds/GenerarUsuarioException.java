package apiRefugioDds;

public class GenerarUsuarioException extends RuntimeException {
  public GenerarUsuarioException(String s) {
    super("No se pudo generar el usuario porque " + s);
  }
}
