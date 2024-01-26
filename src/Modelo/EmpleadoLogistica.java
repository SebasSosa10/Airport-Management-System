package Modelo;

import java.io.Serializable;

/**
 * @author Sebastian Sosa
 */
public class EmpleadoLogistica extends Persona implements Serializable {

    public EmpleadoLogistica(String nombre, String apellido, String genero, String numCelular, String numDocumento, String usuario, String contrasenia) {
        super(nombre, apellido, genero, numCelular, numDocumento, usuario, contrasenia);
    }

  
}
