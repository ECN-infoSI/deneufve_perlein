/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * MAIN
 */
public class WoECN {
    public static void main(String[] args) {
        World w = new World();
        w.creeMondeAlea();
        
        // Interface graphique
        WorldGUI gui = new WorldGUI(w);
        gui.setVisible(true);
        
        while(true){
            int nbTour = 0;
            w.tourDeJeu(nbTour);
            SwingUtilities.invokeLater(gui::afficherMonde); // Rafraîchir l'interface graphique
            for (Personnage perso : w.getPersonnages()) {
                    // Déplacer chaque personnage d'une unité dans une direction aléatoire
                    perso.deplace(w.getTaille(), w.getPersonnages(), w.getMonstres(), w.getObjets());
            }
            
            for (Monstre monstre : w.getMonstres()) {
            // Déplacer chaque personnage d'une unité dans une direction aléatoire
                    monstre.deplace(w.getTaille(), w.getPersonnages(), w.getMonstres(), w.getObjets());
            }
            
            SwingUtilities.invokeLater(gui::afficherMonde); // Rafraîchir l'interface graphique
            nbTour++;
        }
    }
}