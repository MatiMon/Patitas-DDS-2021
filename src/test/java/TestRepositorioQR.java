import caracteristicas.CaracteristicaDefinida;
import caracteristicas.CaracteristicaIdeal;
import caracteristicas.NumericaIdeal;
import contacto.Contacto;
import duenio.Duenio;
import duenio.TipoDocumento;
import mascota.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestRepositorioQR {
  private RepositorioMascotas repositorioDeQRs;
  private List<String> fotos = new ArrayList<>();
  private Contacto contacto1 = new Contacto("Juan", "Perez", 15501234, "juanperez@hotmail.com");
  private List<Contacto> contactos = new ArrayList<Contacto>();
  private List<CaracteristicaDefinida> caracteristicas = new ArrayList<>();
  private CaracteristicaIdeal caracteristica = new CaracteristicaIdeal("Edad", true, new NumericaIdeal());
  private LocalDate fecha = LocalDate.parse("2018-10-30");
  Duenio unDuenio = new Duenio("Juan",
      "Perez",
      fecha,
      TipoDocumento.DNI,
      999999,
      null,
          null);
  Mascota mascota1 = new Mascota("Toto", "Toto", 10,
      Sexo.MACHO, TipoAnimal.PERRO, "perro grande", fotos,
      caracteristicas, unDuenio, "qr-10", Tamanio.GRANDE
  );


  @BeforeEach
  void iniciarRepositorio() {
    CaracteristicaDefinida caracteristicaDefinida = caracteristica.crearCaracteristica(10);
    caracteristicas.add(caracteristicaDefinida);
    contactos.add(contacto1);
    fotos.add("foto1");

    repositorioDeQRs.getInstancia().registrarMascota("qr-10", mascota1);
  }

  @AfterEach
  void vaciarRepositorio() {
    repositorioDeQRs.getInstancia().removerMascota("qr-10");
  }

  @Test
  void sePuedeObtenerLaMascotaATravesDelQR() {
    CaracteristicaDefinida caracteristicaDefinida = caracteristica.crearCaracteristica(10);
    caracteristicas.add(caracteristicaDefinida);
    contactos.add(contacto1);
    fotos.add("foto1");

    Mascota mascotaSegunQR = repositorioDeQRs.getInstancia().obtenerMascota("qr-10");
    Assertions.assertEquals(mascota1, mascotaSegunQR);
  }

}
