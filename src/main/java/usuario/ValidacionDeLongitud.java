package usuario;

public class ValidacionDeLongitud implements ValidacionDeContrasenia {

    private final int longitudMinima = 8;

    private final int longitudMaxima = 64;


    public boolean validarContrasenia(String password) {
        return longitudMinima <= password.length() && password.length() <= longitudMaxima;
    }

    public String getIdentificador() {
        return "LONGITUD";
    }
}
