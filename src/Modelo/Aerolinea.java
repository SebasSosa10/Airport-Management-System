package Modelo;

import Serializador.Serializador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Sebastian Sosa
 */
public class Aerolinea implements Serializable {

    AdministradorAerolinea administradorAerolinea;
    private String NombreAerolinea;
    private String codigoAerolinea;
    private ArrayList<Persona> listaPersona;
    private ArrayList<Avion> listaAviones;
    private ArrayList<Vuelo>listaVuelos;
       private ArrayList<SolicitudMantenimiento>listaSolicitud;
       
    public Aerolinea(AdministradorAerolinea administradorAerolinea, String NombreAerolinea, String codigoAerolinea) {
        this.administradorAerolinea = administradorAerolinea;
        this.NombreAerolinea = NombreAerolinea;
        this.codigoAerolinea = codigoAerolinea;
        this.listaPersona = new ArrayList<>();
        this.listaAviones = new ArrayList<>();
        this.listaVuelos = new ArrayList<>();
         this.listaSolicitud = new ArrayList<>();
    }

    public ArrayList<SolicitudMantenimiento> getListaSolicitud() {
        return listaSolicitud;
    }

    public void setListaSolicitud(ArrayList<SolicitudMantenimiento> listaSolicitud) {
        this.listaSolicitud = listaSolicitud;
    }

    public AdministradorAerolinea getAdministradorAerolinea() {
        return administradorAerolinea;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public void setAdministradorAerolinea(AdministradorAerolinea administradorAerolinea) {
        this.administradorAerolinea = administradorAerolinea;
    }

    public String getNombreAerolinea() {
        return NombreAerolinea;
    }

    public void setNombreAerolinea(String NombreAerolinea) {
        this.NombreAerolinea = NombreAerolinea;
    }

    public String getCodigoAerolinea() {
        return codigoAerolinea;
    }

    public void setCodigoAerolinea(String codigoAerolinea) {
        this.codigoAerolinea = codigoAerolinea;
    }

    public ArrayList<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(ArrayList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public ArrayList<Avion> getListaAviones() {
        return listaAviones;
    }

    public void setListaAviones(ArrayList<Avion> listaAviones) {
        this.listaAviones = listaAviones;
    }

    
}
