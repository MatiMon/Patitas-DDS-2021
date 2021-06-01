package excepciones;

public class ValorCaracteristicaInvalidoException extends RuntimeException{

  public ValorCaracteristicaInvalidoException(String msg) {
    super("El valor de la caracteristica debe ser de tipo " + msg);
  }
}
