/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculation;

import Exceptions.CharUndef;
import Exceptions.ZeroDivException;
import calculation.ICalc;

public class Sum implements ICalc {
    ICalc l,r;
    public Sum(ICalc l,ICalc r){
        this.l=l;
        this.r=r;
    }
    public void SetParameter(String name, Double value) throws CharUndef {
        l.SetParameter(name, value);
        r.SetParameter(name, value);
    }
    @Override
    public double Calc() throws ZeroDivException {
        Double lv= l.Calc();
        Double rv=r.Calc();
        //System.out.println(this.getCalcStr() + " = " + (rv+lv));
        return lv+rv;
    }

    @Override
    public String getCalcStr() {
        String ls = l.getCalcStr();
        String rs = r.getCalcStr();
        return ls+"+"+rs;
    }
}
