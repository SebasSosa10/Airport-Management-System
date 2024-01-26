/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author Juan Manuel
 */
public class empleadoDuplicadoException extends Exception {

    public empleadoDuplicadoException() {
    super("Ya exisite un Usuario con ese numero de Documento");
    }
    
}
