package model.excepciones;

public class MascotaInvalidaException extends RuntimeException {
    public MascotaInvalidaException(String s) {
        super("La model.mascota es inválida por que " + s);
    }
}
