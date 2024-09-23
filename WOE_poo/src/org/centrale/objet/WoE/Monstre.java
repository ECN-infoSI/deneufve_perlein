/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author benja
 */
public class Monstre extends Creature {
    
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie,degAtt,ptPar,pageAtt,pagePar,pos);
    }
    
    public Monstre(Monstre m){
        super((Creature)m);       
    }
    
    public Monstre(){
        super();       
    }

public void affiche(){
        System.out.println("Point de vie = " + super.getPtVie());
        System.out.println("Degat d'attaque = " + super.getDegAtt());
        System.out.println("Points de parade = " + super.getPtPar());
        System.out.println("Portée d'attaque = " + super.getPageAtt());
        System.out.println("Portée de parade = " + super.getPagePar());
        super.getPos().affiche();
    }
}