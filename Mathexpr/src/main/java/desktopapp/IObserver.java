/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopapp;

import Exceptions.ZeroDivException;

/**
 *
 * @author evgeniy.kozinov
 */
public interface IObserver {
  void event(Model m);  
}
