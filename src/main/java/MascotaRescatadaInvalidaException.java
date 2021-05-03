public class MascotaRescatadaInvalidaException extends RuntimeException {
  public MascotaRescatadaInvalidaException(String s) {
    super("No se puede ingresar la mascota rescatada porque " + s);
  }
}
