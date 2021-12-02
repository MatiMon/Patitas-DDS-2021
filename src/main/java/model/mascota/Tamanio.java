package model.mascota;

public enum Tamanio {
  GRANDE(true){
    @Override
    public String getNombre() {
      return "Grande";
    }
  }, MEDIANO(true) {
    @Override
    public String getNombre() {
      return "Mediano";
    }
  }, CHICO(false) {
    @Override
    public String getNombre() {
      return "Chico";
    }
  };

  private boolean necesitaPatio;


  Tamanio(boolean necesitaPatio) {
    this.necesitaPatio = necesitaPatio;
  }

  public boolean necesitaPatio(){
    return necesitaPatio;
  }

  public abstract String getNombre();
}
