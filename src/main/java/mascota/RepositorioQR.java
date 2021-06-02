package mascota;

import java.util.HashMap;

public class RepositorioQR {
  private HashMap<String, Mascota> qrs;
  private static RepositorioQR instancia;


  private RepositorioQR(HashMap<String,Mascota> unosQRs){
    qrs =unosQRs;
  }

  public RepositorioQR getInstancia(){
    if(instancia == null){
      instancia = new RepositorioQR(new HashMap<String,Mascota>());
    }
    return instancia;
  }

  public Mascota obtenerMascota(String qr) {
    return qrs.get(qr);
  }

  public void registrarQR(String qr, Mascota mascota){
    qrs.put(qr,mascota);
  }


}
