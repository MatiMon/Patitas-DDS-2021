import asociacion.Voluntario;
import org.junit.jupiter.api.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import usuario.ValidacionDeContrasenia;
import usuario.ValidacionDeLongitud;

import static org.junit.Assert.*;

public class Persistencia extends AbstractPersistenceTest implements WithGlobalEntityManager {

  @org.junit.Test
    public void puedeRecuperarLugares() {
      entityManager().persist(new ValidacionDeLongitud());

      assertEquals(1, entityManager().createQuery("from validaciones", ValidacionDeContrasenia.class).getResultList().size());
    }

  @org.junit.Test
  public void test() {
    Voluntario dani = new Voluntario();
    entityManager().persist(dani);

    assertNotNull(dani.getId());
  }
  }

