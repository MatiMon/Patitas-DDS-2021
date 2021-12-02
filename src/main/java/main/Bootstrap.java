package main;

import model.contacto.Contacto;
import model.duenio.Duenio;
import model.duenio.TipoDocumento;
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
import java.time.LocalDate;
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


/*    Asociacion patitasAlRescate = new Asociacion("Patitas al rescate", new Ubicacion("String", 123, 456),
        new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    entityManager().persist(patitasAlRescate);


    Mascota mascota = new Mascota("Pepita", "Pepin", 15, Sexo.HEMBRA, TipoAnimal.GATO,
        null, new ArrayList<>(), new ArrayList<>(), null, "123", Tamanio.GRANDE);
    entityManager().persist(mascota);*/

    //admin
    persistAdmin("admin", "admin123456");
  }

  public void persistAdmin(String user, String pass){
    ValidacionDeCaracteresConsecutivos validacionDeCaracteresConsecutivos = new ValidacionDeCaracteresConsecutivos();
    List<ValidacionDeContrasenia> validaciones = new ArrayList<>();
    validaciones.add(validacionDeCaracteresConsecutivos);
    ValidadorContrasenia validadorContrasenia = new ValidadorContrasenia(validaciones);
    Usuario userAdmin = null;
    try{
      userAdmin = new Usuario(user, pass, validadorContrasenia);
    }catch(Exception e){
      //...
    }

    userAdmin.setEsAdministrador(true);

    Contacto contactoPrincipal = new Contacto("al", "go", "1234", "algo@gmail");
    Ubicacion ubicacion = new Ubicacion("String", 123, 456);
    Duenio duenio = new Duenio("Nombre falso", "sanchez", LocalDate.now(), TipoDocumento.DNI, 1254589, contactoPrincipal, ubicacion, userAdmin);

    entityManager().persist(userAdmin);
    entityManager().persist(contactoPrincipal);
    entityManager().persist(duenio);
  }


}