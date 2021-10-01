package db;

import asociacion.Voluntario;
import org.junit.jupiter.api.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import usuario.ValidacionDeContrasenia;
import usuario.ValidacionDeLongitud;
import usuario.ValidacionPorArchivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersistenciaTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

/*  @Test
  public void puedePersistirUnaValidacion() {
    entityManager().persist(new ValidacionDeLongitud());
  }


  @Test
  public void prueba() {

    Voluntario voluntario = new Voluntario();
    entityManager().persist(voluntario);

    assertNotNull(voluntario.getId());

   // assertEquals(1, entityManager().createQuery("from validaciones", ValidacionDeContrasenia.class).getResultList().size());
  }*/
}
