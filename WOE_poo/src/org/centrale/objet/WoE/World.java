/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.LinkedList;
import java.util.Random ;
import java.util.Scanner;
/**
 * Représente le monde du jeu, contenant différentes entités comme des personnages
 * et des créatures.
 *
 * @author benja
 */
public class World {
    
    private LinkedList<Personnage> personnages;
    private Personnage persoJoueur;
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
        this.taille = 50;
        this.personnages = creerPersonnagesAlea();
        this.monstres = creerMonstresAlea();
        this.objets = creerObjetsAlea();
    }

    /**
     * @return la liste des personnages du monde
     */
    public LinkedList<Personnage> getPersonnages() {
        return personnages;
    }
    
    /**
     * @return la liste des monstres du monde
     */
    public LinkedList<Monstre> getMonstres() {
        return monstres;
    }

    /**
     * @return la liste des objets du monde
     */
    public LinkedList<Objet> getObjets() {
        return objets;
    }

    /**
     * @return le personnage controlé par le joueur
     */
    public Personnage getPersoJoueur() {
        return persoJoueur;
    }

    /**
     * @return la taille du monde
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Définit la liste de personnages du monde
     * 
     * @param personnages la nouvelle liste de personnages
     */
    public void setPersonnages(LinkedList<Personnage> personnages) {
        this.personnages = personnages;
    }

    /**
     * Définit le personnage contrôlé par le joueur
     * 
     * @param persoJoueur 
     */
    public void setPersoJoueur(Personnage persoJoueur) {
        this.persoJoueur = persoJoueur;
    }

     /**
     * Définit la liste de monstres du monde
     * 
     * @param monstres la nouvelle liste de personnages
     */
    public void setMonstres(LinkedList<Monstre> monstres) {
        this.monstres = monstres;
    }

     /**
     * Définit la liste d'objets du monde
     * 
     * @param objets la nouvelle liste d'objets
     */
    public void setObjets(LinkedList<Objet> objets) {
        this.objets = objets;
    }

     /**
     * Définit la taille du monde
     * 
     * @param taille la nouvelle taille
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }
      
     /**
     * Crée une liste de personnages aléatoire
     * 
     * @return la liste de personnages
     */
    private LinkedList<Personnage> creerPersonnagesAlea() {
        LinkedList<Personnage> persalea = new LinkedList<>();
        Random random = new Random();
        
        int nbArchers = random.nextInt(taille*taille/100);  // Pour que la map ne soit pas pleine de mobs
        int nbPaysans = random.nextInt(taille*taille/100);  
        int nbGuerriers = random.nextInt(taille*taille/100);

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
    
     /**
     * Crée une liste de monstres aléatoire
     * 
     * @return la liste de monstres
     */
    private LinkedList<Monstre> creerMonstresAlea() {
        LinkedList<Monstre> monstralea = new LinkedList<>();
        Random random = new Random();
        
        int nbLoups = random.nextInt(taille*taille/100);  // Pour que la map ne soit pas pleine de mobs
        int nbLapins = random.nextInt(taille*taille/100);  

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
    
     /**
     * Crée une liste d'objets aléatoire
     * 
     * @return la liste d'objets
     */
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
    public void creeMondeAlea() {
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
        }
    
    
    public void tourDeJeu(int NbTour){
        NbTour+=1;
        System.out.println("Tour"+NbTour);
        System.out.println("Choisissez votre action: 1.Se déplacer - 2.Combattre");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        switch(choix){
            case 1:
                boolean Deplace = false;
                Point2D pos = null;  // Déclarez pos en dehors de la boucle
                while (! Deplace){
                    Deplace  = true;
                    System.out.println("Entrez la position que vous voulez occuper");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    pos = new Point2D(x,y);
                    // Vérification des limites de la carte
                    if (pos.getx() < 0 || pos.getx() >= taille ||
                        pos.gety() < 0 || pos.gety() >= taille || pos.distance(getPersoJoueur().getPos())>3) { //le joueur peut se déplacer de 3
                        System.out.println("Deplacement impossible : hors des limites de la Map.");
                        Deplace = false;
                    }
                    for (Personnage p : personnages) {
                        if (p.getPosition().equals(pos)) {
                            System.out.println("Deplacement impossible : collision avec un Personnage");
                            Deplace = false;
                        }    
                    }
                    for (Monstre m : monstres) {
                        if (m.getPosition().equals(pos)) {
                            System.out.println("Deplacement impossible : collision avec un Monstre");
                            Deplace = false;
                        }
                    }
                }
                getPersoJoueur().setPos(pos);
                break;
                
            case 2:
                LinkedList<Creature> creaturesAPortee = new LinkedList<>();
                for (Personnage p : personnages) {
                        if (p.getPosition().distance(getPersoJoueur().getPos())<=getPersoJoueur().getDistAttMax()) {
                            creaturesAPortee.add(p);
                        }
                }
                for (Monstre m : monstres) {
                        if (m.getPosition().distance(getPersoJoueur().getPos())<=getPersoJoueur().getDistAttMax()) {
                            creaturesAPortee.add(m);
                        }
                System.out.println("Choisissez la créature que vous voulez combattre:");
                int i = 0;
                for (Creature c : creaturesAPortee){
                    System.out.println(i);
                    c.affiche();
                    i++;
                }
                int choixCombat = scanner.nextInt();
                getPersoJoueur().combattre(creaturesAPortee.get(choixCombat));         
                break;
            }
        }
    }
    
    /**
     * Affiche les informations du monde, y compris les entités et la taille.
     */
    public void afficheWorld() {
        System.out.println("Personnages :");
        for (Personnage p : personnages) {
            p.affiche();      
        }

        System.out.println("Monstres :");
        for (Monstre m : monstres) {
            m.affiche();
        }

        System.out.println("Objets :");
        for (Objet o : objets) {
            o.affiche();
        }
    }
    
    /**
     * Slide 12: parcourir la liste de personnage: on affiche leur nom et la somme des points de vie
     */
    public void etatPersonnages(LinkedList<Personnage> personnages) {
        int totalPointsDeVie = 0; 
        for (int i = 0; i < personnages.size(); i++) {
            Personnage personnage = personnages.get(i);
            personnage.affiche();
            totalPointsDeVie += personnage.getPtVie(); 
        }
        System.out.println("Total des points de vie de tous les personnages: " + totalPointsDeVie);
    }
    
    public void creationJoueur(){
        
    }
}