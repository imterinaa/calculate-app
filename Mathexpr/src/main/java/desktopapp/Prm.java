/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desktopapp;
import java.util.HashMap;
/**
 *
 * @author alinaterina
 */
public class Prm {
     String expr;
    HashMap<String, Integer> prmt = new HashMap<String, Integer>();

    public Prm(String _expr, HashMap<String, Integer> _prmt) {
        this.expr = _expr;
        this.prmt = _prmt;
    }

    public static String get_str_wth_param(String Expr, HashMap<String, Integer> _prmt) {
        String res = "";

        for (int i = 0; i < Expr.length(); i++) {
            String k = Expr.substring(i, i + 1);
            if (_prmt.containsKey(k)) {
                String v = _prmt.get(k).toString();
                res += v;
            } else
                res += k;
        }
        //System.out.println(res);
        return res;
    }

    
}
