/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author benja
 */
public class WoECN {
    public static void main(String[] args) {
        World w1 =  new World();
        LinkedList<Personnage> personnages = w1.creerPersonnagesAlea();
        LinkedList<Monstre> monstres = w1.creerMonstresAlea();
        LinkedList<Objet> objets = w1.creerObjetsAlea();
        int taille = 1000;
        World w = new World(personnages, monstres, objets, taille);
        w.creeMondeAlea();
        
        // Test: Déplacement des objets
        // Affichage des positions initiales de toutes les créatures
        System.out.println("position des Mobs:");
        for (Creature creature : w.getPersonnages()) {
            System.out.println(creature.getClass().getSimpleName() + ":");
            creature.getPos().affiche();
        }
        // Déplacement de toutes les créatures
        for (Creature creature : w.getPersonnages()) {
            creature.deplace(taille, objets);
        }
        // Affichage des positions après déplacement
        System.out.println("position des Mobs après déplacement:");
        for (Creature creature : w.getPersonnages()) {
            System.out.println(creature.getClass().getSimpleName() + ":");
            creature.getPos().affiche();
        }
        
    }
}
