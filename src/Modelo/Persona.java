package Modelo;

import java.io.Serializable;

/**
 * @author Sebastian Sosa
 */
public class Persona extends Usuario implements Serializable {
    
    protected String nombre;
    protected String apellido;
    protected String genero;
    protected String numCelular;
    protected String numDocumento;

    public Persona(String nombre, String apellido, String genero, String numCelular, String numDocumento, String usuario, String contrasenia) {
        super(usuario, contrasenia);
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.numCelular = numCelular;
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
}

