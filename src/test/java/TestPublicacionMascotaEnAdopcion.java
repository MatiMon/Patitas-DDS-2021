import asociacion.Asociacion;
import asociacion.RepositorioAsociaciones;
import caracteristicas.BooleanaDefinida;
import caracteristicas.NumericoDefinida;
import caracteristicas.TextoDefinida;
import mascota.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class TestPublicacionMascotaEnAdopcion {

  private NumericoDefinida edadDoce = new NumericoDefinida("Edad", 12);
  private TextoDefinida descipcionFisica1 = new TextoDefinida("Descripcion Fisica","Linda");

  private NumericoDefinida edadCuatro = new NumericoDefinida("Edad", 4);

  private BooleanaDefinida comodidadPatioTrue = new BooleanaDefinida("Patio", true);
  private BooleanaDefinida comodidadPatioFalse = new BooleanaDefinida("Patio", false);

  private Mascota mascota1 = new Mascota("nombre", "apodo", 2, Sexo.HEMBRA, TipoAnimal.GATO, "Lindo", null, Arrays.asList(edadDoce, descipcionFisica1) , null, "2", Tamanio.GRANDE);
  private PublicacionMascotaEnAdopcion mascotaEnAdopcion = new PublicacionMascotaEnAdopcion(Arrays.asList(comodidadPatioTrue),mascota1);

  private PublicacionIntencionDeAdopcion intencionDeAdopcionCompatible = new PublicacionIntencionDeAdopcion(Arrays.asList(comodidadPatioTrue),
      Arrays.asList(edadDoce), null, TipoAnimal.GATO, Sexo.HEMBRA, Tamanio.GRANDE, "link");

  private PublicacionIntencionDeAdopcion intencionDeAdopcionCaracteristicasIncompatibles = new PublicacionIntencionDeAdopcion(Arrays.asList(comodidadPatioTrue),
      Arrays.asList(edadCuatro), null, TipoAnimal.GATO, Sexo.HEMBRA, Tamanio.GRANDE, "link");

  private PublicacionIntencionDeAdopcion intencionDeAdopcionComodidadesIncompatibles = new PublicacionIntencionDeAdopcion(Arrays.asList(comodidadPatioFalse),
      Arrays.asList(edadDoce), null, TipoAnimal.GATO, Sexo.HEMBRA, Tamanio.GRANDE, "link");

  private PublicacionIntencionDeAdopcion intencionDeAdopcionSexoIncompatible = new PublicacionIntencionDeAdopcion(Arrays.asList(comodidadPatioTrue),
      Arrays.asList(edadDoce), null, TipoAnimal.GATO, Sexo.MACHO, Tamanio.GRANDE, "link");

  @Test
  public void unaPublicacionEsCompatibleSiSeCumplenTodasSusPreferencias(){
    assertTrue(mascotaEnAdopcion.esCompatible(intencionDeAdopcionCompatible));
  }

  @Test
  public void unaPublicacionEsIncompatibleSiNoSeCumplenTodasSusPreferenciasDeCaracteristicas(){
    assertFalse(mascotaEnAdopcion.esCompatible(intencionDeAdopcionCaracteristicasIncompatibles));
  }

  @Test
  public void unaPublicacionEsIncompatibleSiNoSeCumplenTodasSusPreferenciasDeComodidades(){
    assertFalse(mascotaEnAdopcion.esCompatible(intencionDeAdopcionComodidadesIncompatibles));
  }

  @Test
  public void unaPublicacionEsIncompatibleSiNoSeCumplenTodasSusPreferenciasDeCaracteristicasBasicas(){
    assertFalse(mascotaEnAdopcion.esCompatible(intencionDeAdopcionSexoIncompatible));
  }

}
