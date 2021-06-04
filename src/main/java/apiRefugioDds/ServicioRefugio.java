package apiRefugioDds;

import hogares.HogarDeTransito;

import java.util.List;

public interface ServicioRefugio {
  List<HogarDeTransito> obtenerHogares(String email);
}
