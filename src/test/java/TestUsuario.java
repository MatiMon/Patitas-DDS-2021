import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usuario.ContraseniaHasheada;
import usuario.Usuario;
import usuario.ValidacionDeContrasenia;
import usuario.ValidadorContrasenia;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;


public class TestUsuario {

  @Test
  public void autorizarIngresoPorContraseniaCorrecta() throws NoSuchAlgorithmException, InvalidKeySpecException {
    List<ValidacionDeContrasenia> validaciones = new ArrayList<>();
    ValidadorContrasenia validador = new ValidadorContrasenia(validaciones);
    Usuario usuario = new Usuario("riquelme", "c0ntr4s3n14c0nmuchaseguridad!!?", validador);
    Assertions.assertTrue(usuario.autorizarContrasenia("c0ntr4s3n14c0nmuchaseguridad!!?"));
  }

  @Test
  public void denegarIngresoPorContraseniaIncorrecta() throws NoSuchAlgorithmException, InvalidKeySpecException {
    List<ValidacionDeContrasenia> validaciones = new ArrayList<>();
    ValidadorContrasenia validador = new ValidadorContrasenia(validaciones);
    Usuario usuario = new Usuario("riquelme", "c0ntr4s3n14c0nmuchaseguridad!!?", validador);
    Assertions.assertFalse(usuario.autorizarContrasenia("soyunhackermalvado"));
  }
}
