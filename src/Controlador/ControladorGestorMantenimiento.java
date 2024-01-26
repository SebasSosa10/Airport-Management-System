package Controlador;

import Modelo.Aerolinea;
import Modelo.Persona;
import Serializador.Serializador;
import java.util.ArrayList;

/**
 * @author Sebastian Sosa
 */
public class ControladorGestorMantenimiento {

    ArrayList<Aerolinea> listaAerolineas;

    public ControladorGestorMantenimiento() {
        this.listaAerolineas = Serializador.getSeri().leerAeroLinea();
    }

    public Persona verificarGestor(String numDocumento) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (numDocumento.equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    //---------------------------------------- CRUD DE GESTORMANTENIMIENTO---------------------------------------
    public Persona buscarGestor(String numDocumento) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (numDocumento.equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    public boolean guardarGestor(Persona persona) {
        Persona aux = verificarGestor(persona.getNumDocumento());
        if (aux == null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                listaAerolineas.get(i).getListaPersona().add(persona);
                Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                return true;
            }
        }
        return false;
    }

    public boolean modificarGestor(Persona persona) {
        Persona aux = buscarGestor(persona.getNumDocumento());
        if (aux != null) {
            aux.setNombre(persona.getNombre());
            aux.setApellido(persona.getApellido());
            aux.setUsuario(persona.getUsuario());
            aux.setContrasenia(persona.getContrasenia());
            aux.setGenero(persona.getGenero());
            aux.setNumCelular(persona.getNumCelular());
            Serializador.getSeri().escribirAeroLinea(listaAerolineas);
            return true;
        }
        return false;
    }

    public boolean eliminarGestor(Persona persona) {
        Persona aux = buscarGestor(persona.getNumDocumento());
        for (int i = 0; i < listaAerolineas.size(); i++) {
            listaAerolineas.get(i).getListaPersona().remove(aux);
            Serializador.getSeri().escribirAeroLinea(listaAerolineas);
            return true;
        }
        return false;
    }
}
