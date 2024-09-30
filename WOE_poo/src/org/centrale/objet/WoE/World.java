/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Représente le monde du jeu, contenant différentes entités comme des personnages
 * et des créatures.
 * 
 * @author benja
 */
public class World {
    
    public Archer hog_rider; 
    public Paysan peon; 
    public Lapin bugs; 
    public Lapin bugs2;
    public Loup wolfie;
    public Guerrier grosBill;
    public Archer guillaumeT;
    public int taille;

    /**
     * Constructeur pour créer un monde avec des entités spécifiées.
     * 
     * @param hog_rider l'archer du monde
     * @param peon le paysan du monde
     * @param bugs le premier lapin
     * @param bugs2 le deuxième lapin
     * @param wolfie le loup
     * @param grosBill le guerrier
     * @param guillaumeT le deuxième archer
     * @param taille la taille du monde
     */
    public World(Archer hog_rider, Paysan peon, Lapin bugs, Lapin bugs2, Loup wolfie, Guerrier grosBill, Archer guillaumeT, int taille) {
        this.hog_rider = hog_rider;
        this.peon = peon;
        this.bugs = bugs;
        this.bugs2 = bugs2;
        this.wolfie = wolfie;
        this.grosBill = grosBill;
        this.guillaumeT = guillaumeT;
        this.taille = taille;
    }

    /**
     * Constructeur par défaut, crée un monde avec des entités par défaut
     * et une taille de 1000.
     */
    public World() {
        this.hog_rider = new Archer();
        this.peon = new Paysan();
        this.bugs = new Lapin();
        this.bugs2 = new Lapin();
        this.wolfie = new Loup();
        this.grosBill = new Guerrier();
        this.guillaumeT = new Archer();
        this.taille = 1000;
    }
    
    /**
     * Crée des positions aléatoires pour chaque entité dans le monde.
     * Chaque position est unique et dans les limites de la taille du monde.
     */
    public void creeMondeAlea() {
        Random random = new Random();
        Point2D[] positions = new Point2D[7];
        boolean estUnique;

        // Génération des positions pour chaque entité
        for (int i = 0; i < positions.length; i++) {
            estUnique = false;
            // Continue jusqu'à obtenir une position unique
            while (!estUnique) {
                Point2D newPosition = new Point2D(random.nextInt(taille), random.nextInt(taille));
                estUnique = true;
                // Vérifie que la position n'est pas déjà utilisée
                for (int j = 0; j < i; j++) {
                    if (newPosition.equals(positions[j])) {
                        estUnique = false;
                        break;
                    }
                }
                if (estUnique) {
                    positions[i] = newPosition;
                }
            }
        }

        hog_rider.setPos(positions[0]);
        peon.setPos(positions[1]);
        bugs.setPos(positions[2]);
        bugs2.setPos(positions[3]);
        guillaumeT.setPos(positions[4]);
        wolfie.setPos(positions[5]);
        grosBill.setPos(positions[6]);
    }
    
    /**
     * Effectue un tour de jeu. (Méthode à implémenter)
     */
    public void tourDeJeu() {
        // À implémenter
    }
    
    /**
     * Affiche les informations du monde, y compris les entités et la taille.
     */
    public void afficheWorld() {
        System.out.println("1er archer : " + hog_rider);
        System.out.println("1er Lapin : " + bugs); 
        System.out.println("2eme Lapin = " + bugs2);
        System.out.println("Loup : " + wolfie);
        System.out.println("Guerrier : " + grosBill); 
        System.out.println("2eme archer = " + guillaumeT);
        System.out.println("taille = " + taille);
    }
}
