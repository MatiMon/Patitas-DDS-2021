import asociacion.Asociacion;
import caracteristicas.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRepositorioComodidades {

  private Asociacion asociacion1 = new Asociacion(null,null,null,null,null,null);
  private Asociacion asociacion2 = new Asociacion(null,null,null,null,null,null);

  private List<ComodidadIdeal> comodidadesPersonalizadas1;
  private List<ComodidadIdeal> comodidadesPersonalizadas2;

  private ComodidadIdeal tamanioPatio = new ComodidadIdeal(null,null,"tamanioPatio",true, null);
  private ComodidadIdeal cantidadHorasLibres = new ComodidadIdeal(null,null,"HorasLibres",true, null);
  private ComodidadIdeal horasJuegoOpcionales = new ComodidadIdeal(null,null,"HorasJuegoOpc",false,null);


  RepositorioComodidades repositorioComodidades = RepositorioComodidades.getInstancia();


  @BeforeEach
  public void init(){

    repositorioComodidades.agregarComodidadGeneral(tamanioPatio);
    repositorioComodidades.agregarComodidadPersonalizada(asociacion1,cantidadHorasLibres);
    repositorioComodidades.agregarComodidadPersonalizada(asociacion2,cantidadHorasLibres,horasJuegoOpcionales);

  }

  @AfterEach
  void finalizar(){
    repositorioComodidades.removerComodidadDeAsociacion(asociacion2,cantidadHorasLibres);
    repositorioComodidades.removerComodidadDeAsociacion(asociacion2,horasJuegoOpcionales);
    repositorioComodidades.removerComodidadGenerica(tamanioPatio);
    repositorioComodidades.removerComodidadDeAsociacion(asociacion1,cantidadHorasLibres);
  }

  /*
  @Test
  public void elRepoConoceLasComodidadesObligatoriasDeLaAsociacionDada(){

    /*Assertions.assertTrue(repositorioComodidades
            .getComodidadesObligatorias(asociacion2)
            .containsAll(Arrays.asList(cantidadHorasLibres, tamanioPatio)));


    Assertions.assertEquals(2,repositorioComodidades.getComodidadesObligatorias(asociacion2).size());

  }

  @Test
  public void elRepoConoceTodasLasComodidadesDeLaAsociacionDadaIncluyendoGenericasYPersonalizadas() {

    Assertions.assertTrue(repositorioComodidades
            .getComodidadesDeAsociacion(asociacion1)
            .containsAll(Arrays.asList(tamanioPatio,cantidadHorasLibres)));

    Assertions.assertEquals(2,repositorioComodidades.getComodidadesDeAsociacion(asociacion1).size());
  }*/
}
