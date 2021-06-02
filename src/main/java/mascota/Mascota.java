package mascota;

import caracteristicas.CaracteristicaDefinida;
import duenio.Duenio;


import java.util.ArrayList;
import java.util.List;

public class Mascota {
  private String nombre;
  private String apodo;
  private int edad;
  private Sexo sexo;
  private TipoAnimal tipoAnimal;
  private Tamanio tamanio;
  private String descripcionFisica;
  private List<String> fotos = new ArrayList<>();
  private List<CaracteristicaDefinida> caracteristicaDefinidas = new ArrayList<>();
  private Duenio duenio;
  private String QR;

  public Mascota(String nombre, String apodo, int edad, Sexo sexo, TipoAnimal tipoAnimal, String descripcionFisica,
                 List<String> fotos, List<CaracteristicaDefinida> caracteristicaDefinidas, Duenio duenio, String QR, Tamanio tamanio) {
    this.nombre = nombre;
    this.apodo = apodo;
    this.edad = edad;
    this.sexo = sexo;
    this.tipoAnimal = tipoAnimal;
    this.descripcionFisica = descripcionFisica;
    this.fotos = fotos;
    this.caracteristicaDefinidas = caracteristicaDefinidas;
    this.duenio = duenio;
    this.QR = QR;
    this.tamanio = tamanio;
  }

}
