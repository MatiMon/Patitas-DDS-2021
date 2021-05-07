import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionLongitud {
    ValidacionLongitud validador = new ValidacionLongitud();

    @Test
    public void contraseniaMenorMinimo() {
        assertEquals(validador.validacionContrasenia(("feq")), false);
    }

    @Test
    public void contraseniaIgualAlMinimo() {
        assertEquals(validador.validacionContrasenia(("mgrtzpla")), true);
    }

    @Test
    public void contraseniaIgualAlMaximo() {
        assertEquals(validador.validacionContrasenia(("owaspowaspowaspowaspowaspowaspowaspowaspowaspowaspowaspwasp")), true);
    }

    @Test
    public void contraseniaMayorMaximo() {
        assertEquals(validador.validacionContrasenia(("owaspowaspowaspowaspowaspowaspowaspowaspowaspowaspowaspwaspdfasdfsadfsadfdfaf")), false);
    }

    @Test
    public void contraseniaEntreMinimoAndMaximo() {
        assertEquals(validador.validacionContrasenia(("diseniodesistemas")), true);
    }

}
