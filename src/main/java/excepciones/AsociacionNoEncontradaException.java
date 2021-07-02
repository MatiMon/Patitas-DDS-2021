package excepciones;

import java.util.function.Supplier;

public class AsociacionNoEncontradaException extends RuntimeException  {
  public AsociacionNoEncontradaException (String mensaje){
    super(mensaje);
  }
}
