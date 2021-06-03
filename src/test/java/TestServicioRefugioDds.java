import apiRefugioDds.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TestServicioRefugioDds {
  RefugioDdsAPI api;
  ServicioRefugioDds servicio;
  RespuestaRefugioDdsAPI respuestaRefugioDdsAPI;

  @BeforeEach
  public void setUp() throws Exception {
    this.api = new RefugioDdsAPI();
    this.servicio = new ServicioRefugioDds(api);
    //this.respuestaRefugioDdsAPI = this.requester.getHogaresDePagina("1", "pR0GYdKrgvKfVehIfRtFxZddIRYvxIynays7X4P6l07rNQcmovyAmmE9ZXJJ");
  }

  @Test
  public void generarUsuarioConMailInvalidoDaError() {

  }

  @Test
  public void generarUsuarioConMailYaRegistradoDaError() {

  }

  @Test
  public void generarUsuarioNuevoDevuelveUnToken() {

  }

  @Test
  public void generoUsuarioLoGuardoYDespuesLoPuedoBuscarParaObtenerHogares(){

  }

  @Test
  public void hagoObtenerTodosLosHogaresYSonCuarenta(){
    List<HogarDeTransito> hogares = servicio.obtenerTodosLosHogares("pR0GYdKrgvKfVehIfRtFxZddIRYvxIynays7X4P6l07rNQcmovyAmmE9ZXJJ");
    Assertions.assertEquals(hogares.size(), 40);

  }

  @Test
  public void losDatosDelPrimerHogarSonLosDelPensionadoLlamadoComoEnCasa() {
    HogarDeTransito hogar = respuestaRefugioDdsAPI.getHogares().get(0);
    Ubicacion ubicacion = hogar.getUbicacion();

    //Assertions.assertEquals();
    Assertions.assertEquals(hogar.getNombre(), "Pensionado de mascotas \"Como en casa\"");
    Assertions.assertEquals(ubicacion.getDireccion(), "Av. Ing Eduardo Madero 2300, B1669BZQ Del Viso, Provincia de Buenos Aires");
    Assertions.assertEquals(ubicacion.getLatitud(), -34.46013439745161);
    Assertions.assertEquals(ubicacion.getLongitud(),-58.80857841888721);
  }



}
