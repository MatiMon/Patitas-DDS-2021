package caracteristicas.definidas;

public class BooleanaDefinida extends CaracteristicaDefinida {
  boolean valor;

  public BooleanaDefinida(String nombre, Boolean valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  @Override
  public boolean compatibilidad(CaracteristicaDefinida comodidad) {
    BooleanaDefinida comodidadBooleana = (BooleanaDefinida) comodidad;
    return  !valor || (valor && comodidadBooleana.valor);
  }
}
