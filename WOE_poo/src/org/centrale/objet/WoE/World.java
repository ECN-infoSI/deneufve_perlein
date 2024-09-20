/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random ;
/**
 *
 * @author benja
 */
public class World {
    
    public Archer hog_rider ; 
    public Paysan peon ; 
    public Lapin bugs ; 
    public int taille ;

    public World(Archer hog_rider, Paysan peon, Lapin bugs, int taille) {
        this.hog_rider = hog_rider;
        this.peon = peon;
        this.bugs = bugs;
        this.taille = taille;
    }

    public World() {
        this.hog_rider = new Archer();
        this.peon = new Paysan();
        this.bugs = new Lapin();
        this.taille = 1000;
    }
    
    public void creerMondeAlea() {
        Random random = new Random();
        Point2D[] positions = new Point2D[3];
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
    }
}