/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author benja
 */
public class Archer extends Personnage{
    private int nbFleches;

    public Archer(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p, int nbFlchs) {
        super(n, pv, da, ppar, paatt, papar, dmax, p);
        this.nbFleches = nbFlchs;
    }

    public Archer(Personnage p2, int nbFlchs) {
        super(p2);
        this.nbFleches = nbFlchs;
    }
    
    public Archer(Archer a2) {
        super((Personnage)a2);
        this.nbFleches = a2.nbFleches;      
    }

    public Archer() {
        super();
        this.nbFleches = 0;
    }  
    
    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    public void combattre(Creature c){
    Random rand = new Random();
    double dist = super.getPos().distance(c.getPos());
    if(dist<super.getDistAttMax()){
        if(dist==1){
            int tirageAtt = rand.nextInt(100);
            if(tirageAtt<=super.getPageAtt()){
                int tirageDef = rand.nextInt(100);    
                if(tirageDef<=c.getPagePar()){
                    c.setPtVie(c.getPtVie()-super.getDegAtt());
                }
            }
        }
        else{
            if(nbFleches>0){
                nbFleches--;
                int tirageAtt = rand.nextInt(100);
                if(tirageAtt<=super.getPageAtt()){
                    c.setPtVie(c.getPtVie()-super.getDegAtt()); //à distance, le def subit directement les dégats 
                }
            }
        }
    }
    else{
        System.out.println("La créature à combattre est trop loin !");
    }
}
}