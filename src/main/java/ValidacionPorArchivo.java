public class ValidacionPorArchivo implements ValidacionDePasswords{
    private ArchivoCacheado archivoCacheado;

    public ValidacionPorArchivo(ArchivoCacheado archivoCacheado) {
        this.archivoCacheado = archivoCacheado;
    }

    public boolean validarPassword(String password) {
        return !this.archivoCacheado.passwordEnArchivo(password);
    }

    public String getIdentificador() {
            return "ARCHIVO";
    }

}
