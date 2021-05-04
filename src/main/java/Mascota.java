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
  List<Caracteristicas> caracteristicas = new ArrayList<>();
  Dueño dueño;
}
