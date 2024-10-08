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


    public World(LinkedList<Personnage> personnages, LinkedList<Monstre> monstres, LinkedList<Objet> objets, int taille, Personnage persoChoisi) {
        this.personnages = personnages;  
        this.monstres = monstres;        
        this.objets = objets;            
        this.taille = taille;   
        this.persoJoueur = persoChoisi;
    }

    /**
     * Constructeur par défaut, crée un monde avec des entités par défaut, crée un personnage controlé par le joueur
     * avec une taille de 50.
     */
    public World() {
        this.taille = 50;
        this.personnages = creerPersonnagesAlea();
        this.monstres = creerMonstresAlea();
        this.objets = creerObjetsAlea();
        this.persoJoueur = creationJoueur(new Point2D(0,0));
        creerMondeAlea();
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
     * Slide 12: création du personnage du joueur
     * @param positionInit
     * @return 
     */
    
    public final Personnage creationJoueur(Point2D positionInit){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choisissez la classe de votre personnage parmi: 1.Guerrier - 2.Archer");
        int choix = scanner.nextInt();
        
        switch(choix){
            case 1:
                persoJoueur = new Guerrier();
                break;
            case 2:
                persoJoueur = new Archer();
                break;
        }
        persoJoueur.setPos(positionInit);   //Position de départ  
        return persoJoueur;
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
    public final void creerMondeAlea() {
        Random random = new Random();
        Point2D[] positions = new Point2D[personnages.size()+monstres.size()+objets.size()+1];  //+1 pour la position du joueur
        Point2D posJoueur = new Point2D(0,0);   //Position du joueur
        positions[0] = posJoueur;
        boolean estUnique;
        // Génération des positions pour chaque entité
        for (int i = 1; i < positions.length; i++) {
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
            personnages.get(i).setPos(positions[i+1]);      //+1 pour la position du joueur
        }
        for (int i = 0; i < monstres.size(); i++) {
            monstres.get(i).setPos(positions[personnages.size() + i + 1]);
        }
        for (int i = 0; i < objets.size(); i++) {
            objets.get(i).setPos(positions[personnages.size() + monstres.size() + i + 1]);
        }
        }
    
    /**
     * Lance le tour de jeu du joueur
     * Il doit choisir entre se déplacer ou combattre
     * @param NbTour
     */
    public void tourDeJeu(int NbTour){
        System.out.println("Tour "+NbTour);
        System.out.println("Choisissez votre action: 1.Se déplacer - 2.Combattre");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        
        switch(choix){
            case 1 :
                boolean Deplace = false;
                while (! Deplace){
                    System.out.println("Entrez la translation que vous voulez effectuer");      //à améliorer pour meilleure UX et permettre de rester statique (boucle infinie)
                    int dx = scanner.nextInt();
                    int dy = scanner.nextInt();
                    Deplace = getPersoJoueur().deplace(this, dx, dy);
                    }                                  
                break;
                
            case 2 : 
                LinkedList<Creature> creaturesAPortee = getPersoJoueur().creaturesAPortee(this, getPersoJoueur().getDistAttMax());
                if (creaturesAPortee.isEmpty()){
                        System.out.println("Aucune créature n'est à portée");
                    }
                else{
                    System.out.println("Choisissez la créature que vous voulez combattre:");
                    int i = 0;
                    for (Creature c : creaturesAPortee){//affiche les creatures à portee             
                        System.out.println(i);
                        c.affiche();
                        i++;
                    }
                    int choixCombat = scanner.nextInt();
                    getPersoJoueur().combattre(creaturesAPortee.get(choixCombat));
                }
                break;            
        }
    }
    
    /**
     * Affiche les informations du monde, y compris les entités et la taille.
     */
    public void afficheWorld() {
        System.out.println("Personnage du joueur :");
        persoJoueur.affiche();
        
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
     * Retire du monde les personnages et monstres morts
     */
    public void actualisationMorts(){
        //disparition des persos morts
        LinkedList<Personnage> personnagesMorts = new LinkedList<>();
                for (Personnage p : personnages) {
                    if (p.getPtVie()<=0) {
                        personnagesMorts.add(p);
                    }
                }
                
        LinkedList<Monstre> monstresMorts = new LinkedList<>();
                for (Monstre m : monstres) {
                    if (m.getPtVie()<=0) {
                        monstresMorts.add(m);
                    }
                }
                for (Personnage pDel : personnagesMorts){      //on retire les personnages morts du monde ici pour éviter les conflits d'accès
                    personnages.remove(pDel); // Supprimer l'objet pDel
                }
                for (Monstre mDel : monstresMorts){      //on retire les personnages morts du monde ici pour éviter les conflits d'accès
                    monstres.remove(mDel); // Supprimer l'objet pDel
                }        
    }
}