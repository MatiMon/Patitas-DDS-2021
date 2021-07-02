import contacto.Contacto;
import contacto.MedioDeNotificacion;
import duenio.Duenio;
import duenio.TipoDocumento;
import mascota.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rescate.RescateDeMascotaRegistrada;
import rescate.RescateDeMascotaSinRegistrar;
import rescate.Rescatista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TestNotificaciones {
  private MedioDeNotificacion medioDeNotificacion;
  private List<String> fotos;
  private Duenio unDuenio;
  private Contacto unContacto;
  private Rescatista unRescatista;
  private Mascota unaMascota;

  @BeforeEach
  public void inicializar() {
    this.medioDeNotificacion = mock(MedioDeNotificacion.class);

    this.fotos = new ArrayList<>();
    fotos.add("Una foto");

    this.unContacto = new Contacto("Juan", "Perez", 1550123456, "juanperez@hotmail.com");
    unContacto.setMedioDeNotificacionPreferido(medioDeNotificacion);

    this.unDuenio = new Duenio("Matias", "Sosa", null, TipoDocumento.DNI, 40000000, this.unContacto,null);

    this.unRescatista = new Rescatista("Jerónimo", "Fontana", null, null, null, this.unContacto);

    this.unaMascota = new Mascota("Pepe", null, 4, Sexo.MACHO, TipoAnimal.GATO,
        "facha", Arrays.asList("foto1.jpg"), null, this.unDuenio, "QR-1", Tamanio.GRANDE);
  }

  @Test
  public void RescateDeMascotaSinRegistrarNotificaEncuentroAlRescatista() {
    RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar = new RescateDeMascotaSinRegistrar
        (this.fotos,null,        null, this.unRescatista, null,
            Tamanio.GRANDE, TipoAnimal.PERRO, null, this.unDuenio);
    rescateDeMascotaSinRegistrar.setNumeroIdentificatorio(007);

    rescateDeMascotaSinRegistrar.notificarEncuentroAlRescatista();
  }

  @Test
  public void RescateDeMascotaRegistradaNotificaEncuentroAlDuenio() {
    RescateDeMascotaRegistrada rescateDeMascotaRegistrada = new RescateDeMascotaRegistrada
        (fotos,null, null, unRescatista, null, unaMascota);

    rescateDeMascotaRegistrada.notificarEncuentroAlDuenio();
  }

  @Test
  public void PublicacionIntencionNotificaEnviaLinkDeBaja() {
    PublicacionIntencionDeAdopcion publicacion = new PublicacionIntencionDeAdopcion(null,
        null, this.unDuenio, null, null, null,
        "https://host.com/publicaciones-de-intencion/8632432");

    publicacion.enviarLinkDeBaja();
  }

  @Test
  public void PublicacionIntencionDeAdopcionNotificaMascotasRecomendadas() {
    PublicacionIntencionDeAdopcion publicacion = new PublicacionIntencionDeAdopcion(null,
        null, this.unDuenio, null, null, null,
        "https://host.com/publicaciones-de-intencion/8632432");

    publicacion.recomendarMascotas("Mascotas recomendadas: ...");
  }

  @Test
  public void PublicacionMascotaEnAdopcionNotificaAlDuenioPosibleAdopcion() {
    PublicacionMascotaEnAdopcion publicacion = new PublicacionMascotaEnAdopcion(null, this.unaMascota);
    publicacion.setNumeroIdentificatorio("80");
    publicacion.notificarAlDuenioPosibleAdopcion();
  }
}
