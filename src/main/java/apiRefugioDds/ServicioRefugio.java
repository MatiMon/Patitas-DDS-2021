package apiRefugioDds;

import java.util.List;

public interface ServicioRefugio {
  List<HogarDeTransito> obtenerHogares(String email);
}
