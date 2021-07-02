package caracteristicas.definidas;

public abstract class CaracteristicaDefinida {
    String nombre;

    public String getNombre() {
        return nombre;
    }
    public Boolean esCompatibleCon(CaracteristicaDefinida comodidad){
        return comodidad == null || compatibilidad(comodidad);
    }

    public abstract boolean compatibilidad(CaracteristicaDefinida comodidad);
}
