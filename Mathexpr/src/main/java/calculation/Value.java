/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculation;

import calculation.ICalc;

public class Value implements ICalc {
    double val=0;
    public Value(){

    }
    public void SetParameter(String name, Double value) {

    }
    public Value(double v){
        this.val=v;
    }
    @Override
    public double Calc() {
        return val;
    }

    @Override
    public String getCalcStr() {
        return String.valueOf(val);
    }
}

