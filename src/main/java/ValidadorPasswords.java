import java.util.ArrayList;
import java.util.List;

public class ValidadorPasswords {
  List<ValidacionDePasswords> validaciones = new ArrayList<>();

  public ValidadorPasswords(List<ValidacionDePasswords> validaciones) {
    this.validaciones = validaciones;
  }

  public boolean validarPassword(String password){
    //aplicar todas las validaciones de la lista validaciones
    return true;
  }

  public void agregarValidacion(ValidacionDePasswords validacion){
    this.validaciones.add(validacion);
  }

}
