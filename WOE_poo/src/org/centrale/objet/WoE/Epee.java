/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author ASUS
 */
public class Epee extends Objet {
    private int degats ; 

    public Epee(String n, String s, int p, int d) {
        super(n,s,p) ; 
        this.degats = d ;
    }
    
    public Epee(Objet o, int d) {
        super(o) ; 
        this.degats = d ; 
    }
    
    public Epee() {
        super() ; 
        this.degats = 0 ;  
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
    
    
}
