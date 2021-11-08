package model.excepciones;

public class RescatistaInvalidoException extends RuntimeException {
  public RescatistaInvalidoException(String s) {
    super("El rescatista es invalido porque " + s);
  }
}
