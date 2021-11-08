
import org.junit.jupiter.api.Test;
import model.usuario.ValidacionDeCaracteresConsecutivos;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionCaracteresConsecutivos {

    ValidacionDeCaracteresConsecutivos validador = new ValidacionDeCaracteresConsecutivos();

    @Test
    public void cadenaInvalida() {
        assertEquals(validador.esContraseniaValida(("aaaaaa")), false);
    }

    @Test
    public void cadenaValida() {
        assertEquals(validador.esContraseniaValida(("hola")), true);
    }

    @Test
    public void cadenaNumericaInvalida() {
        assertEquals(validador.esContraseniaValida(("1111111")), false);
    }

    @Test
    public void cadenaNumericaValida() {
        assertEquals(validador.esContraseniaValida(("45621")), true);
    }

}
