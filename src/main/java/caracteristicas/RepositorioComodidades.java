package caracteristicas;

import asociacion.Asociacion;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorioComodidades {
  private List<ComodidadIdeal> comodidadesGenericas = new ArrayList<>();

  private Map<Asociacion,List<ComodidadIdeal>> comodidadesPersonalizadas = new HashMap<>();

  private static final RepositorioComodidades INSTANCIA = new RepositorioComodidades();

  public void agregarComodidadGeneral(ComodidadIdeal comodidadIdeal){
    this.comodidadesGenericas.add(comodidadIdeal);
  }

  //Si fuera una sola comodidad a agregar, y no lo pongo como lista, no puedo agregarla, porque el map es tipo List.
  public void agregarComodidadPersonalizada(Asociacion asociacion,ComodidadIdeal... comodidadIdeal){
    this.comodidadesPersonalizadas.put(asociacion, Arrays.asList(comodidadIdeal));
  }

  public List<ComodidadIdeal> getComodidadesDeAsociacion (Asociacion asociacion){
    List<ComodidadIdeal> comodidadesTotales = comodidadesGenericas;
    comodidadesTotales.addAll(this.comodidadesPersonalizadas.get(asociacion));
    return comodidadesTotales;
  }

  public List<ComodidadIdeal> getComodidadesGenericas(){
    return this.comodidadesGenericas;
  }

  public static RepositorioComodidades getInstancia() {
    return INSTANCIA;
  }

  public static List<String> getNombresComodidadesDeAsociacion(Asociacion asociacion){
    return INSTANCIA.getComodidadesDeAsociacion(asociacion).stream().map(ComodidadIdeal::getNombre).collect(Collectors.toList());
  }
}
