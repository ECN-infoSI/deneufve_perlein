/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author ASUS
 */
public class PouletMadras extends Nourriture {
    private int degats ;
    
    public PouletMadras(String n, String s, int pds, Point2D pos, int d, int degaaa) {
        super(n,s,pds,pos,d) ; 
        this.degats = degaaa ; 
}
    public PouletMadras(Nourriture n, int de){
        super(n); 
        this.degats = de ;
    }
    
    public PouletMadras() {
        super(); 
        this.degats = 1 ; 
    }
    
    public int getDegats() {
        return degats ; 
    }
    
    public void setDegats(int d) {
        degats = d ;
    }
    
    public void affiche() {
        super.affiche() ; 
        System.out.println("Degats supplémentaires = " + degats) ; 
    }
}

    
