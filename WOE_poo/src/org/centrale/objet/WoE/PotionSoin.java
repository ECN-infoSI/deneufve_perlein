/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author ASUS
 */
public class PotionSoin extends Objet {
    private int soin ; 

    public PotionSoin(String n, String s, int p, int d) {
        super(n,s,p) ; 
        this.soin = d ;
    }
    
    public PotionSoin(Objet o, int d) {
        super(o) ; 
        this.soin = d ; 
    }
    
    public PotionSoin() {
        super() ; 
        this.soin = 0 ;  
    }

    public int getSoin() {
        return soin;
    }

    public void setSoin(int soin) {
        this.soin = soin;
    }
    
    
}
