import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArchivoCacheado {

    private String nombreArchivo;
    private List<String> cache;


    public ArchivoCacheado(String nombreArchivo) {
            this.nombreArchivo = nombreArchivo;
            guardarArchivoEnCache(this.nombreArchivo);
    }

    public boolean passwordEnArchivo(String unaPassword) {
        return cache.contains(unaPassword);
    }

    public void guardarArchivoEnCache(String nombreArchivo) {
        InputStream inputStream = getClass().getResourceAsStream(nombreArchivo);
        if (inputStream == null) throw new NombreDeArchivoInvalidoException("No existe el archivo");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        this.cache = new ArrayList<>(reader.lines().collect(Collectors.toList()));
    }
}


