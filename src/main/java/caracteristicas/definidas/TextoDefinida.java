package caracteristicas.definidas;

public class TextoDefinida extends CaracteristicaDefinida {
  String valor;

  public TextoDefinida(String nombre, String valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }

  @Override
  public boolean compatibilidad(CaracteristicaDefinida comodidad) {
    return true;
  }
}
