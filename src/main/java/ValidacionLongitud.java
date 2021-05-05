public class ValidacionLongitud implements ValidacionDePasswords{

    private final int longitudMinima = 4;

    private final int longitudMaxima = 64;


    public boolean validarPassword(String password) {
        return longitudMinima <= password.length() && password.length() <= longitudMaxima;
    }

    public String getIdentificador() {
        return "LONGITUD";
    }
}
