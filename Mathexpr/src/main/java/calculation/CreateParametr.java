/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculation;

/**
 *
 * @author alinaterina
 */
public class CreateParametr {
    public static ICalc Create(int value) {
        return new Value(value);
    }

    public static ICalc Create(String name) {
        return new Param(name);
    }
    static public ICalc build(TypeofOperation type,ICalc l, ICalc r)
    {
        if(type==TypeofOperation.SUM)
            return new Sum(l,r);
        if(type==TypeofOperation.MULT)
            return new Mult(l,r);
        if(type==TypeofOperation.DIV)
            return new Div(l,r);
        return null;
    }

}
