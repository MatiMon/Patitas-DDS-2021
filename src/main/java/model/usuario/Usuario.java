package model.usuario;

import model.excepciones.ContraseniaInvalidaException;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

@Entity(name = "Usuarios")
@Table(name = "Usuario")
public class Usuario {

  @Id @GeneratedValue
  private Long id;

  private String nombreUsuario;

  @Embedded
  private ContraseniaHasheada contrasenia;

  @Transient
  private ValidadorContrasenia validador;

  public Usuario(String nombreUsuario, String contrasenia, ValidadorContrasenia validador) throws NoSuchAlgorithmException, InvalidKeySpecException {
    this.nombreUsuario = Objects.requireNonNull(nombreUsuario, "Debe introducir un nombre de model.usuario");
    Objects.requireNonNull(contrasenia, "Debe introducir una contrasenia");

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
