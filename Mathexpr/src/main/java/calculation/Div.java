/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculation;

import Exceptions.CharUndef;
import Exceptions.ZeroDivException;

public class Div implements ICalc  {

    ICalc l,r;
    public Div(ICalc l,ICalc r){
        this.l=l;
        this.r=r;
    }
    @Override
    public double Calc() throws ZeroDivException {
        double lv= l.Calc();
        double rv=r.Calc();
        if (rv==0){throw new ZeroDivException("Деление на 0");}
        //System.out.println(this.getCalcStr() + " = " + lv/rv);
        return lv/rv;
    }
    public void SetParameter(String name, Double value) throws CharUndef {
        l.SetParameter(name, value);
        r.SetParameter(name, value);
    }
    @Override
    public String getCalcStr() {
        String ls = l.getCalcStr();
        String rs = r.getCalcStr();
        return ls+"/"+rs;
    }
}


