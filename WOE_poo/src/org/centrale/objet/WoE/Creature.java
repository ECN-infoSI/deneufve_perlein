/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.LinkedList;
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
        ptVie = 10;
        degAtt = 0;
        ptPar= 5;
        pageAtt = 0;
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
     * @param dx
     * @param dy
     * @return 
     */ 
    
    @Override
    public boolean deplace(World w, int dx, int dy) {
        Point2D nouvellePos = new Point2D(pos.getx() + dx, pos.gety() + dy);
        if (deplacementPossible(nouvellePos, w)){
            // Si toutes les vérifications passent, on déplace le personnage
            pos = nouvellePos; // Mise à jour de la position
            boirePotion(w);
            return true;
        }
        else{ return false; }
    }
    
     /**
     * Vérification des limites de la carte, de la limite de déplacement, des collisions
     * 
     * @param posTest
     * @param w
     * @return 
     */ 
    public boolean deplacementPossible(Point2D posTest, World w){
        boolean libre = true;
            if (posTest.getx() < 0 || posTest.getx() >= w.getTaille() ||
                posTest.gety() < 0 || posTest.gety() >= w.getTaille() || posTest.distance(pos)>=2) { //les créatures peuvent se déplacer d'une case (>=2 pour la diagonale)
                libre = false;
            }
            for (Personnage p : w.getPersonnages()) {
                if (p.getPos().equals(posTest)) {
                    libre = false;
                }    
            }
            for (Monstre m : w.getMonstres()) {
                if (m.getPos().equals(posTest)) {
                    libre = false;
                }
            }
            if (w.getJoueur().getPersoChoisi().getPos().equals(posTest)) {
                libre = false;
            }
        return libre;
    }
    
    public LinkedList<Point2D> casesAtteignables(World w){
        LinkedList<Point2D> casesAtteignables = new LinkedList<>();
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                Point2D posTestee = new Point2D(pos.getx() + i-1, pos.gety() + j-1);
                if (deplacementPossible(posTestee,w)){
                    casesAtteignables.add(posTestee); 
                }
            }
        }
        return casesAtteignables;
    }

    /**
     * Permet à la créature de boire une potion sur sa case
     * 
     * @param w
     */ 
    public void boirePotion(World w){
        ArrayList<Objet> potionsDel = new ArrayList<>();
            for (Objet o : w.getObjets()) {
                if (pos.equals(o.getPos()) && (o instanceof PotionSoin)) {
                    PotionSoin p = (PotionSoin) o; 
                    ptVie += p.getSoin(); 
                    potionsDel.add(o);
                    System.out.println("Potion de soin utilisee, points de vie : " + p.getSoin());
                }
            }
            for (Objet pDel : potionsDel){      //on retire les potions bus du monde ici pour éviter les conflits d'accès
                LinkedList<Objet> objets = w.getObjets();
                objets.remove(pDel);            // Supprimer l'objet pDel
                w.setObjets(objets); 
            }
    }

    public abstract void affiche(); 
}
