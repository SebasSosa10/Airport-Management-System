/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author Juan Manuel
 */
    public class empleadoNoexisteException extends Exception{

    public empleadoNoexisteException() {
    super("El empleado no existe");
    }
    
}
