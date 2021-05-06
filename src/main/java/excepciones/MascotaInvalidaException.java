package excepciones;

public class MascotaInvalidaException extends RuntimeException {
    public MascotaInvalidaException(String s) {
        super("La mascota es inválida por que " + s);
    }
}
