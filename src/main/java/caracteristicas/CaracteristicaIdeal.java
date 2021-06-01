package caracteristicas;

public class CaracteristicaIdeal {
    private String nombre;
    private Boolean esObligatoria;
    private TipoCaracteristica tipo;

    public CaracteristicaIdeal(String nombre, Boolean esObligatoria, TipoCaracteristica tipo) {
        this.nombre = nombre;
        this.esObligatoria = esObligatoria;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean esObligatoria(){
        return esObligatoria;
    }

    public CaracteristicaDefinida crearCaracteristica(Object valor){
        return tipo.crearCaracteristica(nombre, valor);
    }
}