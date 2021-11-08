package model.excepciones;

public class AsociacionNoEncontradaException extends RuntimeException  {
  public AsociacionNoEncontradaException (String mensaje){
    super(mensaje);
  }
}
