package model.usuario;

import model.excepciones.NombreDeArchivoInvalidoException;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.*;
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

    public ListadoContrasenias() {

    }

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

        try {
            InputStreamReader iReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader reader = new BufferedReader(iReader);
            this.cache = new ArrayList<>(reader.lines().collect(Collectors.toList()));

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


