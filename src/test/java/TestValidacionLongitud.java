import org.junit.jupiter.api.Test;
import usuario.ValidacionDeLongitud;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionLongitud {
    ValidacionDeLongitud validador = new ValidacionDeLongitud();

    @Test
    public void contraseniaMenorMinimo() {
        assertEquals(validador.validarContrasenia(("feq")), false);
    }

    @Test
    public void contraseniaIgualAlMinimo() {
        assertEquals(validador.validarContrasenia(("mgrtzpla")), true);
    }

    @Test
    public void contraseniaIgualAlMaximo() {
        assertEquals(validador.validarContrasenia(("owaspowaspowaspowaspowaspowaspowaspowaspowaspowaspowaspwasp")), true);
    }

    @Test
    public void contraseniaMayorMaximo() {
        assertEquals(validador.validarContrasenia(("owaspowaspowaspowaspowaspowaspowaspowaspowaspowaspowaspwaspdfasdfsadfsadfdfaf")), false);
    }

    @Test
    public void contraseniaEntreMinimoAndMaximo() {
        assertEquals(validador.validarContrasenia(("diseniodesistemas")), true);
    }

}
