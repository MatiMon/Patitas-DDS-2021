package model.usuario;

import model.excepciones.ValidadorContraseniaInvalidoException;

import java.util.List;
import java.util.Objects;

public class ValidadorContrasenia {
  private List<ValidacionDeContrasenia> validaciones;

  public ValidadorContrasenia(List<ValidacionDeContrasenia> validaciones) {
    Objects.requireNonNull(validaciones, "Debe ingresar al menos una validacion");
    if (validaciones.size() == 0) {//isEmpty()
      throw new ValidadorContraseniaInvalidoException("debe incluir al menos una validacion de seguridad");
    }
    this.validaciones = validaciones;
  }

  public boolean validarLasContrasenias(String contrasenia) {
    return this.validaciones.stream().allMatch(validacionDeContrasenia -> validacionDeContrasenia.esContraseniaValida(contrasenia));
  }

}
