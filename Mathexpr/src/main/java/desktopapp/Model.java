/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopapp;

import java.util.ArrayList;
import Exceptions.ZeroDivException;
/**
 *
 * 
 */
public class Model {
  ArrayList<pair> AllPair = new ArrayList<>();
  ArrayList<IObserver> o = new ArrayList<>();
  
  public void addO(IObserver obj)
  {
    o.add(obj);
  }
  
  public void add(pair p){
    AllPair.add(p);
    event();
  }
  
  public  void remove(pair p)
  {
    AllPair.remove(p);
    event();
  }
  
  void event() 
  {
    for (IObserver obj : o) {
      obj.event(this);
    }
  }
  
  ArrayList<pair> getAllPair(){
    return AllPair;
  }
  
}
