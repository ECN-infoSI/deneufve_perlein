/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import static org.centrale.objet.WoE.Personnage.loadNamesFromFile;

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
     * @param pos Position de l'objet.
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
        this.degats = 10 ;
        try {
            // Charger noms depuis les fichiers texte
            List<String> noms = loadNamesFromFile("C:/Users/benja/Documents/01_InfoSI/OBJET/deneufve_perlein/WOE_poo/sword_names_frappe_du_quartier_100.txt");
            // Générer et afficher un nom
            Random random = new Random();
            super.setNom(noms.get(random.nextInt(noms.size())));
        } catch (IOException e) {
            super.setNom("frappe du quartier");
        }
        
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
    
    public void affiche() {
        super.affiche() ; 
        System.out.println("Dégats = " + degats) ; 
    }
}
