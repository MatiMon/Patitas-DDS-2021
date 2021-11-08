package model.excepciones;

public class MascotaRescatadaInvalidaException extends RuntimeException {
  public MascotaRescatadaInvalidaException(String s) {
    super("No se puede ingresar la model.mascota rescatada porque " + s);
  }
}
