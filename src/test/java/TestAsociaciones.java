import Asociacion.Asociacion;
import contacto.Contacto;
import duenio.TipoDocumento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rescate.Rescatista;
import rescate.RescateDeMascota;
import rescate.RescateDeMascotaRegistrada;
import rescate.RescateDeMascotaSinRegistrar;
import ubicacion.Ubicacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestAsociaciones {

  private Asociacion asociacion;
  private Asociacion asociacion2;
  private List<RescateDeMascotaRegistrada> rescatesDeMascotasRegistradas = new ArrayList<>();
  private List<RescateDeMascotaSinRegistrar> rescatesDeMascotasSinRegistrar = new ArrayList<>();
  private RescateDeMascotaRegistrada rescateDeMascotaRegistrada1;
  private RescateDeMascotaRegistrada rescateDeMascotaRegistrada2;
  private RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar1;
  private RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar2;
  private RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar3;

  private List<String> fotos = new ArrayList<>();

  private Contacto contacto1;
  Rescatista rescatista;
  private Contacto contacto2;
  private List<Contacto> contactos = new ArrayList<>();


  @BeforeEach
  void initFileSystem() {
    contacto2 = new Contacto("nombre", "apellido", 1234, "nombre@hotmail.com");
    fotos.add("una foto");
    contacto1 = new Contacto("Juan", "Perez", 15501234, "juanperez@hotmail.com");
    rescatista = new Rescatista("nombre", "apodo", LocalDate.of(2021,12,12), TipoDocumento.DNI, "callefalsa123", contacto1);

    rescateDeMascotaRegistrada1 = new RescateDeMascotaRegistrada(fotos,"Descripcion1", new Ubicacion("San Martín 150", -34.58499, -58.45023), rescatista, LocalDateTime.now().minusDays(5),"QR-1");
    rescateDeMascotaRegistrada2 = new RescateDeMascotaRegistrada(fotos,"Descripcion2", new Ubicacion("Guardia Vieja 2077", -34.58499, -58.45023), rescatista, LocalDateTime.now().minusDays(2),"QR-2");

    //por el momento, con null porque no se necesitan para probar los metodos del TEST
    rescateDeMascotaSinRegistrar1 = new RescateDeMascotaSinRegistrar(fotos,null,null,null,LocalDateTime.now().minusDays(15),1);
    rescateDeMascotaSinRegistrar2 = new RescateDeMascotaSinRegistrar(fotos,null,null,null,LocalDateTime.now().minusDays(8),2);
    rescateDeMascotaSinRegistrar3 = new RescateDeMascotaSinRegistrar(fotos,null,null,null,LocalDateTime.now().minusDays(1),3);

    rescatesDeMascotasRegistradas.add(rescateDeMascotaRegistrada1);
    rescatesDeMascotasRegistradas.add(rescateDeMascotaRegistrada2);
    rescatesDeMascotasSinRegistrar.add(rescateDeMascotaSinRegistrar1);
    rescatesDeMascotasSinRegistrar.add(rescateDeMascotaSinRegistrar2);
    rescatesDeMascotasSinRegistrar.add(rescateDeMascotaSinRegistrar3);

    asociacion = new Asociacion("Patitas", new Ubicacion("correintes 100",-34.7000,-55.0000 ), rescatesDeMascotasSinRegistrar, rescatesDeMascotasRegistradas);
  }

  @Test
  public void laAsociacionObtieneSusPublicacionesAprobadas() {
    rescateDeMascotaSinRegistrar1.aprobarPublicacion();
    rescateDeMascotaSinRegistrar2.aprobarPublicacion();
    List<RescateDeMascotaSinRegistrar> listaAprobadas = Arrays.asList(rescateDeMascotaSinRegistrar1,rescateDeMascotaSinRegistrar2);

    Assertions.assertEquals(listaAprobadas,asociacion.obtenerPublicacionesAprobadas());
  }

  @Test
  public void laAsociacionObtieneSusPublicacionesSinAprobar() {
    rescateDeMascotaSinRegistrar1.aprobarPublicacion();
    List<RescateDeMascotaSinRegistrar> listaNoAprobadas = Arrays.asList(rescateDeMascotaSinRegistrar2,rescateDeMascotaSinRegistrar3);

    Assertions.assertEquals(listaNoAprobadas,asociacion.obtenerPublicacionesSinAprobar());
  }

  @Test //surge a partir de la necesidad de hacer una busqueda entre TODOS los rescates
        //al tester que contenga La lista, pero ademas sea la misma longitud, se llega a que es la misma.
  public void lasMascotasEncontradasSonDeDeizDiasEnAdelanteIncluyendoRegistradasYNoRegistradasAprobadas() {
    rescateDeMascotaSinRegistrar3.aprobarPublicacion();
    List<RescateDeMascota> rescatesRegistradosYaprobadosMenoresA10Dias = Arrays.asList(
            rescateDeMascotaRegistrada1, rescateDeMascotaRegistrada2, rescateDeMascotaSinRegistrar3
    );

    Assertions.assertTrue(asociacion.ultimasMascotasEncontradas(10).containsAll(rescatesRegistradosYaprobadosMenoresA10Dias));
    Assertions.assertEquals(rescatesRegistradosYaprobadosMenoresA10Dias.size(), asociacion.ultimasMascotasEncontradas(10).size());
  }
}
