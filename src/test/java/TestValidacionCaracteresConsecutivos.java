
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionCaracteresConsecutivos {

    ValidacionCaracteresConsecutivos validador = new ValidacionCaracteresConsecutivos();

    @Test
    public void cadenaInvalida() {
        assertEquals(validador.validacionContrasenia(("aaaaaa")), false);
    }

    @Test
    public void cadenaValida() {
        assertEquals(validador.validacionContrasenia(("hola")), true);
    }

    @Test
    public void cadenaNumericaInvalida() {
        assertEquals(validador.validacionContrasenia(("1111111")), false);
    }

    @Test
    public void cadenaNumericaValida() {
        assertEquals(validador.validacionContrasenia(("45621")), true);
    }

}
