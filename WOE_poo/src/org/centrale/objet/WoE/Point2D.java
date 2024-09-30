/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Représente un point en 2D avec des coordonnées x et y.
 *
 * @author benja
 */
public class Point2D {
    private int x;
    private int y;
    
    /**
     * Constructeur pour créer un point avec des coordonnées spécifiques.
     * 
     * @param xpos la coordonnée x du point
     * @param ypos la coordonnée y du point
     */
    public Point2D(int xpos, int ypos) {
            x = xpos;
            y = ypos;
    }

    /**
     * Constructeur pour créer un point à partir d'un autre point.
     * 
     * @param point le point à copier
     */
    public Point2D(Point2D point) {
            x = point.x;
            y = point.y;
    }

    /**
     * Constructeur par défaut, crée un point à l'origine (0, 0).
     */
    public Point2D() {
            x = 0;
            y = 0;
    }  
    
    /**
     * Définit la coordonnée x du point.
     * 
     * @param xpos la nouvelle coordonnée x
     */
    public void setxPoint2D(int xpos) {
        x = xpos;
    }
    
    /**
     * Définit la coordonnée y du point.
     * 
     * @param ypos la nouvelle coordonnée y
     */
    public void setyPoint2D(int ypos) {
        y = ypos;
    }

    /**
     * Obtient la coordonnée x du point.
     * 
     * @return la coordonnée x
     */
    public int getxpoint() {
        return x;
    }

    /**
     * Obtient la coordonnée y du point.
     * 
     * @return la coordonnée y
     */
    public int getypoint() {
        return y;
    }

    /**
     * Définit la position du point avec de nouvelles coordonnées.
     * 
     * @param xpos la nouvelle coordonnée x
     * @param ypos la nouvelle coordonnée y
     */
    public void setPosition(int xpos, int ypos) {
        x = xpos;
        y = ypos;
    }

    /**
     * Translate le point selon un déplacement donné.
     * 
     * @param dx le déplacement sur l'axe x
     * @param dy le déplacement sur l'axe y
     */
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Affiche les coordonnées du point.
     */
    public void affiche() {
        System.out.println("x= " + x + " y= " + y); 
    }

    /**
     * Calcule la distance entre ce point et un autre point.
     * 
     * @param p2 le second point
     * @return la distance entre les deux points
     */
    public double distance(Point2D p2) {
        return Math.sqrt((p2.x - x) * (p2.x - x) + (p2.y - y) * (p2.y - y));
    }
    
    /**
     * Vérifie si ce point est égal à un autre point.
     * 
     * @param p2 le point à comparer
     * @return true si les points sont égaux, false sinon
     */
    public boolean equal(Point2D p2) {
        return p2 != null && x == p2.x && y == p2.y; 
    }
}
