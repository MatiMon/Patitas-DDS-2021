package usuario;

public class ValidacionPorArchivo implements ValidacionDeContrasenia {
    private ListadoContrasenias listadoContrasenias;

    public ValidacionPorArchivo(ListadoContrasenias listadoContrasenias) {
        this.listadoContrasenias = listadoContrasenias;
    }

    public boolean esContraseniaValida(String password) {
        return !this.listadoContrasenias.contieneContraseniaEnListado(password);
    }

    public String getIdentificador() {
            return "ARCHIVO";
    }

}
