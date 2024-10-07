/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.LinkedList;
import java.util.Random;
/**
 * Classe représentant une créature dans le jeu.
 */
public abstract class Creature implements Deplacable{
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
        ptVie = 100;
        degAtt = 5;
        ptPar= 5;
        pageAtt = 20;
        pagePar= 20;
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
     * Déplace la créature aléatoirement une case horizontalement et/ou verticalement, en évitant les Creatures et limites de World.
     * 
     * @param w
     */ 
    
    @Override
    public void deplace(World w) {
        Random gen = new Random() ; 
        int dx = gen.nextInt(3) - 1 ; 
        int dy = gen.nextInt(3) - 1 ;
        Point2D nouvellePos = new Point2D(pos.getx() + dx, pos.gety() + dy);

        // Vérification des limites de la carte
        if (nouvellePos.getx() < 0 || nouvellePos.getx() >= w.getTaille() ||
            nouvellePos.gety() < 0 || nouvellePos.gety() >= w.getTaille()) {
            System.out.println("Deplacement impossible : hors des limites de la Map.");
            return; // Ne pas déplacer si en dehors des limites
        }
        // Vérification des collisions avec les autres w.getPersonnages()
        for (Personnage p : w.getPersonnages()) {
            if (!p.equals(this) && p.getPosition().equals(nouvellePos)) {   //le personnage peut rester statique
                System.out.println("Deplacement impossible : collision avec un Personnage");
                return; // Ne pas déplacer si un personnage est déjà à cette position
            }
        }
        // Vérification des collisions avec les monstres
        for (Monstre m : w.getMonstres()) {
            if (m.getPosition().equals(nouvellePos)) {
                return; // Ne pas déplacer si un monstre est déjà à cette position
            }
        }
        
        if (w.getPersoJoueur().getPos().equals(nouvellePos)) {
                return; // Ne pas déplacer si le joueur est déjà à cette position
            }
        // Si toutes les vérifications passent, on déplace le personnage
        pos = nouvellePos; // Mise à jour de la position
        
        LinkedList<Objet> potionsDel = new LinkedList<>();
        for (Objet o : w.getObjets()) {
            if (nouvellePos.equals(o.getPos()) && (o instanceof PotionSoin)) {
                PotionSoin p = (PotionSoin) o; 
                ptVie += p.getSoin(); 
                potionsDel.add(o);
                System.out.println("Potion de soin utilisee, points de vie : " + p.getSoin());
            }
        }
        for (Objet pDel : potionsDel){      //on retire les potions bus du monde ici pour éviter les conflits d'accès
            LinkedList<Objet> objets = w.getObjets();
            objets.remove(pDel); // Supprimer l'objet pDel
            w.setObjets(objets); 
        }
    }
    
    
    
 /**
     * @return la position de la creature
     */
    public Point2D getPosition() {
        return pos;
    }

    public abstract void affiche(); 
}
