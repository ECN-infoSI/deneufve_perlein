/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Classe représentant un loup, un type de monstre dans le jeu.
 * Hérite de la classe Monstre.
 */
public class Loup extends Monstre {

    /**
     * Constructeur avec paramètres.
     * 
     * @param ptVie Points de vie du loup.
     * @param degAtt Dégâts d'attaque.
     * @param ptPar Points de parade.
     * @param pageAtt Pourcentage d'attaque.
     * @param pagePar Pourcentage de parade.
     * @param pos Position du loup.
     */
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    /**
     * Constructeur par copie.
     * 
     * @param m Loup à copier.
     */
    public Loup(Loup m) {
        super(m);
    }

    /**
     * Constructeur par défaut.
     */
    public Loup() {
        super() ; 
        setPtVie(getPtVie()+20);
        setPagePar(getPagePar()+20);
        setPageAtt(getPageAtt()+20);
        setPtPar(getPtPar()+20);
        setDegAtt(getDegAtt()+20);
    }   
    
    /**
     * Méthode permettant au loup de combattre une créature.
     * Le combat se fait uniquement au corps-à-corps.
     * 
     * @param c La créature à combattre.
     */
    public void combattre(Creature c) {
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
