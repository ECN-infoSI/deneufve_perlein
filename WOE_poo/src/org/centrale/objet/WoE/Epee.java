/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe représentant une épée, un type d'objet dans le jeu.
 * Hérite de la classe Objet.
 */
public class Epee extends Objet {
    /**
     * Dégâts infligés par l'épée.
     */
    
    private int degats ; 

    /**
     * Constructeur avec paramètres.
     * 
     * @param n Nom de l'objet.
     * @param s Statut de l'objet.
     * @param pds Poids de l'objet.
     * @param d Dégâts de l'épée.
     */
    
    public Epee(String n, String s, int pds, Point2D pos, int d) {
        super(n,s,pds,pos) ; 
        this.degats = d ;
    }
    
    /**
     * Constructeur prenant un objet et définissant les dégâts.
     * 
     * @param o Objet à partir duquel l'épée est créée.
     * @param d Dégâts de l'épée.
     */
    public Epee(Objet o, int d) {
        super(o) ; 
        this.degats = d ; 
    }
    
    /**
     * Constructeur par défaut.
     */
    public Epee() {
        super() ; 
        this.degats = 0 ;  
    }

    /**
     * Retourne les dégâts infligés par l'épée.
     * 
     * @return Dégâts de l'épée.
     */
    public int getDegats() {
        return degats;
    }

    /**
     * Définit les dégâts de l'épée.
     * 
     * @param degats Dégâts à définir.
     */
    public void setDegats(int degats) {
        this.degats = degats;
    }
}
