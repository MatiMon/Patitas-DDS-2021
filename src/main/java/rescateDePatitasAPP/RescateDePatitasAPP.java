package rescateDePatitasAPP;

import mascota.RecomendadorMascotas;

public class RescateDePatitasAPP {

  public static void  main(String[] args){
    RecomendadorMascotas recomendadorMascotas = RecomendadorMascotas.getInstancia();

    recomendadorMascotas.generarRecomendaciones();
    System.out.println("Se ejecuto la generacion de recomendaciones");
  }

}
