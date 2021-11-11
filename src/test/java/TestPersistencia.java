import model.asociacion.Voluntario;
import model.caracteristicas.definidas.BooleanaDefinida;
import model.caracteristicas.definidas.CaracteristicaDefinida;
import model.caracteristicas.definidas.TextoDefinida;
import model.usuario.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestPersistencia extends AbstractPersistenceTest implements WithGlobalEntityManager {

  @BeforeEach
  public void antes() {
    this.beginTransaction();
  }

  @AfterEach
  public void despues() {
    this.commitTransaction();
  }

  @Test
  public void puedoPersistirValidaciones() {
    entityManager().persist(new ValidacionDeLongitud());
    entityManager().persist(new ValidacionDeCaracteresConsecutivos());

    assertEquals(2, entityManager().createQuery("from Validaciones", ValidacionDeContrasenia.class).getResultList().size());
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

  @Test
  public void puedoPersistirUsuarioAdmin() throws NoSuchAlgorithmException, InvalidKeySpecException {
    ValidacionDeCaracteresConsecutivos validacionDeCaracteresConsecutivos = new ValidacionDeCaracteresConsecutivos();
    List<ValidacionDeContrasenia> validaciones = new ArrayList<>();
    validaciones.add(validacionDeCaracteresConsecutivos);
    ValidadorContrasenia validadorContrasenia = new ValidadorContrasenia(validaciones);
    Usuario userAdmin = new Usuario("admin", "admin123456", validadorContrasenia);

    entityManager().persist(userAdmin);

    assertEquals(1, entityManager().createQuery("from Usuarios", Usuario.class).getResultList().size());
  }
}

