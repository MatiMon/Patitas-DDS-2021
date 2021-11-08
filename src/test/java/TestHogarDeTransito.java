import model.hogares.HogarDeTransito;
import model.mascota.Tamanio;
import model.mascota.TipoAnimal;
import org.junit.jupiter.api.Test;
import model.ubicacion.Ubicacion;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHogarDeTransito {
  Ubicacion ubicacion = new Ubicacion("Calle falsa 123", -34.42061525423029, -58.572775488348505);
  Ubicacion ubicacionCercana = new Ubicacion("Calle falsa 200", -34.42061525423024, -58.572775488348507);
  Ubicacion ubicacionLejana = new Ubicacion("calle verdadera 200", -34.42061525423024, -10.572775488348507);
  HogarDeTransito hogarDeGatos = crearHogarDeTransito(true, ubicacion, Arrays.asList(TipoAnimal.GATO), 20);
  HogarDeTransito hogarSinPatio = crearHogarDeTransito(false, ubicacionCercana, Arrays.asList(TipoAnimal.GATO), 26);


  @Test
  public void admiteTipoDeAnimal(){
    assertTrue(hogarDeGatos.admiteTipoAnimal(TipoAnimal.GATO));
  }

  @Test
  public void noAdmiteUnTipoDeAnimal(){
    assertFalse(hogarDeGatos.admiteTipoAnimal(TipoAnimal.PERRO));
  }

  @Test
  public void admiteAnimalesSiTieneLugaresDisponiblesYEstaDentroDelRadio(){
    assertTrue(hogarDeGatos.estaDisponibleYcercaDe(ubicacionCercana, 10));
  }

  @Test
  public void noAdmiteAnimalesSiNoTieneLugaresDisponibles(){
    HogarDeTransito hogarSinLugar = crearHogarDeTransito(true, ubicacion, Arrays.asList(TipoAnimal.GATO), 0);
    assertFalse(hogarSinLugar.estaDisponibleYcercaDe(ubicacion, 10));
  }

  @Test
  public void noAdmiteAnimalesSiNoEstaDentroDelRadio(){
    HogarDeTransito hogarSinLugar = crearHogarDeTransito(true, ubicacionLejana, Arrays.asList(TipoAnimal.GATO), 26);
    assertFalse(hogarSinLugar.estaDisponibleYcercaDe(ubicacion, 10));
  }

  @Test
  public void unHogarConPatioAdmiteTamanioGrande(){
    assertTrue(hogarDeGatos.admiteTamanio(Tamanio.GRANDE));
  }

  @Test
  public void unHogarSinPatioNoAdmiteTamanioGrande(){
    assertFalse(hogarSinPatio.admiteTamanio(Tamanio.GRANDE));
  }

  @Test
  public void unHogarSinPatioAdmiteTamanioChico(){
    assertTrue(hogarSinPatio.admiteTamanio(Tamanio.CHICO));
  }

  private HogarDeTransito crearHogarDeTransito(Boolean tienePatio, Ubicacion ubicacion, List<TipoAnimal> animalesAdmitidos, int lugaresDisponibles){
    return new HogarDeTransito(tienePatio, 200, ubicacion, "+54123456789", animalesAdmitidos, lugaresDisponibles, Arrays.asList("Manso"));
  }

}