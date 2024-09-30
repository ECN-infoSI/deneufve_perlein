/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe représentant un objet générique dans le jeu.
 * Un objet a un nom, un style et un poids.
 */
public class Objet {
    
    private String nom ; 
    private String style ; 
    private int poids ; 
    private Point2D pos;
    
    /**
     * Constructeur avec paramètres.
     * 
     * @param n Nom de l'objet.
     * @param s Style de l'objet.
     * @param pds Poids de l'objet.
     * @param pos Position de l'objet.
     */
    public Objet(String n, String s, int pds, Point2D p) {
        nom = n; 
        style = s ; 
        poids = pds;
        pos = p;
    }
    
    /**
     * Constructeur par copie.
     * 
     * @param oo Objet à copier.
     */
    public Objet(Objet oo) {
        nom = oo.nom ; 
        style = oo.style ; 
        poids = oo.poids ;
        pos = oo.pos ;
    }
    
    /**
     * Constructeur par défaut.
     * Initialise un objet avec des valeurs par défaut.
     */
    public Objet() {
        nom = "Sable" ;
        style = "Pas bien" ; 
        poids = 0 ;        
    }

    /**
     * Retourne le nom de l'objet.
     * 
     * @return Le nom de l'objet.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le style de l'objet.
     * 
     * @return Le style de l'objet.
     */
    public String getPoint_de_style() {
        return style;
    }

    /**
     * Retourne le poids de l'objet.
     * 
     * @return Le poids de l'objet.
     */
    public int getPoids() {
        return poids;
    }

    public Point2D getPos() {
        return pos;
    }
    
    /**
     * Définit le nom de l'objet.
     * 
     * @param nom Nouveau nom de l'objet.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le style de l'objet.
     * 
     * @param style Nouveau style de l'objet.
     */
    public void setPoint_de_style(String style) {
        this.style = style;
    }

    /**
     * Définit le poids de l'objet.
     * 
     * @param poids Nouveau poids de l'objet.
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }
    
    public void setPos(Point2D pos) {
            this.pos = pos;
        }
    
    public void affiche() {
        System.out.println("nom : " + nom) ;
        System.out.println("Style de l'objet : " + style) ; 
        System.out.println("Poids = " + poids) ; 
    }
    
}
