package caracteristicas.definidas;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@DiscriminatorValue("Num")
public class NumericoDefinida extends CaracteristicaDefinida {
  int valor;

  public NumericoDefinida(String nombre, int valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  @Override
  public boolean compatibilidad(CaracteristicaDefinida comodidad) {
    NumericoDefinida comodidadNumerica = (NumericoDefinida) comodidad;
    return comodidadNumerica.valor == valor;
  }
}
