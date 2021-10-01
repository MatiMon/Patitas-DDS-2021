import asociacion.Voluntario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import usuario.ValidacionDeContrasenia;
import usuario.ValidacionDeLongitud;

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
  public void puedeRecuperarLugares() {
    entityManager().persist(new ValidacionDeLongitud());

    assertEquals(1, entityManager().createQuery("from validaciones", ValidacionDeContrasenia.class).getResultList().size());
  }

  @Test
  public void test() {
    Voluntario dani = new Voluntario();
    entityManager().persist(dani);

    assertNotNull(dani.getId());
  }
}

