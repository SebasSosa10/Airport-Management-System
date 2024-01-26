/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author Juan Manuel
 */
public class adminDuplicadoException extends Exception {

    public adminDuplicadoException() {
    super("Ya existe un admin con este codigo ");
    }
    
}
