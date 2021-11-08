package usuario;

import excepciones.NombreDeArchivoInvalidoException;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
@AttributeOverride(name = "nombreArchivo", column = @Column(name = "nombre_archivo"))
public class ListadoContrasenias {
    @Column(name = "nombre_archivo")
    private String nombreArchivo;
    @Transient
    private List<String> cache;


    public ListadoContrasenias(String nombreArchivo) {
            this.nombreArchivo = nombreArchivo;
            guardarArchivoEnCache(this.nombreArchivo);
    }

    public boolean contieneContraseniaEnListado(String unaPassword) {
        return cache.contains(unaPassword);
    }

    public void guardarArchivoEnCache(String nombreArchivo) {
        InputStream inputStream = getClass().getResourceAsStream(nombreArchivo);
        if (inputStream == null) throw new NombreDeArchivoInvalidoException("No existe el archivo");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        this.cache = new ArrayList<>(reader.lines().collect(Collectors.toList()));
    }
}


