package usuario;

import excepciones.ValidadorContraseniaInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidadorContrasenia {
  List<ValidacionDeContrasenia> validaciones = new ArrayList<>();

  public ValidadorContrasenia(List<ValidacionDeContrasenia> validaciones) {
    Objects.requireNonNull(validaciones, "Debe ingresar al menos una validacion");
    if (validaciones.size() == 0){
      //throw new ValidadorContraseniaInvalidoException("debe incluir al menos una validacion de seguridad");
      this.validaciones = validaciones;
    } else
    this.validaciones = validaciones;
  }

  public boolean validarContrasenia(String contrasenia){
  return validaciones.stream().allMatch(validacionDeContrasenia -> validarContrasenia(contrasenia));
  }

  public void agregarValidacion(ValidacionDeContrasenia validacion){
    this.validaciones.add(validacion);
  }

}
