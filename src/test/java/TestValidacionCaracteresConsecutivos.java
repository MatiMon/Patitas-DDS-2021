
import org.junit.jupiter.api.Test;
import usuario.ValidacionDeCaracteresConsecutivos;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionCaracteresConsecutivos {

    ValidacionDeCaracteresConsecutivos validador = new ValidacionDeCaracteresConsecutivos();

    @Test
    public void cadenaInvalida() {
        assertEquals(validador.validarContrasenia(("aaaaaa")), false);
    }

    @Test
    public void cadenaValida() {
        assertEquals(validador.validarContrasenia(("hola")), true);
    }

    @Test
    public void cadenaNumericaInvalida() {
        assertEquals(validador.validarContrasenia(("1111111")), false);
    }

    @Test
    public void cadenaNumericaValida() {
        assertEquals(validador.validarContrasenia(("45621")), true);
    }

}
