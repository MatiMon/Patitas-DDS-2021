import duenio.Contacto;
import duenio.TipoDocumento;
import mascota.Mascota;
import mascota.Sexo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rescate.RescateDeMascota;
import rescate.RegistroDeRescates;
import rescate.Rescatista;

import javax.crypto.Mac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TestRescates {
  List<String> fotos = new ArrayList<>();
  Contacto contacto = new Contacto("nombre", "apellido", 1234, "nombre@hotmail.com");
  List<Contacto> contactos = new ArrayList<>();
  RegistroDeRescates registroDeRescates = new RegistroDeRescates();


    @BeforeEach
    public void inicializar(){
      /*Mascota mascota = new Mascota("a", "b", 1, Sexo.MACHO, )
      contactos.add(contacto);
      fotos.add("una foto");
      Rescatista rescatista = new Rescatista("nombre", "apodo", LocalDate.of(2021,12,12), TipoDocumento.DNI, "callefalsa123", contactos);
      RescateDeMascota mascota1 = new RescateDeMascota(fotos, "descripcion", "ubicacion", rescatista, LocalDateTime.now());
      RescateDeMascota mascota2 = new RescateDeMascota(fotos, "descripcion", "ubicacion", rescatista, LocalDateTime.now().minusDays(10));
      RescateDeMascota mascota3 = new RescateDeMascota(fotos, "descripcion", "ubicacion", rescatista, LocalDateTime.now().minusDays(15));
      registroDeRescates.agregarRescateMascota(mascota1);
      registroDeRescates.agregarRescateMascota(mascota2);
      registroDeRescates.agregarRescateMascota(mascota3);*/
    }


  @Test
  public void lasMascotasRescatadasSonDeDiezDiasEnAdelante(){
    assertEquals(registroDeRescates.ultimasMascotasEncontradas(10).size(), 2);
  }
}
