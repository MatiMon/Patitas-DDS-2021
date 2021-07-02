import contacto.Contacto;
import contacto.MedioDeNotificacion;
import duenio.Duenio;
import duenio.TipoDocumento;
import mascota.Tamanio;
import mascota.TipoAnimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rescate.RescateDeMascotaSinRegistrar;
import rescate.Rescatista;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TestNotificaciones {
  private MedioDeNotificacion medioDeNotificacion;
  private List<String> fotos;
  private Duenio unDuenio;
  private Contacto unContacto;
  private Rescatista unRescatista;

  @BeforeEach
  public void inicializar() {
    this.medioDeNotificacion = mock(MedioDeNotificacion.class);

    this.fotos = new ArrayList<>();
    fotos.add("Una foto");

    this.unContacto = new Contacto("Juan", "Perez", 1550123456, "juanperez@hotmail.com");
    unContacto.setMedioDeNotificacionPreferido(medioDeNotificacion);

    this.unDuenio = new Duenio("Matias", "Sosa", null, TipoDocumento.DNI, 40000000, this.unContacto,null);

    this.unRescatista = new Rescatista("Jerónimo", "Fontana", null, null, null, unContacto);
  }

  @Test
  public void RescateDeMascotaSinRegistrarNotificaEncuentroAlRescatista() {
    RescateDeMascotaSinRegistrar rescateDeMascotaSinRegistrar = new RescateDeMascotaSinRegistrar
        (this.fotos,null,        null, unRescatista, null,
            Tamanio.GRANDE, TipoAnimal.PERRO, null, this.unDuenio);
    rescateDeMascotaSinRegistrar.setNumeroIdentificatorio(007);

    rescateDeMascotaSinRegistrar.notificarEncuentroAlRescatista();

  }
}
