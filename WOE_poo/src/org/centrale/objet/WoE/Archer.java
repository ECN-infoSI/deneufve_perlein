/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.LinkedList;
import java.util.Random;

/**
 * Classe représentant un archer dans le jeu.
 * Hérite de la classe Personnage.
 */
public class Archer extends Personnage implements Combattant{
    /**
     * Nombre de flèches de l'archer.
     */
    private int nbFleches;

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
     * @param nbFlchs Nombre de flèches.
     */
    public Archer(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p, int nbFlchs) {
        super(n, pv, da, ppar, paatt, papar, dmax, p);
        this.nbFleches = nbFlchs;
    }

    /**
     * Constructeur prenant un personnage et un nombre de flèches.
     * 
     * @param p2 Personnage à copier.
     * @param nbFlchs Nombre de flèches.
     */
    public Archer(Personnage p2, int nbFlchs) {
        super(p2);
        this.nbFleches = nbFlchs;
    }
    
    /**
     * Constructeur par copie d'un autre Archer.
     * 
     * @param a2 Archer à copier.
     */
    public Archer(Archer a2) {
        super((Personnage)a2);
        this.nbFleches = a2.nbFleches;      
    }

    /**
     * Constructeur par défaut.
     */
    public Archer() {
        super();
        
        Random random = new Random();
        setPtVie(getPtVie()+20+random.nextInt(10));
        setPagePar(getPagePar()+20+random.nextInt(10));
        setPageAtt(getPageAtt()+50+random.nextInt(10));
        setPtPar(getPtPar()+20+random.nextInt(10));
        setDegAtt(getDegAtt()+10+random.nextInt(10));   
        setDistAttMax(3);   
        this.nbFleches = 5;
    }  
    
    /**
     * Retourne le nombre de flèches de l'archer.
     * 
     * @return Nombre de flèches.
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     * Définit le nombre de flèches de l'archer.
     * 
     * @param nbFleches Nombre de flèches à définir.
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    /**
     * Méthode permettant à l'archer de combattre une créature.
     * 
     * @param c La créature à combattre.
     */
    @Override
    public void combattre(Creature c) {
        Random rand = new Random();
        double dist = super.getPos().distance(c.getPos());
        if(dist<=super.getDistAttMax()){
            if(dist==1){
                int tirageAtt = rand.nextInt(100);
                if(tirageAtt<=super.getPageAtt()){
                    int tirageDef = rand.nextInt(100);    
                    if(tirageDef<=c.getPagePar()){
                        c.setPtVie(c.getPtVie()-super.getDegAtt());
                    }
                }
            }
            else{
                if(nbFleches>0){
                    nbFleches--;
                    int tirageAtt = rand.nextInt(100);
                    if(tirageAtt<=super.getPageAtt()){
                        c.setPtVie(c.getPtVie()-super.getDegAtt()); //à distance, le def subit directement les dégats 
                    }
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