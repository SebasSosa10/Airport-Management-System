/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author Juan Manuel
 */
public class vueloDuplicadoException extends Exception{

    public vueloDuplicadoException() {
    super("Ya existe un vuelo con ese codigo");
    }
    
}
