package caracteristicas;

import asociacion.Asociacion;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorioComodidades {
  private List<ComodidadIdeal> comodidadesGenericas = new ArrayList<>();

 // private Map<Asociacion,List<ComodidadIdeal>> comodidadesPersonalizadas = new HashMap<>();

  private static final RepositorioComodidades INSTANCIA = new RepositorioComodidades();

  public void agregarComodidadGeneral(ComodidadIdeal comodidadIdeal){
    this.comodidadesGenericas.add(comodidadIdeal);
  }


  public List<ComodidadIdeal> getComodidadesDeAsociacion (Asociacion asociacion){
    List<ComodidadIdeal> comodidadesTotales = new ArrayList<>(comodidadesGenericas);
    comodidadesTotales.addAll(asociacion.getComodidadesPersonalizadas());
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

  public List<ComodidadIdeal> getComodidadesObligatorias(Asociacion asociacion){
    return INSTANCIA.getComodidadesDeAsociacion(asociacion).stream().filter(ComodidadIdeal::esObligatoria).collect(Collectors.toList());
  }

  public void removerComodidadGenerica (ComodidadIdeal comodidadIdeal){
    this.comodidadesGenericas.remove(comodidadIdeal);
  }
/*
  public void agregarComodidadesPersonalizadas(Asociacion asociacion,List<ComodidadIdeal> comodidadIdeals){
    this.comodidadesPersonalizadas.put(asociacion, comodidadIdeals);
  }*/
}
