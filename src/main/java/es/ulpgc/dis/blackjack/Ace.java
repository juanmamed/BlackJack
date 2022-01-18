/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.dis.blackjack;

import java.util.logging.Logger;

/**
 *
 * @author galde
 */
public class Ace extends Card {

    public Ace() {
        super();
    }
    
    @Override
    public int getValue(){
        return 11;
    }
    
    public int secondValue(){
        return 1;
    }

}
