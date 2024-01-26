package Modelo;

import java.io.Serializable;

/**
 * @author Sebastian Sosa
 */
public class Avion implements Serializable {
    private String codigoAvion;
    private String modelo;
    private int num_Sillas;

    public Avion(String codigoAvion, String modelo, int num_Sillas) {
        this.codigoAvion = codigoAvion;
        this.modelo = modelo;
        this.num_Sillas = num_Sillas;
    }

    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNum_Sillas() {
        return num_Sillas;
    }

    public void setNum_Sillas(int num_Sillas) {
        this.num_Sillas = num_Sillas;
    }
    
    @Override
    public String toString(){
        return modelo +" "+codigoAvion;
    }
   
}
