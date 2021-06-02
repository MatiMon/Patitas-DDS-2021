import duenio.Contacto;
import duenio.Duenio;
import duenio.TipoDocumento;
import excepciones.MascotaInvalidaException;
import mascota.MascotaBuilder;
import caracteristicas.*;
import mascota.Sexo;
import mascota.TipoAnimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMascotaBuilder {
  MascotaBuilder creadorMascota = new MascotaBuilder();
  List<String> fotos = Arrays.asList("Foto1.jpg", "Foto2.jpg");
  CaracteristicaIdeal estaCastrada = new CaracteristicaIdeal("Esta Castrada", true, new BooleanaIdeal());
  CaracteristicaIdeal comidaFavorita = new CaracteristicaIdeal("Comida Favorita",
      true, new EnumeradaIdeal(Arrays.asList("En lata", "Casera", "Deshidratada")));
  CaracteristicaIdeal jugueteFavorito = new CaracteristicaIdeal("Juguete Favorito", true, new TextoIdeal());
  CaracteristicaIdeal cantidadDePatas = new CaracteristicaIdeal("Cantidad De Patas", false, new NumericaIdeal());


  @BeforeEach
  public void inicializarRepoMascotas() {
    RepositorioCaracteristicasIdeales repoCaracteristicasIdeales = RepositorioCaracteristicasIdeales.getInstancia();
    repoCaracteristicasIdeales.agregarCaracteristicaIdeal(comidaFavorita);
    repoCaracteristicasIdeales.agregarCaracteristicaIdeal(jugueteFavorito);
    repoCaracteristicasIdeales.agregarCaracteristicaIdeal(estaCastrada);
    repoCaracteristicasIdeales.agregarCaracteristicaIdeal(cantidadDePatas);
  }

  @Test
  public void noSePuedeRegistrarUnaMascotaVacia() {
    Assertions.assertThrows(
        NullPointerException.class,
        () -> creadorMascota.registrarMascota()
    );
  }

  @Test
  public void noSePuedeCrearUnaMascotaSinTodasSusCaracteristicasObligatorias(){
    agregarDatosMascota();
    creadorMascota.ingresarNuevaCaracteristica(estaCastrada, true);

    Assertions.assertThrows(
        MascotaInvalidaException.class,
        () -> creadorMascota.registrarMascota()
    );
  }

  @Test
  public void sePuedeCrearUnaMascotaSinSusCaracteristicasOpcionales(){
    agregarDatosMascota();
    creadorMascota.ingresarNuevaCaracteristica(estaCastrada, true);
    creadorMascota.ingresarNuevaCaracteristica(jugueteFavorito, "Pelota");
    creadorMascota.ingresarNuevaCaracteristica(comidaFavorita, "Casera");

    Assertions.assertDoesNotThrow(
        () -> creadorMascota.registrarMascota()
    );
  }

  private void agregarDatosMascota(){
    creadorMascota.setApodo("Tiff");
    creadorMascota.setNombre("Tiffany");
    creadorMascota.setDescripcionFisica("Lindo (?");
    creadorMascota.setEdad(4);
    creadorMascota.setSexo(Sexo.HEMBRA);
    creadorMascota.setTipoAnimal(TipoAnimal.GATO);
    creadorMascota.setFotos(fotos);
    Contacto contacto = new Contacto("nombre", "apellido", 1234, "nombre@hotmail.com");
    List<Contacto> contactos = new ArrayList<>();
    contactos.add(contacto);
    Duenio duenio = new Duenio("Nombre falso", "sanchez", LocalDate.now(), TipoDocumento.DNI, 1254589, contactos);
    creadorMascota.setDuenio(duenio);
  }

}

