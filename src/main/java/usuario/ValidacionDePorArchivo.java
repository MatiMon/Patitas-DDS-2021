package usuario;

public class ValidacionDePorArchivo implements ValidacionDeContrasenia {
    private ArchivoCacheado archivoCacheado;

    public ValidacionDePorArchivo(ArchivoCacheado archivoCacheado) {
        this.archivoCacheado = archivoCacheado;
    }

    public boolean validarContrasenia(String password) {
        return !this.archivoCacheado.passwordEnArchivo(password);
    }

    public String getIdentificador() {
            return "ARCHIVO";
    }

}
