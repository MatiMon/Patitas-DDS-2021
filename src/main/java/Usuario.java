public abstract class Usuario {
  String nombreUsuario;
  String contraseña;
  ValidadorPasswords validador;

  public Usuario(String nombreUsuario, String contraseña, ValidadorPasswords validador) {
    this.nombreUsuario = nombreUsuario;
    this.contraseña = contraseña;
    this.validador = validador;
  }

  public void autorizarContraseña(String contraseña){
    this.validador.validarPassword(contraseña);
  }

  public void actualizarContraseña(String contraseña){
    //pisar una con la otra
  }
}
