package Modelo;

import java.io.Serializable;

/**
 * @author Sebastian Sosa
 */
public class GestorMantenimineto extends Persona implements Serializable {

    public GestorMantenimineto(String nombre, String apellido, String genero, String numCelular, String numDocumento, String usuario, String contrasenia) {
        super(nombre, apellido, genero, numCelular, numDocumento, usuario, contrasenia);
    }
}