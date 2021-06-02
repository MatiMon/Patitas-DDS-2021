package ubicacion;

public class Ubicacion {
  private String calle;
  private int altura;
  private double latitud;
  private double longitud;

  public Ubicacion(String unaCalle,int unaAltura,double unaLatitud,double unaLongitud){
    calle = unaCalle;
    altura = unaAltura;
    latitud = unaLatitud;
    longitud = unaLongitud;
  }

  public double calcularDistancia(Ubicacion unaUbicacion){
    return calcularDistanciaEntreCoordenadas(unaUbicacion.getLatitud(),unaUbicacion.getLongitud());
  }

  private double calcularDistanciaEntreCoordenadas(double latitudDestino,double longitudDestino){
    double radioTierra = 6371;//en kilómetros
    double diferenciaLatitudes = Math.toRadians(latitudDestino - this.latitud);
    double diferenciaLongitudes = Math.toRadians(longitudDestino - this.longitud);
    double senoDiferenciaLat = Math.sin(diferenciaLatitudes / 2);
    double senoDiferenciaLong = Math.sin(diferenciaLongitudes / 2);
    double vAuxiliar1 = Math.pow(senoDiferenciaLat, 2) + Math.pow(senoDiferenciaLong, 2)
        * Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(latitudDestino));
    double vAuxiliar2 = 2 * Math.atan2(Math.sqrt(vAuxiliar1), Math.sqrt(1 - vAuxiliar1));

    return radioTierra * vAuxiliar2; //Se la conoce como: Fórmula de Haversine
  }

  public String getCalle() {
    return calle;
  }

  public int getAltura() {
    return altura;
  }

  public double getLatitud() {
    return latitud;
  }

  public double getLongitud() {
    return longitud;
  }
}
