package model.usuario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PorArchivo")
public class ValidacionPorArchivo extends ValidacionDeContrasenia {

    @Embedded
    private ListadoContrasenias listadoContrasenias;

    public ValidacionPorArchivo(ListadoContrasenias listadoContrasenias) {
        this.listadoContrasenias = listadoContrasenias;
    }

    @Override
    public boolean esContraseniaValida(String password) {
        return !this.listadoContrasenias.contieneContraseniaEnListado(password);
    }

    @Override
    public String getIdentificador() {
            return "ARCHIVO";
    }

}
