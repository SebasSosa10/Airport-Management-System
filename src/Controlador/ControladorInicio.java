package Controlador;

import Modelo.AdministradorAerolinea;
import Modelo.Aerolinea;
import Modelo.EmpleadoLogistica;
import Modelo.Persona;
import Modelo.Viajero;
import Serializador.Serializador;
import java.util.ArrayList;

/**
 * @author Sebastian Sosa
 */
public class ControladorInicio {

    ArrayList<Aerolinea> listaAerolineas;
    ArrayList<Persona> listaPersonas;

    public ControladorInicio() {

        this.listaAerolineas = Serializador.getSeri().leerAeroLinea();
        this.listaPersonas = Serializador.getSeri().leerPersona();

    }

    public AdministradorAerolinea buscarAdmin(String usuario, String contrasenia) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (listaAerolineas.get(i).getAdministradorAerolinea().getUsuario().equals(usuario)
                    && listaAerolineas.get(i).getAdministradorAerolinea().getContrasenia().equals(contrasenia)) {
                return listaAerolineas.get(i).getAdministradorAerolinea();
            }
        }
        return null;
    }

    public Persona buscarEmpleado(String usuario, String contrasenia) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (usuario.equals(listaAerolineas.get(i).getListaPersona().get(j).getUsuario())
                        && contrasenia.equals(listaAerolineas.get(i).getListaPersona().get(j).getContrasenia())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

//    public Persona buscarGestor(String usuario, String contrasenia) {
//        for (int i = 0; i < listaAerolineas.size(); i++) {
//            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
//                if (usuario.equals(listaAerolineas.get(i).getListaPersona().get(j).getUsuario())
//                        && contrasenia.equals(listaAerolineas.get(i).getListaPersona().get(j).getContrasenia())) {
//                    return listaAerolineas.get(i).getListaPersona().get(j);
//                }
//            }
//        }
//        return null;
//    }

    public Persona buscarViajero(String usuario, String contrasenia) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getUsuario().equals(usuario)
                    && listaPersonas.get(i).getContrasenia().equals(contrasenia)) {
                return listaPersonas.get(i);
            }
        }
        return null;
    }

    public Aerolinea inicioAerolinea(String usuario, String contrasenia) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (listaAerolineas.get(i).getAdministradorAerolinea().getUsuario().equals(usuario)
                    && listaAerolineas.get(i).getAdministradorAerolinea().getContrasenia().equals(contrasenia)) {
                return listaAerolineas.get(i);
            }
        }
        return null;
    }

    public Aerolinea inicioAerolineaEmpleado(String usuario, String contrasenia) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (usuario.equals(listaAerolineas.get(i).getListaPersona().get(j).getUsuario())
                        && contrasenia.equals(listaAerolineas.get(i).getListaPersona().get(j).getContrasenia())) {
                    return listaAerolineas.get(i);
                }
            }
        }
        return null;
    }
}
