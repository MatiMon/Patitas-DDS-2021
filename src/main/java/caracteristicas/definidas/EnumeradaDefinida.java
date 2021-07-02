package caracteristicas.definidas;

public class EnumeradaDefinida extends CaracteristicaDefinida{
  String valor;

  public EnumeradaDefinida(String nombre, String valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }

  @Override
  public boolean compatibilidad(CaracteristicaDefinida comodidad) {
    EnumeradaDefinida comodidadTextoLibre = (EnumeradaDefinida) comodidad;
    return comodidadTextoLibre.valor.equals(valor);
  }
}
