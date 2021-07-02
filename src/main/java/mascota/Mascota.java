package mascota;

import asociacion.Asociacion;
import asociacion.RepositorioAsociaciones;
import caracteristicas.CaracteristicaDefinida;
import caracteristicas.ComodidadIdeal;
import duenio.Duenio;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
  private String id;

  public Mascota(String nombre, String apodo, int edad, Sexo sexo, TipoAnimal tipoAnimal, String descripcionFisica,
                 List<String> fotos, List<CaracteristicaDefinida> caracteristicaDefinidas, Duenio duenio, String id, Tamanio tamanio) {
    this.nombre = nombre;
    this.apodo = apodo;
    this.edad = edad;
    this.sexo = sexo;
    this.tipoAnimal = tipoAnimal;
    this.descripcionFisica = descripcionFisica;
    this.fotos = fotos;
    this.caracteristicaDefinidas = caracteristicaDefinidas;
    this.duenio = duenio;
    this.id = id;
    this.tamanio = tamanio;
  }

  public void notificarAlDuenio(String mensaje) {
    this.duenio.notificar(mensaje);
  }

  public String getNombre() {
    return nombre;
  }

  public List<CaracteristicaDefinida> getCaracteristicaDefinidas() {
    return caracteristicaDefinidas;
  }

  public boolean caracteristicasCompatiblesCon(PublicacionIntencionDeAdopcion intencionDeAdopcion) {
    TipoAnimal tipoAnimalRequerido = intencionDeAdopcion.getTipoAnimal();
    Sexo sexoRequerido = intencionDeAdopcion.getSexo();
    Tamanio tamanioRequerido = intencionDeAdopcion.getTamanio();
    return (tipoAnimal.equals(tipoAnimalRequerido) || Objects.isNull(tipoAnimalRequerido))
        && (sexo.equals(sexoRequerido) || Objects.isNull(sexoRequerido))
        && (tamanio.equals(tamanioRequerido) || Objects.isNull(tamanioRequerido));
  }

  /* ESTE METODO ES POR SI QUEREMOS ELEGIR A MANO LA ASOCIACION, POR AHORA LO HACEMOS AUTOMATICO
  public void darEnAdopcion(List<CaracteristicaDefinida> comodidades, Asociacion asociacionDeseada){
    PublicacionMascotaEnAdopcion publicacion = new PublicacionMascotaEnAdopcion(comodidades,this);
    asociacionDeseada.agregarMascotaEnAdopcion(publicacion);
  }*/

  public void darEnAdopcionEnLaAsociacionMasCercana (List<CaracteristicaDefinida> comodidades){
    PublicacionMascotaEnAdopcion publicacion = new PublicacionMascotaEnAdopcion(comodidades,this);
    this.duenio.obtenerAsociacionMasCercana().agregarMascotaEnAdopcion(publicacion);
  }
}
