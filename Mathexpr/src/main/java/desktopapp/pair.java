/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopapp;
import calculation.*;
import Exceptions.ScriptException;
import Exceptions.ZeroDivException;
import java.util.HashMap;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class pair {
  String name;
  String key;
  Integer value;
  HashMap<String, Integer> parameters= new  HashMap<String, Integer>();
  public pair(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  public void setParameters(String _key, String _value){
      
      this.key=_key;
      Integer Value=Integer.parseInt(_value);
      this.value=Value;
      parameters.put(key,value);
  }
   public String GetValue(){
     return value.toString();
  }
   public String get_Key(){
       return key;
   }
 /* public void hashm(HashMap<String, Integer> parameters){
      this.parameters=parameters;
  }*/
   public String getAge() throws  javax.script.ScriptException, ZeroDivException {
       
   //ScriptEngineManager manager = new ScriptEngineManager();
  // ScriptEngine engine = manager.getEngineByName("JavaScript");
   // String f = String.valueOf(Parser.calc(name).Calc());
    //parameters.put("b",44);
   double x = _Lexeme.calc(Prm.get_str_wth_param(name, parameters));
    //System.out.println(x);
    //return String.valueOf(engine.eval(name));
    return String.valueOf(x);
  }

    
}