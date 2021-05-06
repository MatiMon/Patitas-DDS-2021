package usuario;

import java.util.ArrayList;
import java.util.List;

public class ValidadorContrasenia {
  List<ValidacionDeContrasenia> validaciones = new ArrayList<>();

  public ValidadorContrasenia(List<ValidacionDeContrasenia> validaciones) {
    this.validaciones = validaciones;
  }

  public boolean validarContrasenia(String contrasenia){
    return validaciones.stream().allMatch(validacionDeContrasenia -> validarContrasenia(contrasenia));
  }

  public void agregarValidacion(ValidacionDeContrasenia validacion){
    this.validaciones.add(validacion);
  }

}
