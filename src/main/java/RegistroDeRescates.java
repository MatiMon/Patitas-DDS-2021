import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistroDeRescates {
  private List<MascotaRescatada> rescatesDeMascotas = new ArrayList<>();

  public List<MascotaRescatada> ultimasMascotasEncontradas(int dias){
    return this.rescatesDeMascotas.stream()
        .filter(mascotaRescatada -> mascotaRescatada.fecha.isAfter(LocalDateTime.now().minusDays(dias+1)))
        .collect(Collectors.toList());
  }

  public void agregarRescateMascota(MascotaRescatada mascotaRescatada){
    this.rescatesDeMascotas.add(mascotaRescatada);
  }

  public void removerRescateMascota(MascotaRescatada mascotaRescatada){
    this.rescatesDeMascotas.remove(mascotaRescatada);
  }
}
