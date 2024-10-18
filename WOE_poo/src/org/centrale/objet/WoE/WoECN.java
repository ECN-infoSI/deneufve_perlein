/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * MAIN
 */
public class WoECN {
    public static void main(String[] args) throws InterruptedException {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tapez 1. pour une nouvelle partie et 2. pour charger une partie");
        
        int choix = scanner.nextInt();
        World w = null;
        
        switch(choix){
            case 1: 
                World wAlea = new World();
                w = wAlea;
                break;
            case 2:
                scanner.nextLine();  // Consomme le retour à la ligne résiduel
                System.out.println("Entrez le nom du fichier de votre sauvegarde (exemple: test.txt)");
                String nom = scanner.nextLine();
                World wR = new World("./"+nom);
                w = wR;
                break;
        }
        
        // Interface graphique
        WorldGUI gui = new WorldGUI(w);
        gui.setVisible(true);
        System.out.println("Voici les capacité de votre personnage:");
        w.getJoueur().getPersoChoisi().affiche();
        int nbTour = 1;     //à changer si le jeu est chargé
        while(true){
            w.tourDeJeu(nbTour, gui);
            nbTour++;
            SwingUtilities.invokeLater(gui::afficherMonde); // Rafraîchir l'interface graphique
            w.save("test.txt");
        }
    }
}