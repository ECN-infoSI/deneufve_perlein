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
    public static void main(String[] args) throws InterruptedException {
        World w = new World();
        
        // Interface graphique
        WorldGUI gui = new WorldGUI(w);
        gui.setVisible(true);
        
        int nbTour = 1;
        while(true){
            w.tourDeJeu(nbTour, gui);
            nbTour++;
            SwingUtilities.invokeLater(gui::afficherMonde); // Rafraîchir l'interface graphique
        }
    }
}