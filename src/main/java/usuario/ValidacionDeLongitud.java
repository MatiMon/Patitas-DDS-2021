package usuario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Transient;

@DiscriminatorValue("PorLongitud")
public class ValidacionDeLongitud extends ValidacionDeContrasenia {

    @Transient
    private final int longitudMinima = 8;
    @Transient
    private final int longitudMaxima = 64;

    @Override
    public boolean esContraseniaValida(String password) {
        return longitudMinima <= password.length() && password.length() <= longitudMaxima;
    }

    @Override
    public String getIdentificador() {
        return "LONGITUD";
    }
}
