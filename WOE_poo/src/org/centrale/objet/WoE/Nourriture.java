/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author ASUS
 */
public class Nourriture extends Objet{
    private int temps_effet;
    
    public Nourriture(String n, String s, int pds, Point2D pos, int d) {
        super(n,s,pds,pos) ; 
        this.temps_effet = d ;
    }
    
    public Nourriture(Objet o, int d){
        super(o) ; 
        this.temps_effet = d ; 
    }
    
    public Nourriture(Nourriture oo){
        super((Objet) oo) ; 
        this.temps_effet = oo.temps_effet ; 
    }
    
    public Nourriture(){
        super() ; 
        this.temps_effet = 0 ; 
    }
    
    public int getTemps(){
        return temps_effet; 
    }
    
    public void setTemps(int t){
        temps_effet = t ;
    }
    
    public void disparait(){
        super.setPos(null); 
    }
    
    public void affiche() {
        super.affiche() ; 
        System.out.println("Temps d'effet = " + temps_effet) ; 
    }
    
}
