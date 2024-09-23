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
        PotionSoin p1 = new PotionSoin();
        PotionSoin p2 = new PotionSoin();
        //pour que guillaumeT soit une réelle copie 
        Archer guillaumeT = new Archer(hog_rider);
        int taille = 1000;
        World w =  new World(hog_rider, peon, bugs, bugs2, wolfie, grosBill, guillaumeT, p1, p2, taille);
        w.creeMondeAlea();
        
        // Test: Déplacement des objets
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
            creature.deplace(taille, p1, p2);
        }
        // Affichage des positions après déplacement
        System.out.println("position des Mobs après déplacement:");
        for (Creature creature : creatures) {
            System.out.println(creature.getClass().getSimpleName() + ":");
            creature.getPos().affiche();
        }
        // Test: Combat CàC: grosBill attaque bugs1
        bugs.affiche();
        grosBill.setPos(new Point2D(bugs.getPos().getxpoint(),bugs.getPos().getypoint()+1)); //on place grosBill à coté
        //possibilité de créer une deuxième méthode setPos qui prends en entrée deux int pour simplifier là commande ci-dessus
        grosBill.combattre(bugs);
        bugs.affiche();
        // Test: Combat à distance: guillaumeT attaque wolfie
        wolfie.affiche();
        grosBill.setPos(new Point2D(wolfie.getPos().getxpoint(),wolfie.getPos().getypoint()+2)); //on place guillaumeT à 2 cases 
        //possibilité de créer une deuxième méthode setPos qui prends en entrée deux int pour simplifier là commande ci-dessus
        guillaumeT.combattre(wolfie);
        wolfie.affiche();
    }
}
