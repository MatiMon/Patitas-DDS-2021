import org.junit.jupiter.api.Test;
import usuario.ArchivoCacheado;
import usuario.ValidacionDePorArchivo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionPorArchivo {
    ValidacionDePorArchivo validador = new ValidacionDePorArchivo(new ArchivoCacheado("/10k-most-common.txt"));

    @Test
    public void cadenaPertenecienteAlArchivo() {
        assertEquals(validador.validarContrasenia(("monkey")), false);
    }

    @Test
    public void cadenaNoPertencienteAlArchivo() {
        assertEquals(validador.validarContrasenia(("soyUnaPasswordPotente")), true);
    }

}
