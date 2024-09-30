/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.LinkedList;
import java.util.Random ;
/**
 * Représente le monde du jeu, contenant différentes entités comme des personnages
 * et des créatures.
 *
 * @author benja
 */
public class World {
    
    private LinkedList<Personnage> personnages;
    private LinkedList<Monstre> monstres;
    private LinkedList<Objet> objets;
    private int taille ;


    public World(LinkedList<Personnage> personnages, LinkedList<Monstre> monstres, LinkedList<Objet> objets, int taille) {
        this.personnages = personnages;  
        this.monstres = monstres;        
        this.objets = objets;            
        this.taille = taille;            
    }

    /**
     * Constructeur par défaut, crée un monde avec des entités par défaut
     * et une taille de 1000.
     */
    public World() {
        this.personnages = creerPersonnagesAlea();
        this.monstres = creerMonstresAlea();
        this.objets = creerObjetsAlea();
        this.taille = 50;
    }

    public LinkedList<Personnage> getPersonnages() {
        return personnages;
    }

    public LinkedList<Monstre> getMonstres() {
        return monstres;
    }

    public LinkedList<Objet> getObjets() {
        return objets;
    }

    public int getTaille() {
        return taille;
    }

    public void setPersonnages(LinkedList<Personnage> personnages) {
        this.personnages = personnages;
    }

    public void setMonstres(LinkedList<Monstre> monstres) {
        this.monstres = monstres;
    }

    public void setObjets(LinkedList<Objet> objets) {
        this.objets = objets;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
      
    private LinkedList<Personnage> creerPersonnagesAlea() {
        LinkedList<Personnage> persalea = new LinkedList<>();
        Random random = new Random();
        
        int nbArchers = random.nextInt(taille*taille/10);  // Pour que la map ne soit pas pleine de mobs
        int nbPaysans = random.nextInt(taille*taille/10);  
        int nbGuerriers = random.nextInt(taille*taille/10);

        for (int i = 0; i < nbArchers; i++) {
            Personnage archer = new Archer();
            persalea.add(archer); 
        }

        for (int i = 0; i < nbPaysans; i++) {
            Personnage paysan = new Paysan();
            persalea.add(paysan);
        }

        for (int i = 0; i < nbGuerriers; i++) {
            Personnage guerrier = new Guerrier();
            persalea.add(guerrier); 
        }

        return persalea;
    }
    
    private LinkedList<Monstre> creerMonstresAlea() {
        LinkedList<Monstre> monstralea = new LinkedList<>();
        Random random = new Random();
        
        int nbLoups = random.nextInt(taille*taille/10);  // Pour que la map ne soit pas pleine de mobs
        int nbLapins = random.nextInt(taille*taille/10);  

        for (int i = 0; i < nbLoups; i++) {
            Monstre loup = new Loup();
            monstralea.add(loup); 
        }

        for (int i = 0; i < nbLapins; i++) {
            Monstre lapin = new Lapin();
            monstralea.add(lapin);
        }

        return monstralea;
    }
    
    private LinkedList<Objet> creerObjetsAlea() {
        LinkedList<Objet> potionalea = new LinkedList<>();
        Random random = new Random();
        
        int nbPotion = random.nextInt(taille*taille/10);  // Pour que la map ne soit pas pleine de mobs
        int nbEpee = random.nextInt(taille*taille/10);  

        for (int i = 0; i < nbPotion; i++) {
            Objet potion = new PotionSoin();
            potionalea.add(potion); 
        }

        for (int i = 0; i < nbEpee; i++) {
            Objet epee = new Epee();
            potionalea.add(epee);
        }

        return potionalea;
    }
    
    
    /**
     * Crée des positions aléatoires pour chaque entité dans le monde.
     * Chaque position est unique et dans les limites de la taille du monde.
     */
    public Point2D[] creeMondeAlea() {
        Random random = new Random();
        Point2D[] positions = new Point2D[personnages.size()+monstres.size()+objets.size()];
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
        // Atribution des positions
        for (int i = 0; i < personnages.size(); i++) {
            personnages.get(i).setPos(positions[i]);
        }
        for (int i = 0; i < monstres.size(); i++) {
            monstres.get(i).setPos(positions[personnages.size() + i]);
        }
        for (int i = 0; i < objets.size(); i++) {
            objets.get(i).setPos(positions[personnages.size() + monstres.size() + i]);
        }
            return positions;
        }
    
    
    public void tourDeJeu(){
    }
    
    /**
     * Affiche les informations du monde, y compris les entités et la taille.
     */
    public void afficheWorld() {
        System.out.println("Personnages :");
        for (Personnage p : personnages) {
            System.out.println(p);
        }

        System.out.println("Monstres :");
        for (Monstre m : monstres) {
            System.out.println(m);
        }

        System.out.println("Objets :");
        for (Objet o : objets) {
            System.out.println(o);
        }
    }
}