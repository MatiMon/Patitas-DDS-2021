package mascota;

import java.util.HashMap;

public class RepositorioQR {
  private HashMap<String, Mascota> qrs; //TODO map en lugar de hashMap
  private static RepositorioQR instancia;


  private RepositorioQR(HashMap<String, Mascota> unosQRs) {
    qrs = unosQRs;
  }

  public static RepositorioQR getInstancia() {
    if (instancia == null) {
      instancia = new RepositorioQR(new HashMap<String, Mascota>());
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
