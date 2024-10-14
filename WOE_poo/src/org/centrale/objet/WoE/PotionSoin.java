/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Représente une potion de soin dans le jeu.
 * Hérite de la classe {@link Objet}.
 *
 * @author ASUS
 */
public class PotionSoin extends Objet {
    private int soin ; 

    /**
     * Constructeur pour créer une potion de soin avec un nom, une description,
     * un prix et un montant de soin.
     * 
     * @param n le nom de la potion
     * @param s la description de la potion
     * @param pds le poids de la potion
     * @param d le montant de soin
     * @param pos Position de l'objet.
     */
    public PotionSoin(String n, String s, int pds, Point2D pos, int d) {
        super(n,s,pds,pos) ; 
        this.soin = d ;
    }
    
    /**
     * Constructeur pour créer une potion de soin à partir d'un objet existant
     * et d'un montant de soin.
     * 
     * @param o l'objet à copier
     * @param d le montant de soin
     */
    public PotionSoin(Objet o, int d) {
        super(o) ; 
        this.soin = d ; 
    }
    
    /**
     * Constructeur par défaut pour créer une potion de soin sans spécifications.
     */
    public PotionSoin() {
        super() ; 
        super.setNom(this.getClass().getSimpleName());
        this.soin = 10 ;  
    }

    /**
     * Obtient le montant de soin de la potion.
     * 
     * @return le montant de soin
     */
    public int getSoin() {
        return soin;
    }

    /**
     * Définit le montant de soin de la potion.
     * 
     * @param soin le nouveau montant de soin
     */
    public void setSoin(int soin) {
        this.soin = soin;
    }
    
     /**
     * fais disparaitre la potion
     */
    public void disparait(){
        super.setPos(null); 
    }
    
    public void affiche() {
        super.affiche() ; 
        System.out.println("Soin = " + soin) ; 
    }
}
