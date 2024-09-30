/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
/**
 * Classe représentant une créature dans le jeu.
 */
public class Creature {
    /**
     * Points de vie de la créature.
     */
    private int ptVie;   
    
    /**
     * Dégâts d'une attaque.
     */
    private int degAtt;
    
    /**
     * Points de parade.
     */
    private int ptPar;
    
    /**
     * Pourcentage d'attaque.
     */
    private int pageAtt;
    
    /**
     * Pourcentage de parade.
     */
    private int pagePar;
    
    /**
     * Position de la créature.
     */
    private Point2D pos;

    /**
     * Constructeur avec paramètres.
     * 
     * @param ptVie Points de vie.
     * @param degAtt Dégâts d'une attaque.
     * @param ptPar Points de parade.
     * @param pageAtt Pourcentage d'attaque.
     * @param pagePar Pourcentage de parade.
     * @param pos Position.
     */
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }
    
    /**
     * Constructeur de recopie.
     * 
     * @param c Créature à copier.
     */
    public Creature(Creature c) {
        ptVie = c.ptVie;
        degAtt = c.degAtt;
        ptPar= c.ptPar;
        pageAtt = c.pageAtt;
        pagePar= c.pagePar;
        pos = c.pos;        
    }

    /**
     * Constructeur par défaut.
     */
    public Creature() {
        ptVie = 0;
        degAtt = 0;
        ptPar= 0;
        pageAtt = 0;
        pagePar= 0;
        pos = new Point2D(0,0);        
    }

    /**
     * Retourne les points de vie de la créature.
     * 
     * @return Points de vie.
     */
    public int getPtVie() {
            return ptVie;
        }

    /**
     * Retourne les dégâts d'une attaque.
     * 
     * @return Dégâts d'une attaque.
     */
        public int getDegAtt() {
            return degAtt;
        }

    /**
     * Retourne les points de parade.
     * 
     * @return Points de parade.
     */
        public int getPtPar() {
            return ptPar;
        }

    /**
     * Retourne le pourcentage d'attaque.
     * 
     * @return Pourcentage d'attaque.
     */
        public int getPageAtt() {
            return pageAtt;
        }

    /**
     * Retourne le pourcentage de parade.
     * 
     * @return Pourcentage de parade.
     */
        public int getPagePar() {
            return pagePar;
        }

    /**
     * Retourne la position de la créature.
     * 
     * @return Position.
     */
        public Point2D getPos() {
            return pos;
        }

    /**
     * Définit les points de vie de la créature.
     * 
     * @param ptVie Points de vie à définir.
     */
        public void setPtVie(int ptVie) {
            this.ptVie = ptVie;
        }

    /**
     * Définit les dégâts d'attaque.
     * 
     * @param degAtt Dégâts à définir.
     */
        public void setDegAtt(int degAtt) {
            this.degAtt = degAtt;
        }

    /**
     * Définit les points de parade.
     * 
     * @param ptPar Points de parade à définir.
     */
        public void setPtPar(int ptPar) {
            this.ptPar = ptPar;
        }

    /**
     * Définit le pourcentage d'attaque.
     * 
     * @param pageAtt Pourcentage d'attaque à définir.
     */
        public void setPageAtt(int pageAtt) {
            this.pageAtt = pageAtt;
        }

    /**
     * Définit le pourcentage de parade.
     * 
     * @param pagePar Pourcentage de parade à définir.
     */
        public void setPagePar(int pagePar) {
            this.pagePar = pagePar;
        }

    /**
     * Définit la position de la créature.
     * 
     * @param pos Position à définir.
     */
        public void setPos(Point2D pos) {
            this.pos = pos;
        }
        
/**
     * Déplace la créature aléatoirement dans une zone de taille définie.
     * 
     * @param taille Taille du monde.
     */ 
    public void deplace(int taille, LinkedList<Objet> objets){
        // on prends les objets disponibles en argument
        
        Random gen = new Random() ; 
        int dx = gen.nextInt(2) - 1 ; 
        int dy = gen.nextInt(2) - 1 ;
        pos.translate(dx, dy);
        if (pos.getxpoint() > taille) { pos.setxPoint2D(taille); }
        if (pos.getxpoint() < 0) { pos.setxPoint2D(0); }
        if (pos.getypoint() > taille) { pos.setyPoint2D(taille); }
        if (pos.getypoint() < 0) { pos.setyPoint2D(0); }
        
        pos.translate(dx, dy);
        for (Objet o : objets) {
            if (pos.equals(o.getPos()) && (o instanceof PotionSoin)){
                PotionSoin p = (PotionSoin) o;
                ptVie+=p.getSoin();
                p.disparait();
                objets.remove(o);
            }           
        }
    }
}
