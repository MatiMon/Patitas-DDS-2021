package caracteristicas;

public class BooleanaDefinida extends CaracteristicaDefinida {
  boolean valor;

  public BooleanaDefinida(String nombre, Boolean valor) {
    this.nombre = nombre;
    this.valor = valor;
  }
}
