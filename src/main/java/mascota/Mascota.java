package mascota;

import caracteristicas.Caracteristica;
import duenio.Duenio;


import java.util.ArrayList;
import java.util.List;

public class Mascota {
  private String nombre;
  private String apodo;
  private int edad;
  private Sexo sexo;
  private TipoAnimal tipoAnimal;
  private String descripcionFisica;
  private List<String> fotos = new ArrayList<>();
  private List<Caracteristica> caracteristicas = new ArrayList<>();
  private Duenio duenio;

  public Mascota(String nombre, String apodo, int edad, Sexo sexo, TipoAnimal tipoAnimal, String descripcionFisica, List<String> fotos, List<Caracteristica> caracteristicas, Duenio duenio) {
    this.nombre = nombre;
    this.apodo = apodo;
    this.edad = edad;
    this.sexo = sexo;
    this.tipoAnimal = tipoAnimal;
    this.descripcionFisica = descripcionFisica;
    this.fotos = fotos;
    this.caracteristicas = caracteristicas;
    this.duenio = duenio;
  }
}
