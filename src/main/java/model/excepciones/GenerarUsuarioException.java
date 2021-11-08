package model.excepciones;

public class GenerarUsuarioException extends RuntimeException {
  public GenerarUsuarioException(String s) {
    super("No se pudo generar el model.usuario porque " + s);
  }
}
