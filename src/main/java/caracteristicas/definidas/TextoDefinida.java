package caracteristicas.definidas;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Text")
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
