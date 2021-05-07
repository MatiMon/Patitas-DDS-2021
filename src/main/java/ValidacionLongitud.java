public class ValidacionLongitud implements ValidacionContrasenia{

    private final int longitudMinima = 8;

    private final int longitudMaxima = 64;


    public boolean validacionContrasenia(String password) {
        return longitudMinima <= password.length() && password.length() <= longitudMaxima;
    }

    public String getIdentificador() {
        return "LONGITUD";
    }
}
