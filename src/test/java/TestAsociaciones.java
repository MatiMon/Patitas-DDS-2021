import model.adopciones.PublicacionIntencionDeAdopcion;
import model.adopciones.PublicacionMascotaEnAdopcion;
import model.asociacion.Asociacion;
import model.caracteristicas.definidas.CaracteristicaDefinida;
import model.caracteristicas.ComodidadIdeal;
import model.caracteristicas.definidas.TextoDefinida;
import model.contacto.Contacto;
import model.duenio.Duenio;
import model.duenio.TipoDocumento;
import model.mascota.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.rescate.Rescatista;
import model.rescate.RescateDeMascota;
import model.rescate.RescateDeMascotaRegistrada;
import model.rescate.RescateDeMascotaSinRegistrar;
import model.ubicacion.Ubicacion;
import model.asociacion.RepositorioAsociaciones;


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
  List<PublicacionMascotaEnAdopcion> mascotasEnAdopcionSM = new ArrayList<>();
  List<PublicacionIntencionDeAdopcion> intencionesDeAdoptarSM = new ArrayList<>();
  List<PublicacionMascotaEnAdopcion> mascotasEnAdopcionLejana = new ArrayList<>();
  List<PublicacionIntencionDeAdopcion> intencionesDeAdoptarLejana = new ArrayList<>();

  private Contacto contacto1;
  Rescatista rescatista;
  private Contacto contacto2;
  private List<Contacto> contactos = new ArrayList<>();
  Asociacion asociacionSanMartin = new Asociacion("Patitas", new Ubicacion("San Martin 155",-34.59000,-58.50000 ), rescatesDeMascotasSinRegistrar, rescatesDeMascotasRegistradas, mascotasEnAdopcionSM, intencionesDeAdoptarSM);
  Asociacion asociacionLejana = new Asociacion("Manchitas",new Ubicacion("lugarLejano",35.86166,104.195397), null,null, mascotasEnAdopcionLejana, intencionesDeAdoptarLejana);
  Mascota mascota = new Mascota("Pepito", "Pepe", 4, Sexo.MACHO, TipoAnimal.GATO, "lindo", Arrays.asList("foto1.jpg"), null, null, "QR-1", Tamanio.GRANDE);
  RepositorioMascotas repositorioMascotas;
  CaracteristicaDefinida personalidad = new TextoDefinida("personalidad", "Manso");

  private Duenio duenio;
  //@TODO ver de acomodar, asi no lo dejo en null y puedo probar más cosas
  private List<ComodidadIdeal> comodidades = new ArrayList<>();
  private ComodidadIdeal comodidadIdeal;

  @BeforeEach
  void init() {
    repositorioMascotas = RepositorioMascotas.getInstancia();
    repositorioMascotas.registrarMascota("QR-1", mascota);
    contacto2 = new Contacto("nombre", "apellido", "1234", "nombre@hotmail.com");
    fotos.add("una foto");
    contacto1 = new Contacto("Juan", "Perez", "15501234", "juanperez@hotmail.com");
    rescatista = new Rescatista("nombre", "apodo", LocalDate.of(2021,12,12), TipoDocumento.DNI, "callefalsa123", contacto1);
    ubicacionSanMartin = new Ubicacion("San Martín 150", -34.58499, -58.45023);
    ubicacionGuardiaVieja = new Ubicacion("Guardia Vieja 2077", -34.58499, -58.45023);
    contactos.add(contacto1);
    this.duenio = new Duenio("Matias", "Sosa", null, TipoDocumento.DNI, 40000000, contacto1,null, null);


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
    rescatesDeMascotasRegistradas.remove(rescateDeMascotaSinRegistrar1);
    rescatesDeMascotasRegistradas.remove(rescateDeMascotaSinRegistrar2);
    rescatesDeMascotasRegistradas.remove(rescateDeMascotaSinRegistrar3);

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

  @Test
  public void aprueboDosPublicacionesDeSanMartin() {
    rescateDeMascotaSinRegistrar1.aprobarPublicacion();
    rescateDeMascotaSinRegistrar2.aprobarPublicacion();
    Assertions.assertEquals(asociacionSanMartin.obtenerPublicacionesAprobadas().size(), 2);
  }

  @Test
  public void aprueboDosPublicacionesDeSanMartinYQuieroObtenerLasNoAprobadas() {
    rescateDeMascotaSinRegistrar1.aprobarPublicacion();
    rescateDeMascotaSinRegistrar2.aprobarPublicacion();
    Assertions.assertEquals(asociacionSanMartin.obtenerPublicacionesSinAprobar().size(), 1);
  }

  @Test
  public void repoAsociacionesObtieneDosMascotasEnAdopcionYUnaIntencionDeAdoptar() {
    PublicacionMascotaEnAdopcion publicacion1 = new PublicacionMascotaEnAdopcion(null,null);
    asociacionSanMartin.agregarMascotaEnAdopcion(publicacion1);
    PublicacionMascotaEnAdopcion publicacion2 = new PublicacionMascotaEnAdopcion(null,null);
    asociacionSanMartin.agregarMascotaEnAdopcion(publicacion2);
    PublicacionIntencionDeAdopcion publicacion3 = new PublicacionIntencionDeAdopcion(null, null, null , TipoAnimal.PERRO, Sexo.HEMBRA, Tamanio.MEDIANO, null);
    asociacionSanMartin.agregarIntencionDeAdopcion(publicacion3);

    Assertions.assertEquals(repositorioAsociaciones.publicacionesIntencionDeAdopcion().size(), 1);
    Assertions.assertEquals(repositorioAsociaciones.publicacionesMascotasEnAdopcion().size(), 2);
  }
}


