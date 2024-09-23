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
public class Loup extends Monstre {

    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    public Loup(Loup m) {
        super(m);
    }

    public Loup() {
        super() ; 
    }   
    
    public void combattre(Creature c){
    Random rand = new Random();
    double dist = super.getPos().distance(c.getPos());
    if(dist==1){  //Le loup n'ayant pas de projectiles, seule la méthode au corps-à-corps est implémentée
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
