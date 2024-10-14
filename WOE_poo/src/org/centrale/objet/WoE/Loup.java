/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.LinkedList;
import java.util.Random;

/**
 * Classe représentant un loup, un type de monstre dans le jeu.
 * Hérite de la classe Monstre.
 */
public class Loup extends Monstre implements Combattant{

    /**
     * Constructeur avec paramètres.
     * 
     * @param ptVie Points de vie du loup.
     * @param degAtt Dégâts d'attaque.
     * @param ptPar Points de parade.
     * @param pageAtt Pourcentage d'attaque.
     * @param pagePar Pourcentage de parade.
     * @param pos Position du loup.
     */
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    /**
     * Constructeur par copie.
     * 
     * @param m Loup à copier.
     */
    public Loup(Loup m) {
        super(m);
    }

    /**
     * Constructeur par défaut.
     */
    public Loup() {
        super() ; 
        setPtVie(getPtVie()+20);
        setPagePar(getPagePar()+20);
        setPageAtt(getPageAtt()+20);
        setPtPar(getPtPar()+20);
        setDegAtt(getDegAtt()+20);
    }   
    
    /**
     * Méthode permettant au loup de combattre une créature.
     * Le combat se fait uniquement au corps-à-corps.
     * 
     * @param c La créature à combattre.
     */
    @Override
    public void combattre(Creature c) {
        Random rand = new Random();
        double dist = super.getPos().distance(c.getPos());
        System.out.println("Le monstre en position ");
        getPos().affiche();
        System.out.println("attaque la créature en position");
        c.getPos().affiche();
        if(dist==1){  //Le guerrier n'ayant pas de projectiles, seule la méthode au corps-à-corps est implémentée
                int tirageAtt = rand.nextInt(100);
                System.out.println(" _"+"\n"+"|"+tirageAtt+"|");
                if(tirageAtt<=super.getPageAtt()){
                    int tirageDef = rand.nextInt(100);    
                    if(tirageDef<=c.getPagePar()){
                        c.setPtVie(c.getPtVie()-super.getDegAtt());
                        System.out.println("Touché ! Le défenseur n'a plus que " + c.getPtVie());
                    }
                }
        }        
        else{
            System.out.println("La créature à combattre est trop loin !");
        }
    }

    @Override
    public LinkedList<Creature> creaturesAPortee(World w, int portee){
        LinkedList<Creature> creaturesAPortee = new LinkedList<>();
                    for (Personnage p : w.getPersonnages()) {
                        if (p.getPos().distance(super.getPos())<=portee) {
                            creaturesAPortee.add(p);
                        }
                    }
                    for (Monstre m : w.getMonstres()) {
                        if (m.getPos().distance(super.getPos())<=portee) {
                            creaturesAPortee.add(m);
                        }
                    }
                    
                    if (w.getJoueur().getPersoChoisi().getPos().distance(super.getPos())<=portee) {
                            creaturesAPortee.add(w.getJoueur().getPersoChoisi());
                    }
                    
                    creaturesAPortee.remove(this);
                    return creaturesAPortee;
    }
}
