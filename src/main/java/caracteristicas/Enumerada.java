package caracteristicas;

import java.util.ArrayList;
import java.util.List;

public class Enumerada extends Caracteristica{
  private List<String> opciones = new ArrayList<>();

  public Enumerada(String nombre, List<String> opciones) {
    this.nombre = nombre;
    this.opciones = opciones;
  }
}
