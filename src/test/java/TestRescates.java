import model.contacto.Contacto;
import model.duenio.Duenio;
import model.duenio.TipoDocumento;
import model.mascota.Mascota;
import model.mascota.Sexo;
import model.mascota.Tamanio;
import model.mascota.TipoAnimal;
import org.junit.jupiter.api.BeforeEach;
import model.rescate.RescateDeMascotaRegistrada;
import model.rescate.Rescatista;
import model.ubicacion.Ubicacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


public class TestRescates {
  private List<String> fotos;
  private Contacto unContacto;
  private List<Contacto> contactos;
  private Mascota unaMascota;

  private RescateDeMascotaRegistrada rescateDeMascotaRegistrada;
  private Duenio duenio;

  private Rescatista rescatista;


  @BeforeEach
    public void inicializar(){
      this.fotos = new ArrayList<>();
      this.fotos.add("Foto en el parque");

      this.contactos = new ArrayList<>();
      this.unContacto = new Contacto("Juan", "Pérez", 1153798990, "juan.perez@hotmail.com");
      this.contactos.add(unContacto);

      this.unaMascota = new Mascota("Perrito", "Perry",
          3, Sexo.MACHO, TipoAnimal.PERRO, "Cachorro", this.fotos, null, this.duenio, "12345A", Tamanio.MEDIANO);

      this.rescateDeMascotaRegistrada = new RescateDeMascotaRegistrada(this.fotos, "Una descipción", new Ubicacion(), this.rescatista, null, unaMascota);

      this.duenio = new Duenio("Matias", "Sosa", null, TipoDocumento.DNI, 40000000, this.unContacto,null);

      this.rescatista = new Rescatista("Manuel", "Quintana", null, null, null, this.unContacto);



      /*Mascota model.mascota = new Mascota("a", "b", 1, Sexo.MACHO, )
      fotos.add("una foto");
      Rescatista rescatista = new Rescatista("nombre", "apodo", LocalDate.of(2021,12,12), TipoDocumento.DNI, "callefalsa123", contactos);
      RescateDeMascota mascota1 = new RescateDeMascota(fotos, "descripcion", "model.ubicacion", rescatista, LocalDateTime.now());
      RescateDeMascota mascota2 = new RescateDeMascota(fotos, "descripcion", "model.ubicacion", rescatista, LocalDateTime.now().minusDays(10));
      RescateDeMascota mascota3 = new RescateDeMascota(fotos, "descripcion", "model.ubicacion", rescatista, LocalDateTime.now().minusDays(15));
      registroDeRescates.agregarRescateMascota(mascota1);
      registroDeRescates.agregarRescateMascota(mascota2);
      registroDeRescates.agregarRescateMascota(mascota3);*/
    }

  /*
  @Test
  public void sePuedeEnviarNotificacionDeEncuentroAlDueño(){

    this.rescateDeMascotaRegistrada.notificarEncuentroAlDuenio();
  }
   */
}
