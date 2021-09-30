package adopciones;

import caracteristicas.definidas.CaracteristicaDefinida;
import mascota.Mascota;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
public class PublicacionMascotaEnAdopcion {
  @Id
  @GeneratedValue
  private Long id;

  public String getNumeroPublicacion() {
    return numeroPublicacion;
  }

  private String numeroPublicacion;

  @OneToMany
  @JoinColumn(name = "publicacionMascotaEnAdopcionId", referencedColumnName = "id")
  private List<CaracteristicaDefinida> comodidades;

  @OneToOne
  @JoinColumn(name = "mascotaId", referencedColumnName = "id")
  private Mascota mascota;


  public PublicacionMascotaEnAdopcion(List<CaracteristicaDefinida> comodidades,Mascota mascota) {
    this.mascota = mascota;
    this.comodidades = comodidades;
  }
  //Si algo es null lo tomamos como compatible
  public boolean esCompatible(PublicacionIntencionDeAdopcion intencionDeAdopcion) {
    return comodidadesCompatibles(intencionDeAdopcion) && caracteristicasPersonalizadasCompatibles(intencionDeAdopcion) && caracteristicasBasicasCompatibles(intencionDeAdopcion);
  }

  private boolean comodidadesCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion){
    return Objects.isNull(comodidades) || comodidades.stream().allMatch(comodidad -> comodidad.esCompatibleCon(intencionDeAdopcion.valorComodidad(comodidad.getNombre())));
  }

  private boolean caracteristicasPersonalizadasCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion){
    List<CaracteristicaDefinida> caracteristicas = mascota.getCaracteristicaDefinidas();
    return Objects.isNull(caracteristicas) || caracteristicas.stream().allMatch(caracteristica -> caracteristica.esCompatibleCon(intencionDeAdopcion.valorCaracteristica(caracteristica.getNombre())));
  }

  private boolean caracteristicasBasicasCompatibles(PublicacionIntencionDeAdopcion intencionDeAdopcion){
    return mascota.caracteristicasCompatiblesCon(intencionDeAdopcion);
  }

  public void notificarAlDuenioPosibleAdopcion(){
    this.mascota.notificarAlDuenio("Se encontró un posible Adoptante para tu mascota," +
            " siendo tu publiacion la número:" + this.numeroPublicacion);
  }

  public void setNumeroIdentificatorio(String numeroDePublicacion) {
    this.numeroPublicacion = numeroDePublicacion;
  }
}
