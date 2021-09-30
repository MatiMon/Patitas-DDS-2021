package usuario;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("PorCaracteresConsecutivos")
public class ValidacionDeCaracteresConsecutivos extends ValidacionDeContrasenia {

    @Override
    public boolean esContraseniaValida(String password) {
        return !todosLosCaracteresIguales(password);
    }

    @Override
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
