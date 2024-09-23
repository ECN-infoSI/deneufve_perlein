/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author ASUS
 */
public class Objet {
    
    private String nom ; 
    private String style ; 
    private int poids ; 
    
    public Objet(String n, String pds, int p) {
        nom = n; 
        style = pds ; 
        poids = p; 
    }
    
    public Objet(Objet oo) {
        nom = oo.nom ; 
        style = oo.style ; 
        poids = oo.poids ; 
    }
    
    public Objet() {
        nom = "Sable" ;
        style = "Pas bien" ; 
        poids = 0 ;        
    }

    public String getNom() {
        return nom;
    }

    public String getPoint_de_style() {
        return style;
    }

    public int getPoids() {
        return poids;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoint_de_style(String style) {
        this.style = style;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
    
    public void affiche() {
        System.out.println("nom : " + nom) ;
        System.out.println("Style de l'objet : " + style) ; 
        System.out.println("Poids = " + poids) ; 
    }
    
}
