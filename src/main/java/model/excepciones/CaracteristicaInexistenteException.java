package model.excepciones;

public class CaracteristicaInexistenteException  extends RuntimeException {
  public CaracteristicaInexistenteException(String mensaje) {
    super("Esta característica no existe entre " + mensaje);
  }
}
