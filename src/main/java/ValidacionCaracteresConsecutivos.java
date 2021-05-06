public class ValidacionCaracteresConsecutivos implements ValidacionDePasswords {

    public boolean validarPassword(String password) {
        return !todosLosCaracteresIguales(password);
    }

    public String getIdentificador() {
        return "CARACTERES";
    }

    private boolean todosLosCaracteresIguales(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++)
            if (s.charAt(i) != s.charAt(0)) {
                return false;
            }
        return true;
    }
}
