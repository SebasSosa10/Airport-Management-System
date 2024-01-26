/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author Juan Manuel
 */
public class usuarioExistenteException extends Exception{

    public usuarioExistenteException() {
        super("El Usuario ya existe");
    }
    
}
