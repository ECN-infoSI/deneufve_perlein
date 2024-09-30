/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;
/**
 *
 * @author benja
 */
public class WoECN {
    public static void main(String[] args) {
        World w = new World();
        w.creeMondeAlea();
        w.etatPersonnages(w.getPersonnages());
        // Test: Déplacement des objets
        // Affichage des positions initiales de toutes les créatures
        System.out.println("position des Mobs:");
        for (Creature creature : w.getPersonnages()) {
            System.out.println(creature.getClass().getSimpleName() + ":");
            creature.getPos().affiche();
        }
        // Déplacement de toutes les créatures
        for (Creature creature : w.getPersonnages()) {
            creature.deplace(w.getTaille(), w.getPersonnages(), w.getMonstres(), w.getObjets()) ;
        }
        // Affichage des positions après déplacement
        System.out.println("position des Mobs après déplacement:");
        for (Creature creature : w.getPersonnages()) {
            System.out.println(creature.getClass().getSimpleName() + ":");
            creature.getPos().affiche();
        }
        
    }
}
