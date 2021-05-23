package mascota;

import caracteristicas.CaracteristicaPosible;
import caracteristicas.CaracteristicaDefinida;
import caracteristicas.RepositorioCaracteristicasPosibles;
import duenio.Duenio;
import excepciones.MascotaInvalidaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MascotaBuilder {
    private TipoAnimal tipoAnimal;
    private String nombre;
    private String apodo;
    private int edad = -1;
    private Sexo sexo;
    private String descripcionFisica;
    private List<String> fotos = new ArrayList<>();
    private Duenio duenio;
    private List<CaracteristicaDefinida> caracteristicasDefinidas = new ArrayList<>();

    //agregar a listas
    private void ingresarNuevaCaracteristica(String nombre, Object valor){
        CaracteristicaPosible nuevaCaracteristica = RepositorioCaracteristicasPosibles.getCaracteristicaIdeal(nombre);
        caracteristicasDefinidas.add(nuevaCaracteristica.crearCaracteristica(valor));
    }

    //setters
    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setDescripcionFisica(String descripcionFisica) {
        this.descripcionFisica = descripcionFisica;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    //crear mascota
    public Mascota registrarMascota() {
        validarMascota();
        return new Mascota(nombre, apodo, edad, sexo, tipoAnimal, descripcionFisica, fotos, caracteristicasDefinidas, duenio);
    }

    //validaciones
    private void validarMascota() {
        Objects.requireNonNull(nombre, "Debe ingresar un nombre");
        Objects.requireNonNull(apodo, "Debe ingresar un apodo");
        Objects.requireNonNull(sexo, "Debe ingresar un sexo");
        Objects.requireNonNull(tipoAnimal, "Debe ingresar un tipo de animal");
        Objects.requireNonNull(descripcionFisica, "Debe ingresar una descripción física");
        Objects.requireNonNull(duenio, "Debe ingresar un dueño");

        if (edad < 0) {
            throw new MascotaInvalidaException("debe ingresar una edad válida");
        }
        if (fotos.isEmpty()) {
            throw new MascotaInvalidaException("debe ingresar al menos una foto");
        }
        /*validarCaracteristicasObligatorias();*/
    }

    /*private void validarCaracteristicasObligatorias(){
        List<String> nombresCaracteristicasObligatorias = RepositorioCaracteristicas.getCaracteristicas()
                .stream().map(CaracteristicaSensible::getNombre)
                .collect(Collectors.toList());

        List<String> nombresCaracteristicasDefinidas = caracteristicasDefinidas
                .stream()
                .map(CaracteristicaSensible::getNombre)
                .collect(Collectors.toList());

        boolean caracteristicasValidas = nombresCaracteristicasDefinidas.containsAll(nombresCaracteristicasObligatorias);
        if(!caracteristicasValidas){
            throw new MascotaInvalidaException("debe ingresar todas las caracteristicas obligatorias");
        }
    }*/
}
