/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author alinaterina
 */
public class ScriptException extends Exception {
    public ScriptException(String s) {
        super("oops");
        System.out.println(s);

    }
    
}
