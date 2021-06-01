import caracteristicas.*;
import excepciones.ValorCaracteristicaInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaracteristicas {
  CaracteristicaIdeal caracteristica = new CaracteristicaIdeal("Edad", true, new NumericaIdeal());

  @Test
  public void noSePuedeDefinirUnaCaracteristicaConUnValorDeTipoInvalido(){
    Assertions.assertThrows(
        ValorCaracteristicaInvalidoException.class,
        () -> caracteristica.crearCaracteristica("Hola")
    );
  }

  @Test
  public void sePuedeDefinirUnaCaracteristicaConUnValorDeTipoValido(){
    CaracteristicaDefinida caracteristicaDefinida = caracteristica.crearCaracteristica(2);
    assertEquals("Edad", caracteristica.getNombre());
  }

}
