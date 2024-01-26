package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Sebastian Sosa
 */
public class Vuelo  implements Serializable{

    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;
    private String codigoVuelo;
    private Avion avion;
    private CapitanVuelo capitan;
    private ArrayList<Reserva>listaReserva;
    public Vuelo(String origen, String destino, LocalDateTime fechaSalida, LocalDateTime fechaLlegada,String codigoVuelo, Avion avion, CapitanVuelo capitan) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.codigoVuelo = codigoVuelo;
        this.avion = avion;
        this.capitan = capitan;
        this.listaReserva = new ArrayList<>();
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }
    
 
    
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }


    
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Avion getAvion() {
        return avion;
    }

   

  
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public CapitanVuelo getCapitan() {
        return capitan;
    }

    public void setCapitan(CapitanVuelo capitan) {
        this.capitan = capitan;
    }

    
}
