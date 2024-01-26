package Modelo;

import java.io.Serializable;

/**
 * @author Sebastian Sosa
 */
public class CapitanVuelo extends Persona implements Serializable{

    public CapitanVuelo(String nombre, String apellido, String genero, String numCelular, String numDocumento, String usuario, String contrasenia) {
        super(nombre, apellido, genero, numCelular, numDocumento, usuario, contrasenia);
    }
    
    @Override
    public String toString(){
        return super.getNombre() + " " + super.getApellido();
    }
}
