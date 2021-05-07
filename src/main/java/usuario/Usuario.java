package usuario;

import excepciones.ContraseniaInvalidaException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

public class Usuario {
  String nombreUsuario;
  ContraseniaHasheada contrasenia;
  ValidadorContrasenia validador;

  public Usuario(String nombreUsuario, String contrasenia, ValidadorContrasenia validador) throws NoSuchAlgorithmException, InvalidKeySpecException {
    this.nombreUsuario = Objects.requireNonNull(nombreUsuario, "Debe introducir un nombre de usuario");
    Objects.requireNonNull(contrasenia, "debe introducir una contrasenia");

    this.validador = validador;
    if (!validador.validarLasContrasenias(contrasenia)) {
      throw new ContraseniaInvalidaException(" la contrasenia no cumple los requerimientos minimos de seguridad");
    }

    this.contrasenia = new ContraseniaHasheada(contrasenia);

  }

  //Autoriza el ingreso si la contrasenia ingresada es la correcta
  public boolean autorizarContrasenia(String contrasenia) throws NoSuchAlgorithmException, InvalidKeySpecException {
    return this.contrasenia.hashMatch(contrasenia);
  }

  public void actualizarContrasenia(String contrasenia) throws NoSuchAlgorithmException, InvalidKeySpecException {
    if (!validador.validarLasContrasenias(contrasenia)) {
      throw new ContraseniaInvalidaException(" la contrasenia no cumple los requerimientos minimos de seguridad");
    }
    this.contrasenia = new ContraseniaHasheada(contrasenia);
  }
}
