package model.mascota;

public enum Sexo {
  HEMBRA{
    @Override
    public String getNombre() {
      return "Hembra";
    }
  }, MACHO {
    @Override
    public String getNombre() {
      return "Macho";
    }
  };
  public abstract String getNombre();
}
