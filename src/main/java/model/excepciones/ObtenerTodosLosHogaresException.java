package model.excepciones;

public class ObtenerTodosLosHogaresException extends RuntimeException {
  public ObtenerTodosLosHogaresException(String s) {
    super("No se pudieron obtener todos los model.hogares porque " + s);
  }
}
