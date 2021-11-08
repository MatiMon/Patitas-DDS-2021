package model.apiRefugioDds;

import model.hogares.HogarDeTransito;

import java.util.List;

public interface ServicioRefugio {
  List<HogarDeTransito> obtenerHogares(String email);
}
