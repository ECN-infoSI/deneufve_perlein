/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Classe représentant un guerrier dans le jeu.
 * Hérite de la classe Personnage.
 */
public class Guerrier extends Personnage {
    
    /**
     * Épée utilisée par le guerrier.
     */
    private Epee e;

    /**
     * Constructeur avec paramètres.
     * 
     * @param n Nom du personnage.
     * @param pv Points de vie.
     * @param da Dégâts d'attaque.
     * @param ppar Pourcentage de parade.
     * @param paatt Pourcentage d'attaque.
     * @param papar Pourcentage de parade.
     * @param dmax Distance maximale d'attaque.
     * @param p Position.
     * @param e Épée du guerrier.
     */
    public Guerrier(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p, Epee e) {
        super(n, pv, da, ppar, paatt, papar, dmax, p);
        this.e = e;
    }

    /**
     * Constructeur prenant un personnage et une épée.
     * 
     * @param p2 Personnage à copier.
     * @param e Épée à associer au guerrier.
     */
    public Guerrier(Personnage p2, Epee e) {
        super(p2);
        this.e = e;
    }
    
    /**
     * Constructeur par copie d'un autre Guerrier.
     * 
     * @param p2 Guerrier à copier.
     */
    public Guerrier(Guerrier p2) {
        super((Personnage)p2);
        this.e = p2.e;      
    }

    /**
     * Constructeur par défaut.
     */
    public Guerrier() {
        super();
      
        Random random = new Random();
        setPtVie(getPtVie()+20+random.nextInt(10));
        setPagePar(getPagePar()+20+random.nextInt(10));
        setPageAtt(getPageAtt()+20+random.nextInt(10));
        setPtPar(getPtPar()+20+random.nextInt(10));
        setDegAtt(getDegAtt()+20+random.nextInt(10));   //plus de dégats que Archer
        this.e = new Epee();
    }    

    /**
     * Définit l'épée du guerrier.
     * 
     * @param e Épée à définir.
     */
    public void setE(Epee e) {
        this.e = e;
    }

    /**
     * Retourne l'épée du guerrier.
     * 
     * @return Épée du guerrier.
     */
    public Epee getE() {
        return e;
    }

    /**
     * Méthode permettant au guerrier de combattre une créature.
     * Le combat se fait uniquement au corps-à-corps.
     * 
     * @param c La créature à combattre.
     */
    
    @Override
    public void combattre(Creature c) {
    Random rand = new Random();
    double dist = super.getPos().distance(c.getPos());
    if(dist==1){  //Le guerrier n'ayant pas de projectiles, seule la méthode au corps-à-corps est implémentée
            int tirageAtt = rand.nextInt(100);
            if(tirageAtt<=super.getPageAtt()){
                int tirageDef = rand.nextInt(100);    
                if(tirageDef<=c.getPagePar()){
                    c.setPtVie(c.getPtVie()-super.getDegAtt());
                    System.out.println("Touché !");
                }
            }
    }        
    else{
        System.out.println("La créature à combattre est trop loin !");
    }
}
}