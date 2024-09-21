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
        
        Archer hog_rider = new Archer(); 
        Paysan peon = new Paysan(); 
        Lapin bugs = new Lapin(); 
        int taille = 1000;
        World w =  new World(hog_rider, peon, bugs, taille);
        w.creeMondeAlea();
        
        System.out.println("position des Mobs: ");
        System.out.println("Hog_rider:");
        hog_rider.getPos().affiche();
        System.out.println("Peon:");
        peon.getPos().affiche();
        System.out.println("Buggs:");
        bugs.getPos().affiche();
        
        // Déplacement des objets
        hog_rider.deplace(taille);
        peon.deplace(taille);
        bugs.deplace(taille);
        
        System.out.println("position des Mobs:");
        System.out.println("Hog_rider:");
        hog_rider.getPos().affiche();
        System.out.println("Peon:");
        peon.getPos().affiche();
        System.out.println("Buggs:");
        bugs.getPos().affiche();
        
        //copie des objets
        Archer guillaumeT;
        guillaumeT = hog_rider;
        hog_rider.deplace(taille);
        //guillaumeT s'est aussi déplacé, il faut plutôt utiliser le constructeur de recopie
        guillaumeT = new Archer(hog_rider);
    }
}
