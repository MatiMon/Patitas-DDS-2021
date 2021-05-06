import java.util.ArrayList;
import java.util.List;

public class ValidadorContrasenia {
  List<ValidacionDeContrasenia> validaciones = new ArrayList<>();

  public ValidadorContrasenia(List<ValidacionDeContrasenia> validaciones) {
    this.validaciones = validaciones;
  }

  public boolean validarPassword(String password){
    //aplicar todas las validaciones de la lista validaciones
    return true;
  }

  public void agregarValidacion(ValidacionDeContrasenia validacion){
    this.validaciones.add(validacion);
  }

}
