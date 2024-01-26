/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Exepciones.soliAprovadaException;
import Exepciones.solicitudExistenteexeption;
import Modelo.Aerolinea;
import Modelo.SolicitudMantenimiento;
import Serializador.Serializador;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Juan Manuel
 */
public class ControladorSolicitudMantenimiento {

    ArrayList<Aerolinea> listaAerolineas;

    public ControladorSolicitudMantenimiento() {
        this.listaAerolineas = Serializador.getSeri().leerAeroLinea();
    }

    //---------------------------------------- CRUD DE VUELO ---------------------------------------
    public SolicitudMantenimiento verificarSolicitud(String id) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaSolicitud().size(); j++) {
                if (id.equals(listaAerolineas.get(i).getListaSolicitud().get(j).getId())) {
                    return listaAerolineas.get(i).getListaSolicitud().get(j);
                }
            }
        }
        return null;
    }

    public SolicitudMantenimiento buscarSolicitud(Aerolinea aerolinea, String id) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaSolicitud().size(); j++) {
                if (id.equals(listaAerolineas.get(i).getListaSolicitud().get(j).getId())) {
                    return listaAerolineas.get(i).getListaSolicitud().get(j);
                }
            }
        }
        return null;
    }

        public Aerolinea buscarAereoLinea(String codigo) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (listaAerolineas.get(i).getCodigoAerolinea().equals(codigo)) {
                return listaAerolineas.get(i);
            }
        }
        return null;
    }
    
    public Aerolinea guardarSolicitud(Aerolinea aerolinea, SolicitudMantenimiento solicitudMantenimiento)throws solicitudExistenteexeption {

          
    SolicitudMantenimiento aux = verificarSolicitud(solicitudMantenimiento.getId());
    if (aux== null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
            if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                listaAerolineas.get(i).getListaSolicitud().add(solicitudMantenimiento);
                Serializador.getSeri().escribirAeroLinea(listaAerolineas);
              return listaAerolineas.get(i);
            }
        }
    }else{
    throw new  solicitudExistenteexeption ();
    }

return null;
    }
    
    public boolean modificarSolicitud(Aerolinea aerolinea, SolicitudMantenimiento solicitudMantenimiento) {
        SolicitudMantenimiento aux = buscarSolicitud(aerolinea, solicitudMantenimiento.getId());
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                aux.setId(solicitudMantenimiento.getId());
                aux.setAvion(solicitudMantenimiento.getAvion());
                aux.setFecha(solicitudMantenimiento.getFecha());
                aux.setObservacion(solicitudMantenimiento.getObservacion());
                Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarSolicitud(Aerolinea aerolinea, SolicitudMantenimiento solicitudMantenimiento) {
        SolicitudMantenimiento aux = buscarSolicitud(aerolinea, solicitudMantenimiento.getId());
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())
                    && solicitudMantenimiento.getId().equals(aux.getId())) {
                listaAerolineas.get(i).getListaSolicitud().remove(aux);
                Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                return true;
            }
        }
        return false;
    }

    //---------------------------------------- CHAT ADMIN ---------------------------------------
    public SolicitudMantenimiento enviarMensajeA(SolicitudMantenimiento soli, String mensaje) {
        SolicitudMantenimiento aux = verificarSolicitud(soli.getId());
        aux.getMensajes().add(mensaje);
        Serializador.getSeri().escribirAeroLinea(listaAerolineas);
        return aux;
    }

    //---------------------------------------- CHAT EMPLE ---------------------------------------
    public Aerolinea enviarMensajeE(Aerolinea aero, String mensaje) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaSolicitud().size(); j++) {
                for (int k = 0; k < listaAerolineas.get(i).getListaSolicitud().get(j).getMensajes().size(); k++) {
                    if (aero.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                        listaAerolineas.get(i).getListaSolicitud().get(j).getMensajes().add(mensaje);
                        Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                        return listaAerolineas.get(i);
                    }
                }
            }
        }
        return aero;
    }
    //---------------------------------------- Finalizar Solicitud  ---------------------------------------
    
    
    public void finalizarSolicitud(SolicitudMantenimiento soli, int dias) throws soliAprovadaException{
        SolicitudMantenimiento aux = verificarSolicitud(soli.getId());
        if(aux!=null){
        aux.setFechaFin(aux.getFecha().plusDays(dias));
        aux.setEstado("Aprovado");
        Serializador.getSeri().escribirAeroLinea(listaAerolineas);
        
        }else{
        throw  new soliAprovadaException();
        }
        
        
    }

   
    
    //        public void autorizarMantenimiento(PeticionMantenimiento peticion, int duracion){
//        peticion.setDuracion(duracion);
//        peticion.setFechaFin(peticion.getFechaInicio().plusDays(duracion));
//        boolean aux2 = verificarAprovadas(peticion);
//        if(peticion.getEstado() != null && peticion.getEstado() == EstadoPeticion.APROVADA){
//            throw new PeticionYaAprovadaException();
//        }
//        if(aux2){
//            throw new MantenimientoYaAprovadoException();
//        }
//        PeticionMantenimiento aux = buscarPeticion(peticion.getId());
//        aux.setDuracion(duracion);
//        aux.setFechaFin(aux.getFechaInicio().plusDays(duracion));
//        aux.setEstado(EstadoPeticion.APROVADA);
//        Singleton.getSc().escribirPeticiones(listaPeticiones);
//    }
    public ArrayList<Aerolinea> getListaAerolineas() {
        return listaAerolineas;
    }
    
}
