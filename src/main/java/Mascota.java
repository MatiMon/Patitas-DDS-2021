import java.util.ArrayList;
import java.util.List;

public class Mascota {
  String nombre;
  String apodo;
  int edad;
  Sexo sexo;
  TipoAnimal tipoAnimal;
  String descripcionFisica;
  List<String> fotos = new ArrayList<>();
  List<Caracteristica> caracteristicas = new ArrayList<>();
  Dueño dueño;

  public Mascota(String nombre, String apodo, int edad, Sexo sexo, TipoAnimal tipoAnimal, String descripcionFisica, List<String> fotos, List<Caracteristica> caracteristicas, Dueño dueño) {
    this.nombre = nombre;
    this.apodo = apodo;
    this.edad = edad;
    this.sexo = sexo;
    this.tipoAnimal = tipoAnimal;
    this.descripcionFisica = descripcionFisica;
    this.fotos = fotos;
    this.caracteristicas = caracteristicas;
    this.dueño = dueño;
  }
}
