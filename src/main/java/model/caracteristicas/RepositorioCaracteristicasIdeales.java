package model.caracteristicas;

import model.caracteristicas.ideales.CaracteristicaIdeal;
import model.mascota.Mascota;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioCaracteristicasIdeales implements WithGlobalEntityManager {
  private Map<String,CaracteristicaIdeal> caracteristicas; //= new ArrayList<>();

  private static final RepositorioCaracteristicasIdeales INSTANCIA = new RepositorioCaracteristicasIdeales(new HashMap<String, CaracteristicaIdeal>());

  private RepositorioCaracteristicasIdeales(HashMap<String, CaracteristicaIdeal> unasCaracteristicas) {caracteristicas = unasCaracteristicas;}

  public void agregarCaracteristicaIdeal(CaracteristicaIdeal caracteristica){
    entityManager().persist(caracteristica);
  }

  public CaracteristicaIdeal obtenerCaracteristica(String id) {
    return caracteristicas.get(id);
  }

  public List<CaracteristicaIdeal> getCaracteristicas(){
    return new ArrayList<CaracteristicaIdeal>(caracteristicas.values());
  }

  public void registrarCaracteristicaIdeal(String id, CaracteristicaIdeal caracteristica) {
    caracteristicas.put(id, caracteristica);
  }

  public void removerCaracteristicaIdeal(String id) {
    caracteristicas.remove(id);
  }

  public List<CaracteristicaIdeal> getCaractetisticasObligatorias(){
    List<CaracteristicaIdeal> caract = this.getCaracteristicas();
    return caract.stream().filter(CaracteristicaIdeal::esObligatoria).collect(Collectors.toList());
  }

  public List<String> getNombresCaracteristicasObligatorias(){
    return getCaractetisticasObligatorias().stream().map(CaracteristicaIdeal::getNombre).collect(Collectors.toList());
  }

  public static RepositorioCaracteristicasIdeales getInstancia() {
    return INSTANCIA;
  }
}
