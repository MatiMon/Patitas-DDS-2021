package model.mascota;

import model.usuario.Usuario;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioMascotas implements WithGlobalEntityManager {
  private Map<String, Mascota> mascotas;
  private static RepositorioMascotas instancia;


  private RepositorioMascotas(HashMap<String, Mascota> unasMascotas) {
    mascotas = unasMascotas;
  }

  public static RepositorioMascotas getInstancia() {
    if (instancia == null) {
      instancia = new RepositorioMascotas(new HashMap<String, Mascota>());
    }
    return instancia;
  }


  public Mascota obtenerMascota(String id) {
    return mascotas.get(id);
  }

  public void registrarMascota(String id, Mascota mascota) {
    mascotas.put(id, mascota);
  }

  public void removerMascota(String id) {
    mascotas.remove(id);
  }

  public void agregarMascota(Mascota mascota) {
    entityManager().persist(mascota);
  }


  public List<Mascota> obtenerMascotasUser(Long user_id) {
    return entityManager()//
        .createQuery("from Mascotas", Mascota.class)
        .getResultList().stream().filter(mascota -> mascota.getIdDuenio() == user_id).collect(Collectors.toList());
  }
}
