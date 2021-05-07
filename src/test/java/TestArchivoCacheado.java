import excepciones.NombreDeArchivoInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import usuario.ArchivoCacheado;


public class TestArchivoCacheado {
    @Test
    public void ArchivoInvalido() {

        Assertions.assertThrows(NombreDeArchivoInvalidoException.class, (Executable) new ArchivoCacheado("/este-nombre-es-invalido.txt"));

    }
}
