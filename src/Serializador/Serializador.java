package Serializador;

import Modelo.Aerolinea;
import Modelo.Avion;
import Modelo.CapitanVuelo;
import Modelo.EmpleadoLogistica;
import Modelo.Persona;
import Modelo.Viajero;
import Modelo.Vuelo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Sosa
 */
public class Serializador {

    private static Serializador INSTANCIA = new Serializador();

    public static Serializador getSeri() {
        return INSTANCIA;
    }

    public void escribirPersona(ArrayList<Persona> ListaPersonas) {
        try {
            FileOutputStream archivo = new FileOutputStream("Personas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(ListaPersonas);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Persona> leerPersona() {
        try {
            FileInputStream archivo = new FileInputStream("Personas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ArrayList<Persona>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("No Hay Persona");
            return new ArrayList<>();
        }
    }

    public void escribirAeroLinea(ArrayList<Aerolinea> ListaAereoLineas) {
        try {
            FileOutputStream archivo = new FileOutputStream("Aereolineas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(ListaAereoLineas);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Aerolinea> leerAeroLinea() {
        try {
            FileInputStream archivo = new FileInputStream("Aereolineas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ArrayList<Aerolinea>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
//            System.out.println("No Hay Aerolinea");
            return new ArrayList<>();
        }
    }

   
}
