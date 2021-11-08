package model.mascota;

public enum Tamanio {
  GRANDE(true), MEDIANO(true), CHICO(false);

  private boolean necesitaPatio;

  Tamanio(boolean necesitaPatio) {
    this.necesitaPatio = necesitaPatio;
  }

  public boolean necesitaPatio(){
    return necesitaPatio;
  }
}
