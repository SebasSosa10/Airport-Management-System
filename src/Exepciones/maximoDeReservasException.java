/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author Juan Manuel
 */
public class maximoDeReservasException extends Exception{

    public maximoDeReservasException() {
    super("No tiene permitido tener mas de dos Reservas activas");
    }
    
}
