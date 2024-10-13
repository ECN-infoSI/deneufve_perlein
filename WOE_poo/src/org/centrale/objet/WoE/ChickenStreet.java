/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author ASUS
 */


public class ChickenStreet extends Nourriture{
    private int par ; 
    
    
    public ChickenStreet(String n, String s, int pds, Point2D pos, int d, int degaaa) {
        super(n,s,pds,pos,d) ; 
        this.par = degaaa ; 
}
    public ChickenStreet(Nourriture n, int de){
        super(n); 
        this.par = de ;
    }
    
    public ChickenStreet() {
        super(); 
        this.par = 1 ; 
    }
    
    public int getDegats() {
        return par ; 
    }
    
    public void setDegats(int d) {
        par = d ;
    }
    
    public void affiche() {
        super.affiche() ; 
        System.out.println("Points de parade retirés = " + par) ; 
    }
}
