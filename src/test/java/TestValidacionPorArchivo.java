import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionPorArchivo {
    ValidacionPorArchivo validador = new ValidacionPorArchivo(new ArchivoCacheado("/10k-most-common.txt"));

    @Test
    public void cadenaPertenecienteAlArchivo() {
        assertEquals(validador.validacionContrasenia(("monkey")), false);
    }

    @Test
    public void cadenaNoPertencienteAlArchivo() {
        assertEquals(validador.validacionContrasenia(("soyUnaPasswordPotente")), true);
    }

}
