package main;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import model.asociacion.Asociacion;
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

    }

}