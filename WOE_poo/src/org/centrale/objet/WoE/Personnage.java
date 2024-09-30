/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Représente un personnage dans le jeu, héritant des caractéristiques d'une créature.
 *
 * @author benja
 */
public class Personnage extends Creature {
    private String nom;
    private int distAttMax;
  
    /**
     * Constructeur pour créer un personnage avec un nom, des points de vie,
     * des dégâts d'attaque, et d'autres caractéristiques.
     * 
     * @param n le nom du personnage
     * @param pv les points de vie du personnage
     * @param da les dégâts d'attaque
     * @param ppar les points de parade
     * @param paatt la portée d'attaque
     * @param papar la portée de parade
     * @param dmax la distance d'attaque maximale
     * @param p la position du personnage
     */
    public Personnage(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p) {
        super(pv, da, ppar, paatt, papar, p);
        nom = n;
        distAttMax = dmax;      
    }

    /**
     * Constructeur pour créer un personnage à partir d'un autre personnage.
     * 
     * @param c2 le personnage à copier
     */
    public Personnage(Personnage c2) {
        super((Creature)c2);
        nom = c2.nom;
        distAttMax = c2.distAttMax; 
    }

    /**
     * Constructeur par défaut, crée un personnage avec un nom par défaut
     * et une distance d'attaque maximale de zéro.
     */
    public Personnage() {
        super();
        nom = "SalamWEI";
        distAttMax = 0;
    }

    /**
     * Obtient le nom du personnage.
     * 
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du personnage.
     * 
     * @param n le nouveau nom du personnage
     */
    public void setNom(String n) {
        nom = n;
    }

    /**
     * Obtient la distance d'attaque maximale du personnage.
     * 
     * @return la distance d'attaque maximale
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * Définit la distance d'attaque maximale du personnage.
     * 
     * @param distAttMax la nouvelle distance d'attaque maximale
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * Affiche les informations du personnage.
     */
    public void affiche() {
        System.out.println("nom: " + nom);
        System.out.println("Point de vie = " + super.getPtVie());
        System.out.println("Dégât d'attaque = " + super.getDegAtt());
        System.out.println("Points de parade = " + super.getPtPar());
        System.out.println("Portée d'attaque = " + super.getPageAtt());
        System.out.println("Portée de parade = " + super.getPagePar());
        System.out.println("Distance d'attaque maximale = " + distAttMax);
        super.getPos().affiche();
    }
}
