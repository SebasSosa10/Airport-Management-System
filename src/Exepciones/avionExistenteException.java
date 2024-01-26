/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author Juan Manuel
 */
public class avionExistenteException extends Exception {

    public avionExistenteException() {
    super("Ya existe un avion registrado con ese codigo");
    }
    
}
