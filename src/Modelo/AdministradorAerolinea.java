package Modelo;

import java.io.Serializable;

/**
 * @author Sebastian Sosa
 */
public class AdministradorAerolinea extends Persona implements Serializable {

    private String idioma;

    public AdministradorAerolinea(String idioma, String nombre, String apellido, String genero, String numCelular, String numDocumento, String usuario, String contrasenia) {
        super(nombre, apellido, genero, numCelular, numDocumento, usuario, contrasenia);
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
