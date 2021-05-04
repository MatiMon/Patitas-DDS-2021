import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MascotaBuilder {
    TipoAnimal tipoAnimal;
    String nombre;
    String apodo;
    int edad = -1;
    Sexo sexo;
    String descripcionFisica;
    List<String> fotos = new ArrayList<>();
    List<Caracteristica> caracteriticasObligatorias = new ArrayList<>();
    List<Caracteristica> caracteristicasOpcionales = new ArrayList<>();
    Dueño dueño; //TODO ver nombre dueño por la ñ D:
    List<Caracteristica> caracteristicasDefinidas = new ArrayList<>();

    //agregar a listas
    public void agregarObligatorias(Caracteristica caracteristica) {
        caracteriticasObligatorias.add(caracteristica);
    }

    public void agregarOpcionales(Caracteristica caracteristica) {
        caracteristicasOpcionales.add(caracteristica);
    }

    public void agregarDefinidas(Caracteristica caracteristica) {
        caracteristicasDefinidas.add(caracteristica);
    }

    //quitar de listas
    public void quitarObligatorias(Caracteristica caracteristica) {
        caracteriticasObligatorias.remove(caracteristica);
    }

    public void quitarOpcionales(Caracteristica caracteristica) {
        caracteristicasOpcionales.remove(caracteristica);
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

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    //crear mascota
    public Mascota registrarMascota() {
        validarMascota();
        return new Mascota(nombre, apodo, edad, sexo, tipoAnimal, descripcionFisica, fotos, caracteristicasDefinidas, dueño);
    }

    //validaciones
    private void validarMascota() {
        if (nombre == null) {
            throw new MascotaInvalidaException("debe ingresar un nombre");
        }
        if (apodo == null) {
            throw new MascotaInvalidaException("debe ingresar un apodo");
        }
        if (edad < 0) {
            throw new MascotaInvalidaException("debe ingresar una edad válida");
        }
        if (sexo == null) {
            throw new MascotaInvalidaException("debe ingresar un sexo");
        }
        if (descripcionFisica == null) {
            throw new MascotaInvalidaException("debe ingresar una descripcionFisica");
        }
        if (fotos.isEmpty()) {
            throw new MascotaInvalidaException("debe ingresar al menos una foto");
        }
        if (dueño == null) {
            throw new MascotaInvalidaException("debe ingresar un dueño");
        }
        validarCaracteristicasObligatorias();
    }

    private void validarCaracteristicasObligatorias(){
        List<String> nombresCaracteristicasObligatorias = caracteriticasObligatorias.stream().map(Caracteristica::getNombre).collect(Collectors.toList());
        Boolean caracteristicasValidas = caracteristicasDefinidas.stream().allMatch(caracteristica -> nombresCaracteristicasObligatorias.stream().anyMatch(unNombre -> unNombre == caracteristica.getNombre()));
        if(!caracteristicasValidas){
            throw new MascotaInvalidaException("debe ingresar todas las caracteristicas obligatorias");
        }
    }
}
