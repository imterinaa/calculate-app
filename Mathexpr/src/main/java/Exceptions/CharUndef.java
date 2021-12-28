/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

public class CharUndef extends Exception {
    public CharUndef(String s) {
        super("Параметр не задан '%s".formatted(s));
    }
}
