import model.adopciones.PublicacionIntencionDeAdopcion;
import model.adopciones.PublicacionMascotaEnAdopcion;
import model.adopciones.RecomendadorMascotas;
import model.asociacion.Asociacion;
import model.asociacion.RepositorioAsociaciones;
import model.caracteristicas.definidas.BooleanaDefinida;
import model.caracteristicas.definidas.NumericoDefinida;
import model.mascota.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRecomendadorMascotas {
  private NumericoDefinida caracteristica = new NumericoDefinida("Edad", 12);
  private BooleanaDefinida comodidadPatio = new BooleanaDefinida("Patio", true);
  private Mascota mascota1 = new Mascota("nombre", "apodo", 2, Sexo.HEMBRA, TipoAnimal.GATO, "Lindo", null, Arrays.asList(caracteristica) , null, "2", Tamanio.GRANDE);
  private PublicacionIntencionDeAdopcion intencionDeAdopcion = new PublicacionIntencionDeAdopcion(Arrays.asList(comodidadPatio),
      Arrays.asList(caracteristica), null, TipoAnimal.GATO, Sexo.HEMBRA, Tamanio.GRANDE, "link");

  private PublicacionMascotaEnAdopcion mascotaEnAdopcionCompatible = new PublicacionMascotaEnAdopcion(Arrays.asList(comodidadPatio),mascota1);

  private Mascota mascota2 = new Mascota("nombre", "apodo", 2, Sexo.HEMBRA, TipoAnimal.GATO, "Lindo", null, null , null, "3", Tamanio.CHICO);
  private PublicacionMascotaEnAdopcion mascotaEnAdopcionIncompatible = new PublicacionMascotaEnAdopcion(Arrays.asList(comodidadPatio),mascota2);

  private Asociacion asociacion1 = asociacion1 = new Asociacion("patitas",null, null,null, Arrays.asList(mascotaEnAdopcionCompatible ,mascotaEnAdopcionIncompatible),null);
  private RepositorioAsociaciones repoAsociaciones = RepositorioAsociaciones.getInstancia();
  private RecomendadorMascotas recomendador = RecomendadorMascotas.getInstancia();

  @BeforeEach
    public void init(){
    repoAsociaciones.agregarAsociacion(asociacion1);
  }

  @AfterEach
      public void finalizar(){
    repoAsociaciones.removerAsociacion(asociacion1);
  }

  @Test
  public void SeObtienenSoloLasPublicacionesDeMascotasEnAdopcionCompatibles(){
    assertEquals(Arrays.asList(mascotaEnAdopcionCompatible), recomendador.publicacionesMascotasEnAdopcionCompatibles(intencionDeAdopcion));
  }

}
