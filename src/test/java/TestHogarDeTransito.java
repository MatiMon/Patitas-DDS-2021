import hogares.HogarDeTransito;
import mascota.TipoAnimal;
import org.junit.jupiter.api.Test;
import ubicacion.Ubicacion;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHogarDeTransito {
  Ubicacion ubicacion = new Ubicacion("Calle falsa", 123, -34.42061525423029, -58.572775488348505);
  Ubicacion otraUbicacion = new Ubicacion("Calle falsa", 200, -34.42061525423024, -58.572775488348507);


  @Test
  public void admiteTipoDeAnimal(){
    HogarDeTransito hogarDeGatos = crearHogarDeTransito(true, ubicacion, Arrays.asList(TipoAnimal.GATO), 20);
    assertTrue(hogarDeGatos.admiteTipoAnimal(TipoAnimal.GATO));
  }

  private HogarDeTransito crearHogarDeTransito(Boolean tienePatio, Ubicacion ubicacion, List<TipoAnimal> animalesAdmitidos, int lugaresDisponibles){
    return new HogarDeTransito(tienePatio, 200, ubicacion, "+54123456789", animalesAdmitidos, lugaresDisponibles, Arrays.asList("Manso"));
  }

}