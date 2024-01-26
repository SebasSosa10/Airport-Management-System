package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author juan
 */
public class SolicitudMantenimiento implements Serializable {
    private LocalDate duracion;
    private LocalDate fechaFin;
    private String id;
    private LocalDate fecha;
    private ArrayList<String> mensajes;
    private String estado;
    private String observacion;
    private Avion avion;

    public SolicitudMantenimiento(LocalDate duracion, LocalDate fechaFin, String id, LocalDate fecha,  String estado, String observacion, Avion avion) {
        this.duracion = duracion;
        this.fechaFin = fechaFin;
        this.id = id;
        this.fecha = fecha;
        this.mensajes = new ArrayList<>();
        this.estado = estado;
        this.observacion = observacion;
        this.avion = avion;
    }

    public LocalDate getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalDate duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public ArrayList<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<String> mensajes) {
        this.mensajes = mensajes;
    }


    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
