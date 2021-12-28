/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculation;

import Exceptions.CharUndef;
import Exceptions.ZeroDivException;

public class Mult implements ICalc{
   private final ICalc l,r;
    public Mult(ICalc l,ICalc r){
        this.l=l;
        this.r=r;
    }
    @Override
    public double Calc() throws ZeroDivException {
        Double lv= l.Calc();
        Double rv=r.Calc();
        //System.out.println(this.getCalcStr() + " = " + lv*rv);
        return lv*rv;
    }
    public void SetParameter(String name, Double value) throws CharUndef {
        l.SetParameter(name, value);
        r.SetParameter(name, value);
    }

    @Override
    public String getCalcStr() {
        String ls, rs;
        if (l instanceof Sum) {
            ls = "(" + l.getCalcStr() + ")";
        } else {
            ls = l.getCalcStr();
        }

        if (r instanceof Sum) {
            //rs = "(" + r + ")";
            rs = "("+ r.getCalcStr()+")";
        } else {
            rs = r.getCalcStr();
        }

        return rs + " * " + ls;
    }
}
