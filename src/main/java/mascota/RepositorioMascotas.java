package mascota;

import java.util.HashMap;

public class RepositorioMascotas {
  private HashMap<String, Mascota> qrs; //TODO map en lugar de hashMap
  private static RepositorioMascotas instancia;


  private RepositorioMascotas(HashMap<String, Mascota> unosQRs) {
    qrs = unosQRs;
  }

  public static RepositorioMascotas getInstancia() {
    if (instancia == null) {
      instancia = new RepositorioMascotas(new HashMap<String, Mascota>());
    }
    return instancia;
  }

  public Mascota obtenerMascota(String qr) {
    return qrs.get(qr);
  }

  public void registrarQR(String qr, Mascota mascota) {
    qrs.put(qr, mascota);
  }

  public void removerQR(String qr) {
    qrs.remove(qr);
  }


}
