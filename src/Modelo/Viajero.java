package Modelo;

import java.io.Serializable;

/**
 * @author Sebastian Sosa
 */
public class Viajero extends Persona implements Serializable {

    private String numeroPasaporte;
    private String nacionalidad;

    public Viajero(String numeroPasaporte, String nacionalidad, String nombre, String apellido, String genero, String numCelular, String numDocumento, String usuario, String contrasenia) {
        super(nombre, apellido, genero, numCelular, numDocumento, usuario, contrasenia);
        this.numeroPasaporte = numeroPasaporte;
        this.nacionalidad = nacionalidad;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}
