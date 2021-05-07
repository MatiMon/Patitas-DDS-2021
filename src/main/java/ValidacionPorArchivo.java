public class ValidacionPorArchivo implements ValidacionContrasenia{
    private ArchivoCacheado archivoCacheado;

    public ValidacionPorArchivo(ArchivoCacheado archivoCacheado) {
        this.archivoCacheado = archivoCacheado;
    }

    public boolean validacionContrasenia(String password) {
        return !this.archivoCacheado.passwordEnArchivo(password);
    }

    public String getIdentificador() {
            return "ARCHIVO";
    }

}
