/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package calculation;

/**
 *
 * @author alinaterina
 */
import Exceptions.CharUndef;
import Exceptions.ZeroDivException;

public interface ICalc {
    static ICalc parseICalc(String substring) {
            String a = substring;
            String s = a.replaceAll(",","").trim();
            String f = s.replaceAll(" ", "");
            double result = Double.parseDouble(f);
            ICalc res= new Value(result);
            return res;

    }
    double Calc() throws ZeroDivException;
    String getCalcStr();
    public void SetParameter(String name, Double value) throws CharUndef;
}
