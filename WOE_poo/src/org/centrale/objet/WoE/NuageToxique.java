/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.LinkedList;

/**
 *
 * @author ASUS
 */
public class NuageToxique extends Objet{
    private int degats ; 
    private int rayon ; 
    


 /**
     * Constructeur pour créer un nuage toxique.
     * 
     * @param n le nom de la potion
     * @param s la description de la potion
     * @param pds le poids de la potion
     * @param d la quantité de dégats
     * @param ray le rayon du nuage
     * @param pos Position de l'objet (centre du nuage)
     */

    public NuageToxique(String n, String s, int pds, Point2D pos, int d, int ray) {
        super(n,s,pds,pos) ; 
        this.degats = d ;
        this.rayon = ray ;
    }
    
    /**
     * Constructeur pour créer un nuage toxique à partir d'un objet existant,
     * d'un montant de dégats et d'un rayon
     * 
     * @param o l'objet à copier
     * @param d le nombre de dégats 
     * @param ray le rayon du nuage
     */
    public NuageToxique(Objet o, int d, int ray) {
        super(o) ; 
        this.degats = d ; 
        this.rayon = ray ;
    }
    
    /**
     * Constructeur par défaut pour créer un nuage toxique sans spécifications.
     */
    public NuageToxique() {
        super() ; 
        super.setNom(this.getClass().getSimpleName());
        this.degats = 10 ;  
        this.rayon = 3 ;
    }

    /**
     * Obtient le montant de degats du nuage.
     * 
     * @return le montant de degats
     */
    public int getDegats() {
        return degats;
    }
    
    /**
     * Obtient le rayon nuage.
     * 
     * @return le rayon du nuage
     */
    public int getRayon() {
        return rayon;
    }

    /**
     * Définit le montant de degats du nuage.
     * 
     * @param degats le nouveau montant de degats
     */
    public void setDegats(int degats) {
        this.degats = degats;
    }
    
    /**
     * Définit le rayon du nuage.
     * 
     * @param rayon le nouveau rayon 
     */
    public void setRayon(int rayon) {
        this.rayon = rayon;
    }
    
    
     /**
     * fais disparaitre le nuage
     */
    public void disparait(){
        super.setPos(null); 
    }
    
    /**
     * Une fois déclenché, définit la zone contaminée par le nuage toxique
     * 
     * @param taille_monde la taille du monde (pour ne pas sortir de celui-ci)
     * @return liste de points infectées par la zone toxique
     */
    public LinkedList<Point2D> zoneToxique(int taille_monde){
        
        Point2D pos = super.getPos() ;
        
        int bas = Math.max(pos.getx() - rayon,0) ;  
        int gauche = Math.max(pos.gety()- rayon,0) ;  
        int droite = Math.max(pos.gety() + rayon,taille_monde) ;  
        int haut = Math.max(pos.getx() + rayon,taille_monde) ; 
        LinkedList<Point2D> zone_toxique = new LinkedList<>();
        
        for (int i=bas; i<=haut; i++){
            for (int j=gauche; j<=droite; j++){
                if (pos.distance(new Point2D(i,j))<=rayon) {
                    zone_toxique.add(new Point2D(i,j)) ; 
                }
            }
        }
        
        return zone_toxique ;
    }
    
    public void affiche() {
        super.affiche() ; 
        System.out.println("Degats = " + degats) ; 
        System.out.println("Rayon = " + rayon) ; 
    }
}

