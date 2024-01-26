package Controlador;

import Exepciones.vueloDuplicadoException;
import Exepciones.mismoOrigenException;
import Exepciones.noExisteVueloException;
import Modelo.Aerolinea;
import Modelo.Avion;
import Modelo.Persona;
import Modelo.Reserva;
import Modelo.Viajero;
import Modelo.Vuelo;
import Serializador.Serializador;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Sosa
 */
public class ControladorVuelo {

    ArrayList<Aerolinea> listaAerolineas;

    public ControladorVuelo() {
        this.listaAerolineas = Serializador.getSeri().leerAeroLinea();
    }

    //---------------------------------------- CRUD DE VUELO ---------------------------------------
    public Vuelo verificarVuelo(String codigoVuelo) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaVuelos().size(); j++) {
                if (codigoVuelo.equals(listaAerolineas.get(i).getListaVuelos().get(j).getCodigoVuelo())) {
                    return listaAerolineas.get(i).getListaVuelos().get(j);
                }
            }
        }
        return null;
    }

    public Vuelo buscarVuelo(Aerolinea aerolinea, String codigoVuelo) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaVuelos().size(); j++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())
                        && codigoVuelo.equals(listaAerolineas.get(i).getListaVuelos().get(j).getCodigoVuelo())) {
                    return listaAerolineas.get(i).getListaVuelos().get(j);
                }
            }
        }
        return null;
    }

    public Vuelo validacionOrigen(Aerolinea aerolinea, Vuelo vuelo) {
        long tiempodiferencia = Long.MAX_VALUE;
        Vuelo masProximo = null;
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                for (int j = 0; j < listaAerolineas.get(i).getListaVuelos().size(); j++) {
                    if (vuelo.getAvion().getCodigoAvion().equals(listaAerolineas.get(i).getListaVuelos().get(j).getAvion().getCodigoAvion())) {
                        Vuelo vueloinicio = listaAerolineas.get(i).getListaVuelos().get(j);
                        long minutosDifenrecia = ChronoUnit.MINUTES.between(vueloinicio.getFechaSalida(), vuelo.getFechaSalida());
                        if ((minutosDifenrecia < tiempodiferencia || minutosDifenrecia == 0) && minutosDifenrecia >= 0) {
                            tiempodiferencia = minutosDifenrecia;
                            masProximo = vueloinicio;
                        }
                    }
                }
            }
        }
        return masProximo;
    }

    public Aerolinea guardarVuelo(Aerolinea aerolinea, Vuelo vuelo) throws mismoOrigenException, vueloDuplicadoException {
        Vuelo aux = verificarVuelo(vuelo.getCodigoVuelo());
        if (vuelo.getOrigen() != vuelo.getDestino()) {
            if (aux == null) {
                for (int i = 0; i < listaAerolineas.size(); i++) {
                    if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                        listaAerolineas.get(i).getListaVuelos().add(vuelo);
                        Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                        return listaAerolineas.get(i);

                    }
                }

            } else {
                throw new vueloDuplicadoException();
            }

        } else {
            throw new mismoOrigenException();
        }
        return null;
    }

    public Aerolinea modificarVuelo(Aerolinea aerolinea, Vuelo vuelo) throws noExisteVueloException {
        Vuelo aux = buscarVuelo(aerolinea, vuelo.getCodigoVuelo());
        if (aux != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    aux.setOrigen(vuelo.getOrigen());
                    aux.setDestino(vuelo.getDestino());
                    aux.setFechaLlegada(vuelo.getFechaLlegada());
                    aux.setFechaSalida(vuelo.getFechaSalida());
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                    return listaAerolineas.get(i);
                   
                }
            }

        } else {
            throw new noExisteVueloException();
        }
        return null;
    }

    public Aerolinea eliminarVuelo(Aerolinea aerolinea, String codigoVuelo)throws noExisteVueloException {
        Vuelo aux = buscarVuelo(aerolinea, codigoVuelo);
        if (aux!=null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
                if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                    listaAerolineas.get(i).getListaVuelos().remove(aux);
                    Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                    return listaAerolineas.get(i);
                    
                }
            }

        } else {
         throw new noExisteVueloException();
        }
        return null;
    }

    public ArrayList<Persona> listadeCapitan(Aerolinea aerolinea) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (aerolinea.getCodigoAerolinea().equals(listaAerolineas.get(i).getCodigoAerolinea())) {
                return listaAerolineas.get(i).getListaPersona();
            }
        }
        return null;
    }

    public ArrayList<Aerolinea> getListaAerolineas() {
        return listaAerolineas;
    }

    public void setListaAerolineas(ArrayList<Aerolinea> listaAerolineas) {
        this.listaAerolineas = listaAerolineas;
    }

}
