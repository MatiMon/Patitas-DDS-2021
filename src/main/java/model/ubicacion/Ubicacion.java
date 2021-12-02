package model.ubicacion;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Embeddable;

@Embeddable
public class Ubicacion {

  @JsonProperty("direccion")
  private String direccion;

  @JsonProperty("lat")
  private double latitud;

  @JsonProperty("long")
  private double longitud;

  public Ubicacion(String direccion, double unaLatitud, double unaLongitud) {
    this.direccion = direccion;
    latitud = unaLatitud;
    longitud = unaLongitud;
  }

  public Ubicacion() {

  }

  public double calcularDistancia(Ubicacion unaUbicacion) {
    return Math.ceil(calcularDistanciaEntreCoordenadas(unaUbicacion.getLatitud(), unaUbicacion.getLongitud()));
  }

  private double calcularDistanciaEntreCoordenadas(double latitudDestino, double longitudDestino) {
    double radioTierra = 6371;//en kilómetros

    return radioTierra * calculoAuxiliar2(latitudDestino, longitudDestino);
    //Se la conoce como: Fórmula de Haversine
  }

  private double calculoAuxiliar2(double latitudDestino, double longitudDestino) {
    double vAuxiliar1 = calculoAuxiliar1(latitudDestino, longitudDestino);

    return 2 * Math.atan2(Math.sqrt(vAuxiliar1), Math.sqrt(1 - vAuxiliar1));
  }

  private double calculoAuxiliar1(double latitudDestino, double longitudDestino) {
    double senoDiferenciaLat = senoDeDiferenciaDeMagnitudes(latitudDestino, this.latitud);
    double senoDiferenciaLong = senoDeDiferenciaDeMagnitudes(longitudDestino, this.longitud);

    return Math.pow(senoDiferenciaLat, 2) + Math.pow(senoDiferenciaLong, 2)
        * Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(latitudDestino));
  }

  private double diferenciaDeMagnitudes(double magnitud1, double magnitud2) {
    return Math.toRadians(magnitud1 - magnitud2);
  }

  private double senoDeDiferenciaDeMagnitudes(double magnitud1, double magnitud2) {
    return Math.sin(diferenciaDeMagnitudes(magnitud1, magnitud2) / 2);
  }

  public String getDireccion() {
    return this.direccion;
  }

  public double getLatitud() {
    return latitud;
  }

  public double getLongitud() {
    return longitud;
  }

  public boolean estaDentroDelRadio(Ubicacion ubicacion, double radio) {
    return calcularDistancia(ubicacion) <= radio;
  }
}
