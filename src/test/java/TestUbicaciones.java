import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ubicacion.Ubicacion;

public class TestUbicaciones {
  Ubicacion ubicacion1 = new Ubicacion("Calle falsa 123",20, 20);
  Ubicacion ubicacion2 = new Ubicacion("Calle Wallaby 42",40,40);

  @Test
  void sePuedeObtenerLaDistanciaEntreDosPuntos(){
    Assertions.assertEquals(2928,ubicacion1.calcularDistancia(ubicacion2));
  }

  @Test
  void sePuedeSaberSiUnaUbicacionEstaDentroDeUnRadioTomadoDesdeLaOtra(){
    Assertions.assertTrue(ubicacion1.estaDentroDelRadio(ubicacion2,4000));
  }

}
