/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author benja
 */
public class WoECN {
    public static void main(String[] args) {
        
        Archer hog_rider = new Archer(); 
        Paysan peon = new Paysan(); 
        Lapin bugs = new Lapin();
        Lapin bugs2 = new Lapin();
        Loup wolfie = new Loup();
        Guerrier grosBill = new Guerrier();
        //pour que guillaumeT soit une réelle copie 
        Archer guillaumeT = new Archer(hog_rider);
        int taille = 1000;
        World w =  new World(hog_rider, peon, bugs, bugs2, wolfie, grosBill, guillaumeT, taille);
        w.creeMondeAlea();
        
        System.out.println("position des Mobs:");
        System.out.println("Hog_rider:");
        hog_rider.getPos().affiche();
        System.out.println("Peon:");
        peon.getPos().affiche();
        System.out.println("Buggs:");
        bugs.getPos().affiche();
        System.out.println("Buggs2:");
        bugs2.getPos().affiche();  // Nouvelle ligne pour afficher la position de bugs2
        System.out.println("Wolfie:");
        wolfie.getPos().affiche();  // Nouvelle ligne pour afficher la position de wolfie
        System.out.println("GrosBill:");
        grosBill.getPos().affiche();  // Nouvelle ligne pour afficher la position de grosBill
        System.out.println("GuillaumeT:");
        guillaumeT.getPos().affiche();  // Nouvelle ligne pour afficher la position de guillaumeT

        // Déplacement des objets
        hog_rider.deplace(taille);
        peon.deplace(taille);
        bugs.deplace(taille);
        bugs2.deplace(taille);  // Nouvelle ligne pour déplacer bugs2
        wolfie.deplace(taille);  // Nouvelle ligne pour déplacer wolfie
        grosBill.deplace(taille);  // Nouvelle ligne pour déplacer grosBill
        guillaumeT.deplace(taille);  // Nouvelle ligne pour déplacer guillaumeT

        System.out.println("position des Mobs:");
        System.out.println("Hog_rider:");
        hog_rider.getPos().affiche();
        System.out.println("Peon:");
        peon.getPos().affiche();
        System.out.println("Buggs:");
        bugs.getPos().affiche();
        System.out.println("Buggs2:");
        bugs2.getPos().affiche();  // Nouvelle ligne pour afficher la position de bugs2 après déplacement
        System.out.println("Wolfie:");
        wolfie.getPos().affiche();  // Nouvelle ligne pour afficher la position de wolfie après déplacement
        System.out.println("GrosBill:");
        grosBill.getPos().affiche();  // Nouvelle ligne pour afficher la position de grosBill après déplacement
        System.out.println("GuillaumeT:");
        guillaumeT.getPos().affiche();  // Nouvelle ligne pour afficher la position de guillaumeT après déplacement

        // Autre méthode: Création d'une liste de créatures
        List<Creature> creatures = new ArrayList<>();
        // Ajout des créatures à la liste
        creatures.add(hog_rider);
        creatures.add(peon);
        creatures.add(bugs);
        creatures.add(bugs2);
        creatures.add(wolfie);
        creatures.add(grosBill);
        creatures.add(guillaumeT);
        // Affichage des positions initiales de toutes les créatures
        System.out.println("position des Mobs:");
        for (Creature creature : creatures) {
            System.out.println(creature.getClass().getSimpleName() + ":");
            creature.getPos().affiche();
        }
        // Déplacement de toutes les créatures
        for (Creature creature : creatures) {
            creature.deplace(taille);
        }
        // Affichage des positions après déplacement
        System.out.println("position des Mobs après déplacement:");
        for (Creature creature : creatures) {
            System.out.println(creature.getClass().getSimpleName() + ":");
            creature.getPos().affiche();
        }
    }
}
