package apiRefugioDds.exceptions;

public class ObtenerTodosLosHogaresException extends RuntimeException {
  public ObtenerTodosLosHogaresException(String s) {
    super("No se pudieron obtener todos los hogares porque " + s);
  }
}
