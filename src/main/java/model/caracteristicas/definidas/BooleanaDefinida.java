package model.caracteristicas.definidas;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bool")
public class BooleanaDefinida extends CaracteristicaDefinida {
  boolean valor;

  public BooleanaDefinida(String nombre, Boolean valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  public BooleanaDefinida() {
  }

  @Override
  public boolean compatibilidad(CaracteristicaDefinida comodidad) {
    BooleanaDefinida comodidadBooleana = (BooleanaDefinida) comodidad;
    return  !valor || (valor && comodidadBooleana.valor);
  }
}
