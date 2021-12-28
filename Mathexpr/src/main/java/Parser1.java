



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alinaterina
 */
import desktopapp.*;
import calculation.*;

public class Parser1 {

    static ICalc calc(String item) {
        //Algorithm alg_mult = new Algorithm(Booperation.build(TypeOperation.mult));
       // Algorithm alg_sum = new Algorithm(Booperation.build(TypeOperation.sum));
        //Algorithm alg_div = new Algorithm(Booperation.build(TypeOperation.div));
         //new Ex(CreateParametr.build(TypeofOperation.MULT,l,r));
        return new Object() {
            int pos = -1, ch;

            void nextChar() {

                ch = (++pos < item.length()) ? item.charAt(pos) : -1;

            }

            boolean read(int _char) {
                while (ch == ' ') nextChar();
                if (ch == _char) {
                    nextChar();
                    return true;
                }
                return false;
            }

            ICalc part() {
                nextChar();
                ICalc x = partExpression();
                if (pos < item.length()) throw new RuntimeException("Не распознан символ: " + (char)ch);
                return x;
            }

           ICalc partExpression() {
                ICalc x = part_multdiv();
                int minus =-1;
                while (true) {
                    //if      (read('+')) x = alg_sum.calc(x,part_multdiv());
                    if      (read('+')) x = new Sum(x,part_multdiv());
                   // else if (read('-')) x =new Sum(x,Mult(new Value(-1),part_multdiv()));
                    else return x;
                }
            }


            ICalc part_multdiv() {
                ICalc x = partFactor();
                while (true) {
                    if      (read('*')) x = new Mult(x,partFactor());
                    else if (read('/')) x = new Div (x,partFactor());
                    else return x;
                }
            }

            ICalc partFactor() {
                ICalc x;
                int startPos = this.pos;
                if (read('(')) {
                    x = partExpression();
                    read(')');
                } else if ((ch >= '0' && ch <= '9') ) {
                    while ((ch >= '0' && ch <= '9') ) nextChar();
                    x = ICalc.parseICalc(item.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Не распознан символ: " + (char)ch);
                }

                return x;
            }
        }.part();
}}
