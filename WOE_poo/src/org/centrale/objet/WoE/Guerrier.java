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
public class Guerrier extends Personnage{
    private Epee e;

    public Guerrier(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p, Epee e) {
        super(n, pv, da, ppar, paatt, papar, dmax, p);
        this.e = e;
    }

    public Guerrier(Personnage p2, Epee e) {
        super(p2);
        this.e = e;
    }
    
    public Guerrier(Guerrier p2) {
        super((Personnage)p2);
        this.e = p2.e;      
    }

    public Guerrier() {
    }    

    public void setE(Epee e) {
        this.e = e;
    }

    public Epee getE() {
        return e;
    }
public void combattre(Creature c){
    Random rand = new Random();
    double dist = super.getPos().distance(c.getPos());
    if(dist==1){  //Le guerrier n'ayant pas de projectiles, seule la méthode au corps-à-corps est implémentée
            int tirageAtt = rand.nextInt(100);
            if(tirageAtt<=super.getPageAtt()){
                int tirageDef = rand.nextInt(100);    
                if(tirageDef<=c.getPagePar()){
                    c.setPtVie(c.getPtVie()-super.getDegAtt());
                }
            }
    }        
    else{
        System.out.println("La créature à combattre est trop loin !");
    }
}
}