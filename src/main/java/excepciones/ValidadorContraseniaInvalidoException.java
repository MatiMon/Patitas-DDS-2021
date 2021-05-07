package excepciones;

public class ValidadorContraseniaInvalidoException extends RuntimeException {
  public ValidadorContraseniaInvalidoException(String s) {
    super("ValidadorContrasenia invalido porque "+ s);
  }
}
