import asociacion.Asociacion;
import caracteristicas.CaracteristicaDefinida;
import caracteristicas.TextoDefinida;
import contacto.Contacto;
import duenio.Duenio;
import duenio.TipoDocumento;
import mascota.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rescate.Rescatista;
import rescate.RescateDeMascota;
import rescate.RescateDeMascotaRegistrada;
import rescate.RescateDeMascotaSinRegistrar;
import ubicacion.Ubicacion;
import asociacion.RepositorioAsociaciones;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestAsociaciones {


  private List<RescateDeMascotaRegistrada> rescatesDeMascotasRegistradas = new ArrayList<>();
  private List<RescateDeMascotaSinRegistrar> rescatesDeMascotasSinRegistrar = new ArrayList<>();
  private RescateDeMascotaRegistrada rescateDeMascotaRegistrada1;
  private RescateDeMascotaRegistrada rescateDeMascotaRegistrada2;
  private RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar1;
  private RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar2;
  private RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar3;
  private RepositorioAsociaciones repositorioAsociaciones;
  private Ubicacion ubicacionSanMartin;
  private Ubicacion ubicacionGuardiaVieja;
  private List<String> fotos = new ArrayList<>();


  private Contacto contacto1;
  Rescatista rescatista;
  private Contacto contacto2;
  private List<Contacto> contactos = new ArrayList<>();
  Asociacion asociacionSanMartin = new Asociacion("Patitas", new Ubicacion("San Martin 155",-34.59000,-58.50000 ), rescatesDeMascotasSinRegistrar, rescatesDeMascotasRegistradas);
  Asociacion asociacionLejana = new Asociacion("Manchitas",new Ubicacion("lugarLejano",35.86166,104.195397), null,null);
  Mascota mascota = new Mascota("Pepito", "Pepe", 4, Sexo.MACHO, TipoAnimal.GATO, "lindo", Arrays.asList("foto1.jpg"), null, null, "QR-1", Tamanio.GRANDE);
  RepositorioMascotas repositorioMascotas;
  CaracteristicaDefinida personalidad = new TextoDefinida("personalidad", "Manso");

  private Duenio duenio;

  @BeforeEach
  void init() {
    repositorioMascotas = RepositorioMascotas.getInstancia();
    repositorioMascotas.registrarMascota("QR-1", mascota);
    contacto2 = new Contacto("nombre", "apellido", 1234, "nombre@hotmail.com");
    fotos.add("una foto");
    contacto1 = new Contacto("Juan", "Perez", 15501234, "juanperez@hotmail.com");
    rescatista = new Rescatista("nombre", "apodo", LocalDate.of(2021,12,12), TipoDocumento.DNI, "callefalsa123", contacto1);
    ubicacionSanMartin = new Ubicacion("San Martín 150", -34.58499, -58.45023);
    ubicacionGuardiaVieja = new Ubicacion("Guardia Vieja 2077", -34.58499, -58.45023);
    contactos.add(contacto1);
    this.duenio = new Duenio("Matias", "Sosa", null, TipoDocumento.DNI, 40000000, this.contactos);


    rescateDeMascotaRegistrada1 = new RescateDeMascotaRegistrada(fotos,"Descripcion1", ubicacionSanMartin, rescatista, LocalDateTime.now().minusDays(5), repositorioMascotas.obtenerMascota("QR-1"));
    rescateDeMascotaRegistrada2 = new RescateDeMascotaRegistrada(fotos,"Descripcion2", ubicacionGuardiaVieja, rescatista, LocalDateTime.now().minusDays(2), repositorioMascotas.obtenerMascota("QR-1"));

    //por el momento, con null porque no se necesitan para probar los metodos del TEST
    rescateDeMascotaSinRegistrar1 = new RescateDeMascotaSinRegistrar(fotos,null,null,null,LocalDateTime.now().minusDays(15), Tamanio.GRANDE, TipoAnimal.PERRO, personalidad, this.duenio);
    rescateDeMascotaSinRegistrar2 = new RescateDeMascotaSinRegistrar(fotos,null,null,null,LocalDateTime.now().minusDays(8), Tamanio.GRANDE, TipoAnimal.PERRO, personalidad, this.duenio);
    rescateDeMascotaSinRegistrar3 = new RescateDeMascotaSinRegistrar(fotos,null,null,null,LocalDateTime.now().minusDays(1), Tamanio.GRANDE, TipoAnimal.PERRO, personalidad, this.duenio);

    rescatesDeMascotasRegistradas.add(rescateDeMascotaRegistrada1);
    rescatesDeMascotasRegistradas.add(rescateDeMascotaRegistrada2);
    rescatesDeMascotasSinRegistrar.add(rescateDeMascotaSinRegistrar1);
    rescatesDeMascotasSinRegistrar.add(rescateDeMascotaSinRegistrar2);
    rescatesDeMascotasSinRegistrar.add(rescateDeMascotaSinRegistrar3);

    repositorioAsociaciones = RepositorioAsociaciones.getInstancia();

    repositorioAsociaciones.agregarAsociacion(asociacionSanMartin);
    repositorioAsociaciones.agregarAsociacion(asociacionLejana);
  }

  @AfterEach
  void finalizar(){
    repositorioAsociaciones.removerAsociacion(asociacionSanMartin);
    repositorioAsociaciones.removerAsociacion(asociacionLejana);
    repositorioMascotas.removerMascota("QR-1");

  }

  @Test
  public void laAsociacionObtieneSusPublicacionesAprobadas() {
    rescateDeMascotaSinRegistrar1.aprobarPublicacion();
    rescateDeMascotaSinRegistrar2.aprobarPublicacion();
    List<RescateDeMascotaSinRegistrar> listaAprobadas = Arrays.asList(rescateDeMascotaSinRegistrar1,rescateDeMascotaSinRegistrar2);

    Assertions.assertEquals(listaAprobadas, asociacionSanMartin.obtenerPublicacionesAprobadas());
  }

  @Test
  public void laAsociacionObtieneSusPublicacionesSinAprobar() {
    rescateDeMascotaSinRegistrar1.aprobarPublicacion();
    List<RescateDeMascotaSinRegistrar> listaNoAprobadas = Arrays.asList(rescateDeMascotaSinRegistrar2,rescateDeMascotaSinRegistrar3);

    Assertions.assertEquals(listaNoAprobadas, asociacionSanMartin.obtenerPublicacionesSinAprobar());
  }

  @Test //al testear que contenga La lista, pero ademas sea la misma longitud, se llega a que es la misma.
  public void lasMascotasEncontradasSonDeDeizDiasEnAdelanteIncluyendoRegistradasYNoRegistradasAprobadas() {
    rescateDeMascotaSinRegistrar3.aprobarPublicacion();
    List<RescateDeMascota> rescatesRegistradosYaprobadosMenoresA10Dias = Arrays.asList(
            rescateDeMascotaRegistrada1, rescateDeMascotaRegistrada2, rescateDeMascotaSinRegistrar3
    );

    Assertions.assertTrue(asociacionSanMartin.ultimasMascotasEncontradas(10).containsAll(rescatesRegistradosYaprobadosMenoresA10Dias));
    Assertions.assertEquals(rescatesRegistradosYaprobadosMenoresA10Dias.size(), asociacionSanMartin.ultimasMascotasEncontradas(10).size());
  }


  @Test
  public void elRepositorioAsociacionesEncuentraLaAsociacionMasCercanaAlRescateRegistradoEnSanMartin() {
    Assertions.assertEquals(asociacionSanMartin, repositorioAsociaciones.asociacionMasCercana(ubicacionSanMartin));
  }
}


