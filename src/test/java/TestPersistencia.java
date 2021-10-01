import asociacion.Voluntario;
import caracteristicas.definidas.BooleanaDefinida;
import caracteristicas.definidas.CaracteristicaDefinida;
import caracteristicas.definidas.TextoDefinida;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import usuario.ValidacionDeContrasenia;
import usuario.ValidacionDeLongitud;

import java.util.List;

import static org.junit.Assert.*;

public class TestPersistencia extends AbstractPersistenceTest implements WithGlobalEntityManager {

  @BeforeEach
  public void antes() {
    this.beginTransaction();
  }

  @AfterEach
  public void despues() {
    this.rollbackTransaction();
  }

  @Test
  public void puedoPersistirValidaciones() {
    entityManager().persist(new ValidacionDeLongitud());

    assertEquals(1, entityManager().createQuery("from Validaciones", ValidacionDeContrasenia.class).getResultList().size());
  }

  @Test
  public void persistirVoluntario() {
    Voluntario dani = new Voluntario();
    entityManager().persist(dani);

    assertNotNull(dani.getId());
  }

  @Test
  public void puedoGuardarDistintosTiposCaracteristicasDefinidas() {
    BooleanaDefinida estaCastrado = new BooleanaDefinida("Esta castrado", true);
    TextoDefinida jugueteFavorito = new TextoDefinida("Juguete Favorito", "Pelota");

    entityManager().persist(estaCastrado);
    entityManager().persist(jugueteFavorito);

    List<CaracteristicaDefinida> caracteristicasPersistidas;
    caracteristicasPersistidas = entityManager()
        .createQuery("from CaracteristicasDefinidas", CaracteristicaDefinida.class)
        .getResultList();

    assertEquals(caracteristicasPersistidas.get(0).getId(), estaCastrado.getId());
    assertEquals(caracteristicasPersistidas.get(1).getId(), jugueteFavorito.getId());

  }
}

