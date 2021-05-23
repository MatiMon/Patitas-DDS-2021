package mascota;

import caracteristicas.CaracteristicaDefinida;
import duenio.Duenio;


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
  List<CaracteristicaDefinida> caracteristicaSensibles = new ArrayList<>();
  Duenio duenio;

  public Mascota(String nombre, String apodo, int edad, Sexo sexo, TipoAnimal tipoAnimal, String descripcionFisica, List<String> fotos, List<CaracteristicaDefinida> caracteristicaSensibles, Duenio duenio) {
    this.nombre = nombre;
    this.apodo = apodo;
    this.edad = edad;
    this.sexo = sexo;
    this.tipoAnimal = tipoAnimal;
    this.descripcionFisica = descripcionFisica;
    this.fotos = fotos;
    this.caracteristicaSensibles = caracteristicaSensibles;
    this.duenio = duenio;
  }
}
