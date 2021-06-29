package caracteristicas;

public class NumericoDefinida extends CaracteristicaDefinida {
  int valor;

  public NumericoDefinida(String nombre, int valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  @Override
  public Boolean esCompatibleCon(CaracteristicaDefinida comodidad) {
    NumericoDefinida comodidadNumerica = (NumericoDefinida) comodidad;
    return comodidadNumerica.valor == valor;
  }
}
