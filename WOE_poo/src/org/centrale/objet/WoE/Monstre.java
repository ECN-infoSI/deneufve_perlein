/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe représentant un monstre dans le jeu.
 * Hérite de la classe Creature.
 */
public class Monstre extends Creature {
    
    /**
     * Constructeur avec paramètres.
     * 
     * @param ptVie Points de vie du monstre.
     * @param degAtt Dégâts d'attaque.
     * @param ptPar Points de parade.
     * @param pageAtt Pourcentage d'attaque.
     * @param pagePar Pourcentage de parade.
     * @param pos Position du monstre.
     */
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie,degAtt,ptPar,pageAtt,pagePar,pos);
    }
    
    /**
     * Constructeur par copie.
     * 
     * @param m Monstre à copier.
     */
    public Monstre(Monstre m) {
        super((Creature) m);
    }
    
    /**
     * Constructeur par défaut.
     */
    public Monstre() {
        super();       
    }

    /**
     * Affiche les informations du monstre, incluant ses points de vie, dégâts d'attaque,
     * points de parade, pourcentage d'attaque et de parade, ainsi que sa position.
     */
    public void affiche() {
        System.out.println("Point de vie = " + super.getPtVie());
        System.out.println("Degat d'attaque = " + super.getDegAtt());
        System.out.println("Points de parade = " + super.getPtPar());
        System.out.println("Portée d'attaque = " + super.getPageAtt());
        System.out.println("Portée de parade = " + super.getPagePar());
        super.getPos().affiche();
    }
}