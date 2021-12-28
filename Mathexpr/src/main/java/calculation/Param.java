/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculation;
import Exceptions.*;
public class Param implements ICalc{
    private final String name;
    double value=-1;
    int flag =0;
    public  Param(String name){
        this.name = name;
         value = -1;
    }
    @Override
    public double Calc() {
        return value;
    }

    @Override
    public String getCalcStr() {
        return name;
    }

    @Override
    public void SetParameter(String name, Double value) throws CharUndef
    { if(flag==0){
        throw new CharUndef(name);
    }
    flag = 1;
        if (this.name.equals(name)) {
            this.value = Double.valueOf(value);
        }
    }
}
