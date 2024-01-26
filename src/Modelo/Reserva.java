
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Juan Manuel
 */
public class Reserva implements Serializable{
 
    private  Vuelo vuelo;
    private Viajero viajero;

    public Reserva( Vuelo vuelo, Viajero viajero) {
        this.vuelo = vuelo;
        this.viajero = viajero;
    }

 
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Viajero getViajero() {
        return viajero;
    }

    public void setViajero(Viajero viajero) {
        this.viajero = viajero;
    }
    
    
    
    
    
    
    
    
}
