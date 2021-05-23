import caracteristicas.*;
import duenio.Contacto;
import duenio.Duenio;
import duenio.TipoDocumento;
import excepciones.MascotaInvalidaException;
import mascota.MascotaBuilder;
import mascota.Sexo;
import mascota.TipoAnimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMascotaBuilder {
  MascotaBuilder creadorMascota = new MascotaBuilder();
  List<String> fotos = new ArrayList<>();
  Booleana estaCastrada = new Booleana("Esta Castrada", false);
  List<String> opcionesComidaFavorita = new ArrayList<>();
  TextoDefinida jugueteFavorito = new TextoDefinida("Juguete Favorito", null);
  NumericoDefinida cantidadDePatas = new NumericoDefinida("Cantidad De Patas", 0);
  List<String> opcionesRaza = new ArrayList<>();
  RepositorioCaracteristicas repositorioCaracteristicas;

  @BeforeEach
  public void inicializarCreadorMascotas() {
    opcionesComidaFavorita.add("En lata");
    opcionesComidaFavorita.add("casera");
    opcionesComidaFavorita.add("deshidrata");
    EnumeradaIdeal comidaFavorita = new EnumeradaIdeal("Comida Favorita", opcionesComidaFavorita);
    opcionesComidaFavorita.add("Labrador");
    opcionesComidaFavorita.add("Ovejero Aleman");
    opcionesComidaFavorita.add("Siames");
    opcionesComidaFavorita.add("Caniche");
    EnumeradaIdeal raza = new EnumeradaIdeal("Raza", opcionesRaza);
    repositorioCaracteristicas = RepositorioCaracteristicas.getInstancia();
    repositorioCaracteristicas.agregarCaracteristicaObligatoria(estaCastrada);
    repositorioCaracteristicas.agregarCaracteristicaObligatoria(comidaFavorita);
    repositorioCaracteristicas.agregarCaracteristicaObligatoria(jugueteFavorito);
    repositorioCaracteristicas.agregarCaracteristicaObligatoria(cantidadDePatas);
    repositorioCaracteristicas.agregarCaracteristicaOpcional(raza);
    fotos.add("Foto1.jpg");
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
    Booleana estaCastradaDefinida = new Booleana("Esta Castrada", true);
    creadorMascota.agregarDefinidas(estaCastradaDefinida);

    Assertions.assertThrows(
        MascotaInvalidaException.class,
        () -> creadorMascota.registrarMascota()
    );
  }

  @Test
  public void sePuedeCrearUnaMascotaSinSusCaracteristicasOpcionales(){
    agregarDatosMascota();
    Booleana estaCastradaDefinida = new Booleana("Esta Castrada", true);
    creadorMascota.agregarDefinidas(estaCastradaDefinida);
    creadorMascota.agregarDefinidas(new TextoDefinida("Comida Favorita", null));
    creadorMascota.agregarDefinidas(jugueteFavorito);
    creadorMascota.agregarDefinidas(cantidadDePatas);
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
