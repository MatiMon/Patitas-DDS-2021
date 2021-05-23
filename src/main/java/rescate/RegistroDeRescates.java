package rescate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistroDeRescates {
  private List<RescateDeMascota> rescatesDeMascotas = new ArrayList<>();

  public List<RescateDeMascota> ultimasMascotasEncontradas(int dias){
    return this.rescatesDeMascotas.stream()
        .filter(rescateDeMascota -> rescateDeMascota.getFecha().isAfter(LocalDateTime.now().minusDays(dias+1)))
        .collect(Collectors.toList());
  }

  public void agregarRescateMascota(RescateDeMascota rescateDeMascota){
    this.rescatesDeMascotas.add(rescateDeMascota);
  }

  public void removerRescateMascota(RescateDeMascota rescateDeMascota){
    this.rescatesDeMascotas.remove(rescateDeMascota);
  }
}
