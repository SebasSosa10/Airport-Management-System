package Controlador;

import Exepciones.cupoLlenoException;
import Exepciones.maximoDeReservasException;
import Exepciones.reservaDeViajeroActiva;
import Exepciones.reservaNoencontradaException;
import Modelo.AdministradorAerolinea;
import Modelo.Aerolinea;
import Modelo.CapitanVuelo;
import Modelo.EmpleadoLogistica;
import Modelo.GestorMantenimineto;
import Modelo.Persona;
import Modelo.Reserva;
import Modelo.Viajero;
import Modelo.Vuelo;
import Serializador.Serializador;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Sosa
 */
public class ControladorViajero {

    public ArrayList<Aerolinea> getListaAerolineas() {
        return listaAerolineas;
    }

    ArrayList<Persona> listaPersonas;
    ArrayList<Aerolinea> listaAerolineas;

    public ControladorViajero() {
        this.listaPersonas = Serializador.getSeri().leerPersona();
        this.listaAerolineas = Serializador.getSeri().leerAeroLinea();
    }

    //---------------------------------------- BUSCAR ---------------------------------------
    public Persona buscar(String numDocumento) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getNumDocumento().equals(numDocumento)) {
                return listaPersonas.get(i);
            }
        }
        return null;
    }

    //---------------------------------------- CRUD DE VAJERO ---------------------------------------
    public boolean guardarViajero(Viajero viajero) {
        Viajero aux = (Viajero) buscar(viajero.getNumDocumento());
        if (aux == null) {
            listaPersonas.add(viajero);
            Serializador.getSeri().escribirPersona(listaPersonas);
            return true;
        }
        return false;
    }

    //---------------------------------------- VERIFICAR EMPLEADO ---------------------------------------
    public Persona verificarEmpleado(Viajero viajero) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (viajero.getNumDocumento().equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    //---------------------------------------- VERIFICAR CAPITAN ---------------------------------------
    public Persona verificarCapitan(Viajero viajero) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (viajero.getNumDocumento().equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }
    //---------------------------------------- VERIFICAR ADMINISTRADOR AEROLINEA ---------------------------------------

    public AdministradorAerolinea verificarAdministradorAerolinea(Viajero viajero) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (listaAerolineas.get(i).getAdministradorAerolinea().getUsuario().equals(viajero.getNumDocumento())) {
                return listaAerolineas.get(i).getAdministradorAerolinea();
            }
        }
        return null;
    }

    //---------------------------------------- VERIFICAR GESTOR DE MANTENIMIENTOs---------------------------------------
    public Persona verificarGestorMantenimiento(Viajero viajero) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaPersona().size(); j++) {
                if (viajero.getNumDocumento().equals(listaAerolineas.get(i).getListaPersona().get(j).getNumDocumento())) {
                    return listaAerolineas.get(i).getListaPersona().get(j);
                }
            }
        }
        return null;
    }

    //---------------------------------------- FILTRAR AEROLINEA ---------------------------------------
    public Aerolinea buscarAerolinea(String NombreAerolinea) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            if (NombreAerolinea.equals(listaAerolineas.get(i).getNombreAerolinea())) {
                return listaAerolineas.get(i);
            }
        }
        return null;
    }

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

    public Viajero viajeroEnVuelo(Reserva reserva) {
        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaVuelos().size(); j++) {
                for (int k = 0; k < listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().size(); k++) {
                    if (reserva.getVuelo().getCodigoVuelo().equals(listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k).getVuelo().getCodigoVuelo()) && reserva.getViajero().getNumDocumento().equals(listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k).getViajero().getNumDocumento())) {
                        return listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k).getViajero();
                    }

                }
            }
        }

        return null;
    }

    public void reservarVuelo(Reserva reserva) throws reservaDeViajeroActiva, cupoLlenoException, maximoDeReservasException {
        Vuelo vueloV = verificarVuelo(reserva.getVuelo().getCodigoVuelo());
        Viajero viajero = viajeroEnVuelo(reserva);
        if (viajero == null) {
            int cont = 0;
            int cupos = reserva.getVuelo().getAvion().getNum_Sillas();
            for (int i = 0; i < listaAerolineas.size(); i++) {
                for (int j = 0; j < listaAerolineas.get(i).getListaVuelos().size(); j++) {
                    for (int k = 0; k < listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().size(); k++) {
                        if (listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k).getViajero()
                                .getNumDocumento().equals(reserva.getViajero().getNumDocumento())) {
                            cont++;
                            if (cont >= 2) {
                                throw new maximoDeReservasException();
                            }
                        }
                    }
                }
            }
            if (cupos > 0) {
                if (vueloV != null) {
                    for (int i = 0; i < listaAerolineas.size(); i++) {
                        for (int j = 0; j < listaAerolineas.get(i).getListaVuelos().size(); j++) {
                            if (reserva.getVuelo().getCodigoVuelo().equals(listaAerolineas.get(i).getListaVuelos().get(j).getCodigoVuelo())) {
                                int resta = reserva.getVuelo().getAvion().getNum_Sillas();
                                int totalresta = resta - 1;
                                reserva.getVuelo().getAvion().setNum_Sillas(totalresta);
                                listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().add(reserva);
                                Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                                return;
                            }
                        }
                    }
                }
            } else {
                throw new cupoLlenoException();
            }

        } else {
            throw new reservaDeViajeroActiva();

        }
    }

    public Reserva buscarReserva(String codigoVuelo, Viajero viajero) {

        for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaVuelos().size(); j++) {
                for (int k = 0; k < listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().size(); k++) {
                    if (codigoVuelo.equals(listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k).getVuelo().getCodigoVuelo()) && viajero.getNumDocumento().equals(listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k).getViajero().getNumDocumento())) {
                        return listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k);
                    }

                }
            }
        }

        return null;
    }

    public Viajero cancelarReserva(String codigoVuelo, Viajero viajero) throws reservaNoencontradaException {
        Reserva reserva = buscarReserva(codigoVuelo, viajero);
        if (reserva != null) {
            for (int i = 0; i < listaAerolineas.size(); i++) {
            for (int j = 0; j < listaAerolineas.get(i).getListaVuelos().size(); j++) {
                for (int k = 0; k < listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().size(); k++) {
                    if (codigoVuelo.equals(listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k).getVuelo().getCodigoVuelo())) {
                        viajero = listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().get(k).getViajero();
                        listaAerolineas.get(i).getListaVuelos().get(j).getListaReserva().remove(reserva);
                        Serializador.getSeri().escribirAeroLinea(listaAerolineas);
                        return viajero;
                    }
                }

            }
        }
        }else{
        throw new reservaNoencontradaException();
        }

        
        return viajero;
    }
}


