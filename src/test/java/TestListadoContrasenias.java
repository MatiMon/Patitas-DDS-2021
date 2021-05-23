import excepciones.NombreDeArchivoInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usuario.ListadoContrasenias;


public class TestListadoContrasenias {
  @Test
  public void ArchivoInvalido() {

    Assertions.assertThrows(NombreDeArchivoInvalidoException.class, () -> {
      new ListadoContrasenias("/este-nombre-es-invalido.txt");
    }); //se usa mucho para simular evaluacion diferida en objetos

  }
}
