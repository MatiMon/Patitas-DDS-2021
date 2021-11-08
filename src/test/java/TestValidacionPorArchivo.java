import org.junit.jupiter.api.Test;
import model.usuario.ListadoContrasenias;
import model.usuario.ValidacionPorArchivo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidacionPorArchivo {
    ValidacionPorArchivo validador = new ValidacionPorArchivo(new ListadoContrasenias("/10k-most-common.txt"));

    @Test
    public void cadenaPertenecienteAlArchivo() {
        assertEquals(validador.esContraseniaValida(("monkey")), false);
    }

    @Test
    public void cadenaNoPertencienteAlArchivo() {
        assertEquals(validador.esContraseniaValida(("soyUnaPasswordPotente")), true);
    }

}
