import caracteristicas.*;
import excepciones.ValorCaracteristicaInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCaracteristicas {
  CaracteristicaIdeal caracteristica = new CaracteristicaIdeal("Edad", true, new NumericaIdeal());
  CaracteristicaIdeal comidaFavorita = new CaracteristicaIdeal("Comida Favorita",
      true, new EnumeradaIdeal(Arrays.asList("En lata", "Casera", "Deshidratada")));

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
