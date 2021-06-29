package caracteristicas;

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
  public Boolean esCompatibleCon(CaracteristicaDefinida comodidad) {
    EnumeradaDefinida comodidadTextoLibre = (EnumeradaDefinida) comodidad;
    return comodidadTextoLibre.valor.equals(valor);
  }
}
