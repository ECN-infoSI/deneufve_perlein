/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.LinkedList;

/**
 * Représente un paysan, héritant des caractéristiques d'un personnage.
 *
 * @author benja
 */
public class Paysan extends Personnage{

    /**
     * Constructeur pour créer un paysan avec un nom, des points de vie,
     * des dégâts d'attaque, et d'autres caractéristiques.
     * 
     * @param n le nom du paysan
     * @param pv les points de vie du paysan
     * @param da les dégâts d'attaque
     * @param ppar les points de parade
     * @param paatt la portée d'attaque
     * @param papar la portée de parade
     * @param dmax la distance d'attaque maximale
     * @param p la position du paysan
     */
    public Paysan(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p) {
        super(n, pv, da, ppar, paatt, papar, dmax, p);
    }

    /**
     * Constructeur pour créer un paysan à partir d'un autre paysan.
     * 
     * @param p2 le paysan à copier
     */
    public Paysan(Paysan p2) {
        super(p2);
    }

    /**
     * Constructeur par défaut, crée un paysan avec des valeurs par défaut.
     */
    public Paysan() {
        super();
    }
    
    @Override
    public void combattre(Creature c) {
        System.out.println("Le paysan ne peut pas combattre !");
    }
    
    @Override
    public LinkedList<Creature> creaturesAPortee(World w, int portee) {
        System.out.println("Le paysan ne peut pas combattre !");
        return new LinkedList<>();
    }
}
