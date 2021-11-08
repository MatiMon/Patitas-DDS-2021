package model.contacto;

public interface MedioDeNotificacion {
  void enviarNotificacion(Contacto contacto, String mensaje);
  String obtenerDatoDeContacto();
}
