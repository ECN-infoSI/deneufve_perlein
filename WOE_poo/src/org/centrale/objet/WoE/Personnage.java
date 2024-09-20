/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author benja
 */
public class Personnage extends Creature {
    private String nom;
    private int distAttMax;
  
    public Personnage(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p){
        super(pv,da,ppar,paatt,papar,p);
        nom = n;
        distAttMax = dmax;      
    }
    public Personnage(Personnage c2){
        super((Creature)c2);
        nom = c2.nom;
        distAttMax = c2.distAttMax; 
    }
    public Personnage(){
        super();
        nom = "SalamWEI";
        distAttMax = 0;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String n){
        nom  = n;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public void affiche(){
        System.out.println("nom: " + nom);
        System.out.println("Point de vie = " + super.getPtVie());
        System.out.println("Degat d'attaque = " + super.getDegAtt());
        System.out.println("Points de parade = " + super.getPtPar());
        System.out.println("Portée d'attaque = " + super.getPageAtt());
        System.out.println("Portée de parade = " + super.getPagePar());
        System.out.println("Distance d'attaque maximale = " + distAttMax);
        super.getPos().affiche();
    }
}
