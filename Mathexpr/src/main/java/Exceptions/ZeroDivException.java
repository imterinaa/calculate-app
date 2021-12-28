/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author alinaterina
 */
public class ZeroDivException extends Exception {
    public ZeroDivException(String s) {
        super("DivByZero");
        System.out.println(s);

    }
}

