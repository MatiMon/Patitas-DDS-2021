package caracteristicas;

public class ComodidadIdeal extends CaracteristicaIdeal {
    String preguntaAdoptante;
    String preguntaDuenio;

    public ComodidadIdeal(String preguntaAdoptante, String preguntaDuenio, String nombre, Boolean esObligatoria,
                          TipoCaracteristica tipo) {
        super(nombre, esObligatoria, tipo);
        this.preguntaAdoptante = preguntaAdoptante;
        this.preguntaDuenio = preguntaDuenio;
    }
}
