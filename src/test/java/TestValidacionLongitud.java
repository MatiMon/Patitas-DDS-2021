import org.junit.jupiter.api.Test;
import model.usuario.ValidacionDeLongitud;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionLongitud {
    ValidacionDeLongitud validador = new ValidacionDeLongitud();

    @Test
    public void contraseniaMenorMinimo() {
        assertEquals(validador.esContraseniaValida(("feq")), false);
    }

    @Test
    public void contraseniaIgualAlMinimo() {
        assertEquals(validador.esContraseniaValida(("mgrtzpla")), true);
    }

    @Test
    public void contraseniaIgualAlMaximo() {
        assertEquals(validador.esContraseniaValida(("owaspowaspowaspowaspowaspowaspowaspowaspowaspowaspowaspwasp")), true);
    }

    @Test
    public void contraseniaMayorMaximo() {
        assertEquals(validador.esContraseniaValida(("owaspowaspowaspowaspowaspowaspowaspowaspowaspowaspowaspwaspdfasdfsadfsadfdfaf")), false);
    }

    @Test
    public void contraseniaEntreMinimoAndMaximo() {
        assertEquals(validador.esContraseniaValida(("diseniodesistemas")), true);
    }

}
