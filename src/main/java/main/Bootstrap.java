package main;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import model.asociacion.Asociacion;
import model.mascota.Mascota;
import model.mascota.Sexo;
import model.mascota.Tamanio;
import model.mascota.TipoAnimal;
import model.ubicacion.Ubicacion;
import model.usuario.Usuario;
import model.usuario.ValidacionDeCaracteresConsecutivos;
import model.usuario.ValidacionDeContrasenia;
import model.usuario.ValidadorContrasenia;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejecutar antes de levantar el servidor por primera vez
 *
 * @author flbulgarelli
 */
public class Bootstrap implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps {

  public static void main(String[] args) {
    new Bootstrap().run();
  }

  public void run() {


    Asociacion patitasAlRescate = new Asociacion("Patitas al rescate", new Ubicacion("String", 123, 456),
        new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    entityManager().persist(patitasAlRescate);


    Mascota mascota = new Mascota("Pepita", "Pepin", 15, Sexo.HEMBRA, TipoAnimal.GATO,
        null, new ArrayList<>(), new ArrayList<>(), null, "123", Tamanio.GRANDE);
    entityManager().persist(mascota);

  }

}