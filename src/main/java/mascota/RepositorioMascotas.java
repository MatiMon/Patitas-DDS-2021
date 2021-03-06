package mascota;

import java.util.HashMap;
import java.util.Map;

public class RepositorioMascotas {
  private Map<String, Mascota> mascotas;
  private static RepositorioMascotas instancia;


  private RepositorioMascotas(HashMap<String, Mascota> unasMascotas) {
    mascotas = unasMascotas;
  }

  public static RepositorioMascotas getInstancia() {
    if (instancia == null) {
      instancia = new RepositorioMascotas(new HashMap<String, Mascota>());
    }
    return instancia;
  }


  public Mascota obtenerMascota(String id) {
    return mascotas.get(id);
  }

  public void registrarMascota(String id, Mascota mascota) {
    mascotas.put(id, mascota);
  }

  public void removerMascota(String id) {
    mascotas.remove(id);
  }


}
