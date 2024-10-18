/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random ;
import java.util.Scanner;

import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 * Représente le monde du jeu, contenant différentes entités comme des personnages
 * et des créatures.
 *
 * @author benja
 */
public class World{
    
    private LinkedList<Personnage> personnages;
    private Joueur joueur;
    private LinkedList<Monstre> monstres;
    private LinkedList<Objet> objets;
    private int taille ;
    private String command;

    /**
    * Constructeur complet
    *
    * @author benja
    */
    public World(LinkedList<Personnage> personnages, LinkedList<Monstre> monstres, LinkedList<Objet> objets, int taille, Joueur J) {
        this.personnages = personnages;  
        this.monstres = monstres;        
        this.objets = objets;            
        this.taille = taille;   
        this.joueur = J;
        command = "";
    }

    /**
     * Constructeur par défaut, crée un monde avec des entités par défaut, crée un personnage controlé par le joueur
     * avec une taille de 20.
     */
    public World() {
        this.taille = 20;
        this.personnages = creerPersonnagesAlea();
        this.monstres = creerMonstresAlea();
        this.objets = creerObjetsAlea();
        this.joueur = creationJoueur(new Point2D(0,0));
        creerMondeAlea();
        command = "";
    }

    
    public World(String source) {
        try {
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(source));

            monstres = new LinkedList<>(); 
            personnages = new LinkedList<>(); 
            objets = new LinkedList<>(); 

            joueur = new Joueur(); 
            ArrayList<Objet> inventaire = new ArrayList<>();
            ArrayList<Objet> effets = new ArrayList<>();
            
            int readTaille = 20;
            
            // Lecture de la première ligne
            ligne = fichier.readLine();
             
            // Parcours de chaque ligne du fichier
            while (ligne != null) {
                System.out.println(ligne);
                // Séparation des éléments de la ligne
                String[] tokens = ligne.split(";");

                // Si la ligne contient "Taille", on crée le monde
                if (tokens[0].equals("Taille")) {
                    readTaille = Integer.parseInt(tokens[1]);
                } else {
                    // Si on est ici, cela signifie qu'on lit une entité
                    String typeEntite = tokens[0];

                    switch (typeEntite) {
                        case "Guerrier":
                            
                            Guerrier guerrier = new Guerrier(tokens[1], 
                                                             Integer.parseInt(tokens[2]),
                                                             Integer.parseInt(tokens[3]),
                                                             Integer.parseInt(tokens[4]),
                                                             Integer.parseInt(tokens[5]),
                                                             Integer.parseInt(tokens[6]),
                                                             Integer.parseInt(tokens[7]),
                                                             new Point2D(Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9])));
                            personnages.add(guerrier) ;
                            break;

                        case "Archer":
                            Archer archer = new Archer(tokens[1], 
                                                       Integer.parseInt(tokens[2]),
                                                       Integer.parseInt(tokens[3]),
                                                       Integer.parseInt(tokens[4]),
                                                       Integer.parseInt(tokens[5]),
                                                       Integer.parseInt(tokens[6]),
                                                       Integer.parseInt(tokens[7]),
                                                       new Point2D(Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9])),
                                                       Integer.parseInt(tokens[10]));
                            personnages.add(archer);
                            break;

                        case "Paysan":
                            Paysan paysan = new Paysan(tokens[1], 
                                                       Integer.parseInt(tokens[2]),
                                                       Integer.parseInt(tokens[3]),
                                                       Integer.parseInt(tokens[4]),
                                                       Integer.parseInt(tokens[5]),
                                                       Integer.parseInt(tokens[6]),
                                                       Integer.parseInt(tokens[7]),
                                                       new Point2D(Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9])));
                            personnages.add(paysan);
                            break;

                        case "Loup":
                            Loup loup = new Loup(Integer.parseInt(tokens[1]),
                                                 Integer.parseInt(tokens[2]),
                                                 Integer.parseInt(tokens[3]),
                                                 Integer.parseInt(tokens[4]),
                                                 Integer.parseInt(tokens[5]),
                                                 new Point2D(Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7])));
                            monstres.add(loup);
                            break;

                        case "Lapin":
                            Lapin lapin = new Lapin(Integer.parseInt(tokens[1]),
                                                    Integer.parseInt(tokens[2]),
                                                    Integer.parseInt(tokens[3]),
                                                    Integer.parseInt(tokens[4]),
                                                    Integer.parseInt(tokens[5]),
                                                    new Point2D(Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7])));
                            monstres.add(lapin);
                            break;

                        case "Epee":
                            Epee epee = new Epee(tokens[1],
                                                    tokens[2],
                                                    Integer.parseInt(tokens[3]),
                                                    new Point2D(Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])),
                                                    Integer.parseInt(tokens[6]));
                            objets.add(epee);
                            break;

                        case "PotionSoin":
                            PotionSoin pot = new PotionSoin(tokens[1],
                                                    tokens[2],
                                                    Integer.parseInt(tokens[3]),
                                                    new Point2D(Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])),
                                                    Integer.parseInt(tokens[6]));
                            objets.add(pot);
                            break;

                        case "NuageToxique":
                            NuageToxique nu = new NuageToxique(tokens[1],
                                                    tokens[2],
                                                    Integer.parseInt(tokens[3]),
                                                    new Point2D(Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])),
                                                    Integer.parseInt(tokens[6]),
                                                    Integer.parseInt(tokens[7]));
                            objets.add(nu);
                            break;

                        case "ChickenStreet":
                            ChickenStreet cs = new ChickenStreet(tokens[1],
                                                    tokens[2],
                                                    Integer.parseInt(tokens[3]),
                                                    new Point2D(Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])),
                                                    Integer.parseInt(tokens[6]),
                                                    Integer.parseInt(tokens[7]));
                            objets.add(cs);
                            break;

                        case "PouletMadras":
                            PouletMadras pm = new PouletMadras(tokens[1],
                                                    tokens[2],
                                                    Integer.parseInt(tokens[3]),
                                                    new Point2D(Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])),
                                                    Integer.parseInt(tokens[6]),
                                                    Integer.parseInt(tokens[7]));
                            objets.add(pm);
                            break;

                        case "Joueur" :
                            String type_joueur = tokens[1] ; 
                            switch (type_joueur) {
                                case "Archer" : 
                                    Archer perso_a = new Archer(tokens[2], 
                                                       Integer.parseInt(tokens[3]),
                                                       Integer.parseInt(tokens[4]),
                                                       Integer.parseInt(tokens[5]),
                                                       Integer.parseInt(tokens[6]),
                                                       Integer.parseInt(tokens[7]),
                                                       Integer.parseInt(tokens[8]),
                                                       new Point2D(Integer.parseInt(tokens[9]), Integer.parseInt(tokens[10])),
                                                       Integer.parseInt(tokens[11]));
                                    joueur.setPersoChoisi((Personnage) perso_a);
                                    break;
                                case "Guerrier" : 
                                    Guerrier perso_g = new Guerrier(tokens[2], 
                                                       Integer.parseInt(tokens[3]),
                                                       Integer.parseInt(tokens[4]),
                                                       Integer.parseInt(tokens[5]),
                                                       Integer.parseInt(tokens[6]),
                                                       Integer.parseInt(tokens[7]),
                                                       Integer.parseInt(tokens[8]),
                                                       new Point2D(Integer.parseInt(tokens[9]), Integer.parseInt(tokens[10])));
                                    joueur.setPersoChoisi((Personnage) perso_g);
                                    break;    
                            }    

                        case "Inventaire" : 
                            String type_inv = tokens[1] ; 
                            switch (type_inv) {
                                case "Epee":
                                Epee epee1 = new Epee(tokens[2],
                                                    tokens[3],
                                                    Integer.parseInt(tokens[4]),
                                                    new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                    Integer.parseInt(tokens[7]));
                                inventaire.add(epee1);
                                break;

                            case "PotionSoin":
                                PotionSoin pot1 = new PotionSoin(tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                        Integer.parseInt(tokens[7]));
                                inventaire.add(pot1);
                                break;

                            case "NuageToxique":
                                NuageToxique nu1 = new NuageToxique(tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                        Integer.parseInt(tokens[7]),
                                                        Integer.parseInt(tokens[8]));
                                inventaire.add(nu1);
                                break;

                            case "ChickenStreet":
                                ChickenStreet cs1 = new ChickenStreet(tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                        Integer.parseInt(tokens[7]),
                                                        Integer.parseInt(tokens[8]));
                                inventaire.add(cs1);
                                break;

                            case "PouletMadras":
                                PouletMadras pm1 = new PouletMadras(tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                        Integer.parseInt(tokens[7]),
                                                        Integer.parseInt(tokens[8]));
                                inventaire.add(pm1);
                                break;
                                }

                        case "Effets" : 
                            String type_eff = tokens[1] ; 
                            switch (type_eff) {
                                case "Epee":
                                Epee epee2 = new Epee(tokens[2],
                                                    tokens[3],
                                                    Integer.parseInt(tokens[4]),
                                                    new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                    Integer.parseInt(tokens[7]));
                                effets.add(epee2);
                                break;

                            case "PotionSoin":
                                PotionSoin pot2 = new PotionSoin(tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                        Integer.parseInt(tokens[7]));
                                effets.add(pot2);
                                break;

                            case "NuageToxique":
                                NuageToxique nu2 = new NuageToxique(tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                        Integer.parseInt(tokens[7]),
                                                        Integer.parseInt(tokens[8]));
                                effets.add(nu2);
                                break;

                            case "ChickenStreet":
                                ChickenStreet cs2 = new ChickenStreet(tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                        Integer.parseInt(tokens[7]),
                                                        Integer.parseInt(tokens[8]));
                                effets.add(cs2);
                                break;

                            case "PouletMadras":
                                PouletMadras pm2 = new PouletMadras(tokens[2],
                                                        tokens[3],
                                                        Integer.parseInt(tokens[4]),
                                                        new Point2D(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6])),
                                                        Integer.parseInt(tokens[7]),
                                                        Integer.parseInt(tokens[8]));
                                effets.add(pm2);
                                break;
                            }

                        default:
                            break;

                    }
                }

                // Lecture de la ligne suivante
                ligne = fichier.readLine();
            }

            fichier.close();

            joueur.setInventaire(inventaire) ; 
            joueur.setEffets(effets) ; 


            //création du monde : attention personnage classe abstraite
            //voir comment on peut définir le joueur
            this.taille = readTaille; 
            command = "";
            
        } catch (Exception e) {
            e.printStackTrace();
            new World();
        }
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
    public Joueur getJoueur() {
        return joueur;
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
     * @param readJoueur 
     */
    public void setPersoJoueur(Joueur J) {
        this.joueur = J;
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
    
    public final Joueur creationJoueur(Point2D positionInit){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour lancer une nouvelle partie, choisissez la classe de votre personnage parmi: 1.Guerrier - 2.Archer");
        int choix = scanner.nextInt();
        joueur = new Joueur();
        
        switch(choix){
            case 1:
                joueur.setPersoChoisi(new Guerrier()); 
                break;
            case 2:
                joueur.setPersoChoisi(new Archer()); 
                break;
        }
        
        scanner.nextLine();  // Consomme le retour à la ligne résiduel
        System.out.println("Choisissez un nom à votre personnage");
        String nom = scanner.nextLine();
        joueur.getPersoChoisi().setNom(nom);
        
        Personnage heros = getJoueur().getPersoChoisi();
        heros.setPtVie(heros.getPtVie()+20);
        heros.setDegAtt(heros.getDegAtt()+20);
        heros.setPageAtt(heros.getPageAtt()+20);
        getJoueur().getPersoChoisi().setPos(positionInit);   //Position de départ
        return joueur;
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
        LinkedList<Objet> objetsAlea = new LinkedList<>();
        Random random = new Random();
        
        int nbPotion = random.nextInt(taille*taille/100);  // Pour que la map ne soit pas pleine de mobs
        int nbEpee = random.nextInt(taille*taille/100);  
        int nbNuage = 1;
        int nbMadras = random.nextInt(taille*taille/100);
        int nbStreet = random.nextInt(taille*taille/100);

        for (int i = 0; i < nbPotion; i++) {
            Objet potion = new PotionSoin();
            objetsAlea.add(potion); 
        }

        for (int i = 0; i < nbEpee; i++) {
            Objet epee = new Epee();
            objetsAlea.add(epee);
        }
        
        for (int i = 0; i < nbStreet; i++) {
            Objet street = new ChickenStreet();
            objetsAlea.add(street);
        }
        
        for (int i = 0; i < nbMadras; i++) {
            Objet madras = new PouletMadras();
            objetsAlea.add(madras);
        }
        
        for (int i = 0; i < nbNuage; i++) {
            Objet nuage = new NuageToxique();
            objetsAlea.add(nuage);
        }

        return objetsAlea;
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
     * @param gui
     * @throws java.lang.InterruptedException
     */
    public synchronized void tourDeJeu(int NbTour, WorldGUI gui) throws InterruptedException{
        System.out.println("\n Tour "+NbTour);
        Personnage jpers = joueur.getPersoChoisi();
        
        // perte de durée des objets: à up pour ne faire descendre que la durée de la nourriture consmmée: nouvelle liste dans Joueur ? + indiquer les aliments qui expirent
        ArrayList<Objet> nourritureDel = new ArrayList<Objet>();
        if (!joueur.getEffets().isEmpty()){
            for (Objet o : joueur.getEffets()) {
                if (o instanceof Nourriture) {
                    Nourriture n = (Nourriture) o; 
                    n.setTemps(n.getTemps()-1);
                    if (n.getTemps()<=0){
                        nourritureDel.add(o);
                    }
                }
            }
            for (Objet o : nourritureDel){      //on retire les potions bus du monde ici pour éviter les conflits d'accès
                ArrayList<Objet> effets = joueur.getEffets(); 
                effets.remove(o); 
                joueur.setEffets(effets);
                if (o instanceof ChickenStreet){
                                ChickenStreet cConso = (ChickenStreet) o;
                                System.out.println("-"+cConso.getPar()+"points de parade");
                                jpers.setPtPar(jpers.getPtPar()-cConso.getPar());
                            }
                else{
                                PouletMadras pConso = (PouletMadras) o;
                                System.out.println("-"+pConso.getDegats()+"points de dégats");
                                jpers.setDegAtt(jpers.getDegAtt()-pConso.getDegats());
                }
            }
        }
        
        System.out.println("\n Choisissez votre action: 1.Se déplacer - 2.Combattre - 3.Manger un aliment - 4.Ramasser un objet");
        Random random = new Random();
        while (command.isEmpty()) {
            wait();  // Attend que le joueur entre une commande via l'interface graphique
        }
        int choix = Integer.parseInt(command); 
        
        command = "";

        switch(choix){
            case 1 :
                LinkedList<Point2D> casesAtteignables = jpers.casesAtteignables(this);
                if (!casesAtteignables.isEmpty()){
                        getJoueur().setEnDeplacement(true);
                        System.out.println("\n Utilisez les flèches pour indiquer votre déplacement");  //le traitement des touches est effectué dans WorldGUI    
                        while (getJoueur().isEnDeplacement()) {     //attendre jusqu'à la fin du déplacement
                        }
                }
                else{System.out.println("Aucun déplacement possible, vous restez statique");}
                break;
            case 2 : 
                Combattant jcomb = (Combattant) jpers;
                LinkedList<Creature> creaturesAPortee = jcomb.creaturesAPortee(this, jpers.getDistAttMax());
                if (creaturesAPortee.isEmpty()){
                        System.out.println("Aucune créature n'est à portée");
                    }
                else{
                    System.out.println("\n Choisissez un monstre à combattre (0 à " + (creaturesAPortee.size() - 1 + ":"));
                    int i = 0;
                    for (Creature c : creaturesAPortee){//affiche les creatures à portee             
                        System.out.println("\n" +i);
                        c.affiche();
                        i++;
                    }
                    boolean selectionValide = false;
                    while (!selectionValide) {
                        while (command.isEmpty()) {
                            wait();  // Attend que le joueur entre une commande via l'interface graphique
                        }
                    int choixCombat = Integer.parseInt(command);
                    // Vérifier que l'entrée est valide
                    if (choixCombat >= 0 && choixCombat < creaturesAPortee.size()) {
                        Creature cible = creaturesAPortee.get(choixCombat);
                        System.out.println("Vous allez combattre une créature ayant "+cible.getPtVie()+" points de vie, vous avez "+jpers.getPageAtt()+" pourcentage d'attaque et "+jpers.getDegAtt()+" points de dégats d'attaque");
                        jcomb.combattre(cible);
                        System.out.println("Il reste "+cible.getPtVie()+"points de vie à la créature");
                        selectionValide = true;  // Sortir de la boucle
                    } else {
                        System.out.println("Entrée non valide. Veuillez entrer un nombre valide.\n");
                    }
                    }
                   
                    command = "";
                }
                break;          
                
            case 3 : 
                System.out.println("Choisissez la nourriture que vous voulez consommer :");
                    int i = 0;
                    if (!joueur.getInventaire().isEmpty()){
                        for (Objet o : joueur.getInventaire()){//affiche les creatures à portee             
                            System.out.println(i);
                            o.affiche();
                            i++;
                        }
                        while (command.isEmpty()) {
                            wait();  // Attend que le joueur entre une commande via l'interface graphique
                        }
                        int choixNourriture = Integer.parseInt(command); 
                        Objet nConso = joueur.getInventaire().get(choixNourriture);
                        System.out.println("Objet consommé, vous avez un bonus de ");
                        if (nConso instanceof ChickenStreet){
                            ChickenStreet cConso = (ChickenStreet) nConso;
                            System.out.println(cConso.getPar()+"points de parade");
                            jpers.setPtPar(jpers.getPtPar()+cConso.getPar());
                        }
                        else{
                            PouletMadras pConso = (PouletMadras) nConso;
                            System.out.println(pConso.getDegats()+"points de dégats");
                            jpers.setDegAtt(jpers.getDegAtt()+pConso.getDegats());
                        }
                        ArrayList<Objet> effets = joueur.getEffets(); 
                        effets.add(nConso); 
                        joueur.setEffets(effets); 
                        joueur.getInventaire().remove(nConso);
                        
                        command = "";
                    }
                    else{System.out.println("Vous n'avez pas d'objet dans votre inventaire");}
                break;  
                
            case 4 : 
            Objet objetDel = null;
                for (Objet o : objets) {
                    if (jpers.getPos().equals(o.getPos())) {
                        joueur.getInventaire().add(o);
                        objetDel =o;
                    }
            }
            objets.remove(objetDel);            // Supprimer l'objet objetDel en évitant les conflits d'accès
            System.out.println("Vous avez ramassé:");
            objetDel.affiche();
            break;
        }
        actualisationMorts(gui);
        SwingUtilities.invokeLater(gui::afficherMonde); // Rafraîchir l'interface graphique
        
        for (Personnage p : personnages) {
            int dx = random.nextInt(3)-1;
            int dy = random.nextInt(3)-1;
            p.deplace(this, dx, dy);
            
            
            if (p instanceof Combattant){
                Combattant co = (Combattant) p;
                LinkedList<Creature> creaturesAPortee = co.creaturesAPortee(this, p.getDistAttMax());
                if (creaturesAPortee.isEmpty()){
                    break;
                    }
                else{
                    co.combattre(creaturesAPortee.get(0));
                }
                break; 
            }
        }
        SwingUtilities.invokeLater(gui::afficherMonde); // Rafraîchir l'interface graphique
        
        for (Monstre m : monstres) {
            int dx = random.nextInt(3)-1;
            int dy = random.nextInt(3)-1;
            m.deplace(this, dx, dy);
            
            if (m instanceof Combattant){
                Combattant co = (Combattant) m;
                LinkedList<Creature> creaturesAPortee = co.creaturesAPortee(this, 1);
                    if (creaturesAPortee.isEmpty()){
                        break;
                        }
                    else{
                        co.combattre(creaturesAPortee.get(0));
                    }
                    break;            
                }
        }
        SwingUtilities.invokeLater(gui::afficherMonde); // Rafraîchir l'interface graphique
    }
    
    /**
     * Affiche les informations du monde, y compris les entités et la taille.
     */
    public void afficheWorld() {
        System.out.println("Personnage du joueur :");
        joueur.getPersoChoisi().affiche();
        
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
    public void actualisationMorts(WorldGUI gui){
        //disparition des persos morts
        LinkedList<Personnage> personnagesMorts = new LinkedList<>();
                for (Personnage p : personnages) {
                    if (p.getPtVie()<=0) {
                        personnagesMorts.add(p);
                        System.out.println("Le personnage "+p.getNom() + "est mort");
                    }
                }
                
        LinkedList<Monstre> monstresMorts = new LinkedList<>();
                for (Monstre m : monstres) {
                    if (m.getPtVie()<=0) {
                        monstresMorts.add(m);
                        System.out.println("Le monstre en position ");
                        m.getPos().affiche();
                        System.out.println("est mort");
                    }
                }
                for (Personnage pDel : personnagesMorts){      //on retire les personnages morts du monde ici pour éviter les conflits d'accès
                    personnages.remove(pDel); // Supprimer l'objet pDel
                }
                for (Monstre mDel : monstresMorts){      //on retire les personnages morts du monde ici pour éviter les conflits d'accès
                    monstres.remove(mDel); // Supprimer l'objet pDel
                }    
                
                SwingUtilities.invokeLater(gui::afficherMonde); // Rafraîchir l'interface graphique
    }
    
    public Boolean win(){
        if (monstres.isEmpty() && personnages.isEmpty()){
                System.out.println("BRAVO, VOUS AVEZ GAGNÉ");
                return true;
        }
        return false;
    }
    
    public Boolean lose(){
        if (joueur.getPersoChoisi().getPtVie()<=0) {
                        System.out.println("Vous êtes mort");
                        while(true){
                            System.out.println("GAME OVER");
                            return true;
                        }
                    }
        return false;
    }
    
    public synchronized void processCommand(String s){
        command = s;    
        notify();
    }
        
    public void save(String nom_fichier) {
        BufferedWriter buff = null;

        try {
            // Initialisation du BufferedWriter avec le fichier
            buff = new BufferedWriter(new FileWriter(nom_fichier));

            // Appel à la méthode pour écrire dans le fichier
            buff.write("Taille;" + taille);
            buff.newLine();

            // Le monde est carré
            // buff.write("Hauteur " + taille);
            // buff.newLine();

            // Remplir le fichier en distinguant chaque instance
            for (Personnage p : personnages) {
                if (p instanceof Guerrier) {
                    buff.write("Guerrier;" + p.getNom() + ";" + p.getPtVie() + ";" + p.getDegAtt() + ";" + p.getPtPar() + ";" 
                    + p.getPageAtt() + ";" + p.getPagePar() + ";" + p.getDistAttMax() + ";" + p.getPos().getx() + ";" + p.getPos().gety());
                    buff.newLine();
                } else if (p instanceof Archer) {
                    buff.write("Archer;" + p.getNom() + ";" + p.getPtVie() + ";" + p.getDegAtt() + ";" + p.getPtPar() + ";"
                    + p.getPageAtt() + ";" + p.getPagePar() + ";" + p.getDistAttMax() + ";" + p.getPos().getx() + ";" + p.getPos().gety() 
                    + ";" + ((Archer) p).getNbFleches());
                    buff.newLine();
                } else if (p instanceof Paysan) {
                    buff.write("Paysan;" + p.getNom() + ";" + p.getPtVie() + ";" + p.getDegAtt() + ";" + p.getPtPar() + ";"
                    + p.getPageAtt() + ";" + p.getPagePar() + ";" + p.getDistAttMax() + ";" + p.getPos().getx() + ";" + p.getPos().gety());
                    buff.newLine();
                }
            }

            for (Monstre m : monstres) {
                if (m instanceof Lapin) {
                    buff.write("Lapin;" + m.getPtVie() + ";" + m.getDegAtt() + ";" + m.getPtPar() + ";" 
                    + m.getPageAtt() + ";" + m.getPagePar() + ";" +m.getPos().getx() + ";" + m.getPos().gety());
                    buff.newLine();
                } else if (m instanceof Loup) {
                    buff.write("Loup;" + m.getPtVie() + ";" + m.getDegAtt() + ";" + m.getPtPar() + ";" 
                    + m.getPageAtt() + ";"+ m.getPagePar() + ";" + m.getPos().getx() + ";" + m.getPos().gety());
                    buff.newLine();
                }
            }

            for (Objet o : objets) {
                if (o instanceof Epee) {
                    buff.write("Epee;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Epee) o).getDegats());
                    buff.newLine();
                } else if (o instanceof PotionSoin) {
                    buff.write("PotionSoin;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((PotionSoin) o).getSoin());
                    buff.newLine();
                } else if (o instanceof NuageToxique) {
                    buff.write("NuageToxique;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((NuageToxique) o).getDegats() + ";" + ((NuageToxique) o).getRayon());
                    buff.newLine();
                } else if (o instanceof ChickenStreet) {
                    buff.write("ChickenStreet;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Nourriture) o).getTemps() + ";" + ((ChickenStreet) o).getPar());
                    buff.newLine();
                } else if (o instanceof PouletMadras) {
                    buff.write("PouletMadras;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Nourriture) o).getTemps() + ";" + ((PouletMadras) o).getDegats());
                    buff.newLine();
                }
            }

            // Distinction entre Archer et Guerrier pour le joueur
            if (joueur.getPersoChoisi() instanceof Archer) {
                Archer p = (Archer) joueur.getPersoChoisi();
                buff.write("Joueur;Archer;" + p.getNom() + ";" + p.getPtVie() + ";" + p.getDegAtt() + ";" + p.getPtPar() + ";"
                + p.getPageAtt() + ";" + p.getPagePar() + ";" + p.getDistAttMax() + ";" + p.getPos().getx() + ";" + p.getPos().gety() + ";" 
                + ((Archer) p).getNbFleches());
                buff.newLine();
            } else if (joueur.getPersoChoisi() instanceof Guerrier) {
                Guerrier p = (Guerrier) joueur.getPersoChoisi();
                buff.write("Joueur;Guerrier;" + p.getNom() + ";" + p.getPtVie() + ";" + p.getDegAtt() + ";" + p.getPtPar() + ";"
                + p.getPageAtt() + ";" + p.getPagePar() + ";" + p.getDistAttMax() + ";" + p.getPos().getx() + ";" + p.getPos().gety());
                buff.newLine();
            }

            // Gestion de l'inventaire
            for (Objet o : joueur.getInventaire()) {
                if (o instanceof Epee) {
                    buff.write("Inventaire;Epee;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Epee) o).getDegats());
                    buff.newLine();
                } else if (o instanceof PotionSoin) {
                    buff.write("Inventaire;PotionSoin;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((PotionSoin) o).getSoin());
                    buff.newLine();
                } else if (o instanceof NuageToxique) {
                    buff.write("Inventaire NuageToxique;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((NuageToxique) o).getDegats() + ";" + ((NuageToxique) o).getRayon());
                    buff.newLine();
                } else if (o instanceof ChickenStreet) {
                    buff.write("Inventaire;ChickenStreet;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Nourriture) o).getTemps() + ";" + ((ChickenStreet) o).getPar());
                    buff.newLine();
                } else if (o instanceof PouletMadras) {
                    buff.write("Inventaire;PouletMadras;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Nourriture) o).getTemps() + ";" + ((PouletMadras) o).getDegats());
                    buff.newLine();
                }
            }

            // Gestion des effets
            for (Objet o : joueur.getEffets()) {
                if (o instanceof Epee) {
                    buff.write("Effet;Epee;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Epee) o).getDegats());
                    buff.newLine();
                } else if (o instanceof PotionSoin) {
                    buff.write("Effet;PotionSoin;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((PotionSoin) o).getSoin());
                    buff.newLine();
                } else if (o instanceof NuageToxique) {
                    buff.write("Effet;NuageToxique;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((NuageToxique) o).getDegats() + ";" + ((NuageToxique) o).getRayon());
                    buff.newLine();
                } else if (o instanceof ChickenStreet) {
                    buff.write("Effet;ChickenStreet;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Nourriture) o).getTemps() + ";" + ((ChickenStreet) o).getPar());
                    buff.newLine();
                } else if (o instanceof PouletMadras) {
                    buff.write("Effet;PouletMadras;" + o.getNom() + ";" + o.getPoint_de_style() + ";" + o.getPoids() + ";" 
                    + o.getPos().getx() + ";" + o.getPos().gety() + ";" + ((Nourriture) o).getTemps() + ";" + ((PouletMadras) o).getDegats());
                    buff.newLine();
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (buff != null) {
                    buff.flush(); // S'assurer que tout est bien écrit
                    buff.close(); // Fermer correctement le fichier
                }
            } catch (IOException e) {
                e.printStackTrace(); // Gérer les erreurs de fermeture
            }
        }
    }
}