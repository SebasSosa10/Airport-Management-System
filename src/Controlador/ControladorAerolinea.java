package Controlador;

import Exepciones.adminDuplicadoException;
import Exepciones.aerolineaDuplicadaException;
import Exepciones.avionExistenteException;
import Exepciones.empleadoDuplicadoException;
import Exepciones.empleadoNoexisteException;
import Exepciones.noExisteElAvionException;
import Exepciones.noExisteLaAerolineaException;
import Exepciones.seleccionGeneroInvalidaException;
import Exepciones.usuarioDeAdminYaExistenteException;
import Exepciones.usuarioExistenteException;
import Modelo.AdministradorAerolinea;
import Modelo.Aerolinea;
import Modelo.Avion;
import Modelo.Persona;
import Serializador.Serializador;
import java.util.ArrayList;

/**
 * @author Sebastian Sosa
 */
public class ControladorAerolinea {

    ArrayList<Aerolinea> listaAerolineas;
    ArrayList<Persona> listaPersonas;

    public ControladorAerolinea() {
        this.listaAerolineas = Serializador.getSeri().leerAeroLinea();
    }

    //---------------------------------------- CRUD DE ADMINISTRADOR AEROLINEA ---------------------------------------
    public void guardarAdminAerolinea(Aerolinea aerolinea) throws adminDuplicadoException, aerolineaDuplicadaException {
        Aerolinea aux = buscarAereoLinea(aerolinea.getCodigoAerolinea());
        AdministradorAerolinea aux2 = buscarAdministradorAerolinea(aerolinea.getAdministradorAerolinea().getNumDocumento());

        if (aux2 == null) {
            if (aux == null) {
                listaAerolineas.add(aerolinea);
                Serializador.getSeri().escribirAeroLinea(listaAerolineas);

            } else {

                throw new aerolineaDuplicadaException();
            }
        } else {
            throw new adminDuplicadoException();
        }
    }

    public AdministradorAerolinea buscarAdministradorAerolinea(String numDocumento) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (listaAerolineas.get(i).getAdministradorAerolinea().getNumDocumento().equals(numDocumento)) {
                return listaAerolineas.get(i).getAdministradorAerolinea();
            }
        }
        return null;
    }

    public void modificarAdminAerolinea(Aerolinea aerolinea) throws noExisteLaAerolineaException {
        Aerolinea aux = buscarAereoLinea(aerolinea.getCodigoAerolinea());
        if (aux != null) {
            aux.getAdministradorAerolinea().setUsuario((aerolinea.getAdministradorAerolinea().getUsuario()));
            aux.getAdministradorAerolinea().setContrasenia((aerolinea.getAdministradorAerolinea().getContrasenia()));
            aux.getAdministradorAerolinea().setNombre((aerolinea.getAdministradorAerolinea().getNombre()));
            aux.getAdministradorAerolinea().setApellido((aerolinea.getAdministradorAerolinea().getApellido()));
            aux.getAdministradorAerolinea().setGenero((aerolinea.getAdministradorAerolinea().getGenero()));
            aux.getAdministradorAerolinea().setNumCelular((aerolinea.getAdministradorAerolinea().getNumCelular()));
            aux.getAdministradorAerolinea().setNumDocumento((aerolinea.getAdministradorAerolinea().getNumDocumento()));
            aux.getAdministradorAerolinea().setIdioma((aerolinea.getAdministradorAerolinea().getIdioma()));
            aux.setNombreAerolinea(aerolinea.getNombreAerolinea());
            Serializador.getSeri().escribirAeroLinea(listaAerolineas);

        } else {
            throw new noExisteLaAerolineaException();
        }
    }

    public void eliminarAdminAerolinea(Aerolinea aerolinea) throws noExisteLaAerolineaException {
        Aerolinea aux = buscarAereoLinea(aerolinea.getCodigoAerolinea());
        if (aux != null) {
            listaAerolineas.remove(aux);
            Serializador.getSeri().escribirAeroLinea(listaAerolineas);

        } else {
            throw new noExisteLaAerolineaException();
        }
    }

    //---------------------------------------- CRUD DE AEROLINEA ---------------------------------------
    public Aerolinea buscarAereoLinea(String codigo) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (listaAerolineas.get(i).getCodigoAerolinea().equals(codigo)) {
                return listaAerolineas.get(i);
            }
        }
        return null;
    }

    //---------------------------------------- CRUD DE EMPLEADO ---------------------------------------
    public Persona verificarEmpleado(String numDocumento) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (numDocumento.equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    public Persona verificarUsuarioExistente(String usuario) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (usuario.equals(listaAerolineas.get(i).getListaPersona().get(j).getUsuario())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    public AdministradorAerolinea usuarioDeAdminExistente(String usuario) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (listaAerolineas.get(i).getAdministradorAerolinea().getUsuario().equals(usuario)) {
                return listaAerolineas.get(i).getAdministradorAerolinea();
            }
        }

        return null;
    }

    public Persona buscarEmpleado(Aerolinea aerolinea, String numDocumento) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())
                        && numDocumento.equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    public void guardarEmpleado(Aerolinea aerolinea, Persona persona) throws empleadoDuplicadoException, usuarioDeAdminYaExistenteException, usuarioExistenteException {
        AdministradorAerolinea auxA = usuarioDeAdminExistente(persona.getUsuario());
        Persona aux = verificarEmpleado(persona.getNumDocumento());
        Persona usuario = verificarUsuarioExistente(persona.getUsuario());
        if (auxA == null) {
            if (usuario == null) {
                if (aux == null) {
                    for (int i = 0; i < listaAerolineas.size(); i++) {
                        if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                            listaAerolineas.get(i).getListaPersona().add(persona);
                            Serializador.getSeri().escribirAeroLinea(listaAerolineas);

                        }
                    }
                } else {
                    throw new empleadoDuplicadoException();
                }
            } else {
                throw new usuarioExistenteException();
            }
        } else {
            throw new usuarioDeAdminYaExistenteException();

        }
    }

    public void modificarEmpleado(Aerolinea aerolinea, Persona persona) throws empleadoNoexisteException {
        Persona aux = buscarEmpleado(aerolinea, persona.getNumDocumento());
        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    aux.setNombre(persona.getNombre());
                    aux.setApellido(persona.getApellido());
                    aux.setUsuario(persona.getUsuario());
                    aux.setContrasenia(persona.getContrasenia());
                    aux.setGenero(persona.getGenero());
                    aux.setNumCelular(persona.getNumCelular());
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);

                }
            }

        } else {
            throw new empleadoNoexisteException();
        }
    }

    public void eliminarEmpleado(Aerolinea aerolinea, String numDocument) throws empleadoNoexisteException {
        Persona aux = buscarEmpleado(aerolinea, numDocument);
        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    listaAerolineas.get(i).getListaPersona().remove(aux);
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);

                }
            }
        } else {
            throw new empleadoNoexisteException();
        }
    }

    //---------------------------------------- CRUD DE CAPITAN ---------------------------------------
    public Persona verificarCapitan(String numDocumento) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (numDocumento.equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    public Persona buscarCapitan(Aerolinea aerolinea, String numDocumento) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())
                        && numDocumento.equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    public void guardarCapitan(Aerolinea aerolinea, Persona persona) throws empleadoDuplicadoException, seleccionGeneroInvalidaException {
        Persona aux = verificarCapitan(persona.getNumDocumento());
        if (persona.getGenero() != "Seleccionar") {
            if (aux == null) {
                for (int i = 0; i < listaAerolineas.size(); i++) {
                    if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                        listaAerolineas.get(i).getListaPersona().add(persona);
                        Serializador.getSeri().escribirAeroLinea(listaAerolineas);

                    }
                }
            } else {
                throw new empleadoDuplicadoException();
            }
        } else {
            throw new seleccionGeneroInvalidaException();
        }
    }

    public void modificarCapitan(Aerolinea aerolinea, Persona persona) throws empleadoNoexisteException {

        Persona aux = buscarCapitan(aerolinea, persona.getNumDocumento());
        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    aux.setUsuario(persona.getUsuario());
                    aux.setContrasenia(persona.getContrasenia());
                    aux.setNombre(persona.getNombre());
                    aux.setApellido(persona.getApellido());
                    aux.setGenero(persona.getGenero());
                    aux.setNumCelular(persona.getNumCelular());
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);

                }
            }

        } else {
            throw new empleadoNoexisteException();
        }
    }

    public void eliminarCapitan(Aerolinea aerolinea, Persona persona) throws empleadoNoexisteException {

        Persona aux = buscarCapitan(aerolinea, persona.getNumDocumento());
        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    listaAerolineas.get(i).getListaPersona().remove(aux);
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                }
            }
        } else {
            throw new empleadoNoexisteException();
        }
    }

    //---------------------------------------- CRUD DE AVION ---------------------------------------
    public Avion verificarAvion(String codigoAvion) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaAviones().size(); j++) {
                if (codigoAvion.equals(listaAerolineas.get(i).getListaAviones().get(j).getCodigoAvion())) {
                    return listaAerolineas.get(i).getListaAviones().get(j);
                }
            }
        }
        return null;
    }

    public Avion buscarAvion(Aerolinea aerolinea, String codigoAvion) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaAviones().size(); j++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())
                        && codigoAvion.equals(listaAerolineas.get(i).getListaAviones().get(j).getCodigoAvion())) {
                    return listaAerolineas.get(i).getListaAviones().get(j);
                }
            }
        }
        return null;
    }

    public void guardarAvion(Aerolinea aerolinea, Avion avion) throws avionExistenteException {
        Avion aux = verificarAvion(avion.getCodigoAvion());
        if (aux == null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    listaAerolineas.get(i).getListaAviones().add(avion);
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);

                }
            }
        } else {
            throw new avionExistenteException();
        }

    }

    public void modificarAvion(Aerolinea aerolinea, Avion avion) throws noExisteElAvionException {
        Avion aux = buscarAvion(aerolinea, avion.getCodigoAvion());

        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    aux.setModelo(avion.getModelo());
                    aux.setNum_Sillas(avion.getNum_Sillas());
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                    return;
                }
            }

        } else {
            throw new noExisteElAvionException();
        }
    }

    public void eliminarAvion(Aerolinea aerolinea, String codigoAvion)throws noExisteElAvionException {
        Avion aux = buscarAvion(aerolinea, codigoAvion);
        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    listaAerolineas.get(i).getListaAviones().remove(aux);
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);

                }
            }
        }else{
           throw new noExisteElAvionException();
        }
    }
    
    // -----------------------------------------------------------------------------------------------------------------------------
    public ArrayList<Aerolinea> getListaAerolineas() {
        return listaAerolineas;
    }

    public void setListaAerolineas(ArrayList<Aerolinea> listaAerolineas) {
        this.listaAerolineas = listaAerolineas;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
}
