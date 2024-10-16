/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.LinkedList;
import java.util.Random;

/**
 * Classe représentant un guerrier dans le jeu.
 * Hérite de la classe Personnage.
 */
public class Guerrier extends Personnage implements Combattant{
    
    /**
     * Épée utilisée par le guerrier.
     */

    /**
     * Constructeur avec paramètres.
     * 
     * @param n Nom du personnage.
     * @param pv Points de vie.
     * @param da Dégâts d'attaque.
     * @param ppar Pourcentage de parade.
     * @param paatt Pourcentage d'attaque.
     * @param papar Pourcentage de parade.
     * @param dmax Distance maximale d'attaque.
     * @param p Position.
     * @param e Épée du guerrier.
     */
    public Guerrier(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p) {
        super(n, pv, da, ppar, paatt, papar, dmax, p);
    }

    /**
     * Constructeur prenant un personnage et une épée.
     * 
     * @param p2 Personnage à copier.
     * @param e Épée à associer au guerrier.
     */
    public Guerrier(Personnage p2) {
        super(p2);
    }
    
    /**
     * Constructeur par copie d'un autre Guerrier.
     * 
     * @param p2 Guerrier à copier.
     */
    public Guerrier(Guerrier p2) {
        super((Personnage)p2); 
    }

    /**
     * Constructeur par défaut.
     */
    public Guerrier() {
        super();
      
        Random random = new Random();
        setPtVie(40+random.nextInt(20));
        setPagePar(40+random.nextInt(20));
        setPageAtt(60+random.nextInt(10));
        setPtPar(20+random.nextInt(10));
        setDegAtt(40+random.nextInt(10));     
    }    


    /**
     * Méthode permettant au guerrier de combattre une créature.
     * Le combat se fait uniquement au corps-à-corps.
     * 
     * @param c La créature à combattre.
     */
    
    @Override
    public void combattre(Creature c) {
        Random rand = new Random();
        double dist = super.getPos().distance(c.getPos());
        System.out.println(getNom()+" attaque la créature en position");
        c.getPos().affiche();
        if(dist==1){  //Le guerrier n'ayant pas de projectiles, seule la méthode au corps-à-corps est implémentée
                int tirageAtt = rand.nextInt(100);
                System.out.println(" _"+"\n"+"|"+tirageAtt+"|");
                if(tirageAtt<=super.getPageAtt()){
                    int tirageDef = rand.nextInt(100);    
                    if(tirageDef<=c.getPagePar()){
                        c.setPtVie(c.getPtVie()-super.getDegAtt());
                        System.out.println("Touché ! Le défenseur n'a plus que " + c.getPtVie()+"\n");
                    }
                    else{
                        System.out.println("Raté ! \n");
                    }
                }
                else{
                        System.out.println("Raté ! \n");
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