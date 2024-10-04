/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

import javax.swing.SwingUtilities;

/**
 *
 * MAIN
 */
public class WoECN {
    public static void main(String[] args) {
        World w = new World();
        w.creeMondeAlea();
        w.etatPersonnages(w.getPersonnages());
        
        // Interface graphique
        SwingUtilities.invokeLater(() -> {
            WorldGUI gui = new WorldGUI();
            gui.setVisible(true);
        });
        
        // Test: Déplacement des objets
        // Affichage des positions initiales de toutes les créatures
        System.out.println("position des Mobs:");
        for (Personnage perso : w.getPersonnages()) {
            System.out.println(perso.getNom() + ":");
            perso.getPos().affiche();
        }
        // Déplacement de toutes les créatures
        for (Personnage perso : w.getPersonnages()) {
            perso.deplace(w.getTaille(), w.getPersonnages(), w.getMonstres(), w.getObjets()) ;
        }
        // Affichage des positions après déplacement
        System.out.println("position des Mobs apres deplacement:");
        for (Personnage perso : w.getPersonnages()) {
            System.out.println(perso.getNom() + ":");
            perso.getPos().affiche();
        }
        
    }
}
