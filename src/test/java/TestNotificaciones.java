import adopciones.PublicacionIntencionDeAdopcion;
import adopciones.PublicacionMascotaEnAdopcion;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    rescateDeMascotaSinRegistrar.setNumeroIdentificatorio(7);

    rescateDeMascotaSinRegistrar.notificarEncuentroAlRescatista();

    verify(medioDeNotificacion).enviarNotificacion(this.unContacto, "¡La mascota de la publicación 7 fue " +
        "encontrada por su dueño! Los datos del mismo son: Nombre completo: Matias Sosa - Contacto: null");
  }

  @Test
  public void RescateDeMascotaRegistradaNotificaEncuentroAlDuenio() {
    RescateDeMascotaRegistrada rescateDeMascotaRegistrada = new RescateDeMascotaRegistrada
        (fotos,null, null, unRescatista, null, unaMascota);

    rescateDeMascotaRegistrada.notificarEncuentroAlDuenio();

    verify(medioDeNotificacion).enviarNotificacion(this.unContacto, "¡Encontraron a Pepe! Podés contactar al " +
        "rescatista: Nombre completo: Jerónimo Fontana - Contacto: null");
  }

  @Test
  public void PublicacionIntencionNotificaEnviaLinkDeBaja() {
    PublicacionIntencionDeAdopcion publicacion = new PublicacionIntencionDeAdopcion(null,
        null, this.unDuenio, null, null, null,
        "https://host.com/publicaciones-de-intencion/8632432");

    publicacion.enviarLinkDeBaja();

    verify(medioDeNotificacion).enviarNotificacion(this.unContacto, "Se ha creado tu publicación, podés " +
        "darla de baja con el siguiente link: https://host.com/publicaciones-de-intencion/8632432");
  }

  @Test
  public void PublicacionIntencionDeAdopcionNotificaMascotasRecomendadas() {
    PublicacionIntencionDeAdopcion publicacion = new PublicacionIntencionDeAdopcion(null,
        null, this.unDuenio, null, null, null,
        "https://host.com/publicaciones-de-intencion/8632432");

    publicacion.recomendarMascotas("Mascotas recomendadas: ...");

    verify(medioDeNotificacion).enviarNotificacion(this.unContacto, "Mascotas recomendadas: ...");
  }

  @Test
  public void PublicacionMascotaEnAdopcionNotificaAlDuenioPosibleAdopcion() {
    PublicacionMascotaEnAdopcion publicacion = new PublicacionMascotaEnAdopcion(null, this.unaMascota);
    publicacion.setNumeroIdentificatorio("80");

    publicacion.notificarAlDuenioPosibleAdopcion();

    verify(medioDeNotificacion).enviarNotificacion(this.unContacto, "Se encontró un posible Adoptante para " +
        "tu mascota, siendo tu publiacion la número:80");
  }
}
