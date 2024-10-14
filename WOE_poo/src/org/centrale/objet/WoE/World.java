/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.LinkedList;
import java.util.Random ;
import java.util.Scanner;

import java.util.ArrayList;

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
     * avec une taille de 50.
     */
    public World() {
        this.taille = 50;
        this.personnages = creerPersonnagesAlea();
        this.monstres = creerMonstresAlea();
        this.objets = creerObjetsAlea();
        this.joueur = creationJoueur(new Point2D(0,0));
        creerMondeAlea();
        command = "";
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
     * @param persoJoueur 
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
        
        System.out.println("Choisissez la classe de votre personnage parmi: 1.Guerrier - 2.Archer");
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
     * @throws java.lang.InterruptedException
     */
    public synchronized void tourDeJeu(int NbTour) throws InterruptedException{
        System.out.println("Tour "+NbTour);
        // perte de durée des objets: à up pour ne faire descendre que la durée de la nourriture consmmée: nouvelle liste dans Joueur ? + indiquer les aliments qui expirent
        ArrayList<Objet> nourritureDel = new ArrayList<Objet>();
        for (Objet o : joueur.getInventaire()) {
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
        }
        
        System.out.println("Choisissez votre action: 1.Se déplacer - 2.Combattre - 3.Manger un aliment - 4.Ramasser un objet");
        Random random = new Random();
        while (command.isEmpty()) {
            wait();  // Attend que le joueur entre une commande via l'interface graphique
        }
        int choix = Integer.parseInt(command); 
        command = "";
        Personnage jpers = joueur.getPersoChoisi();

        switch(choix){
            case 1 :
                LinkedList<Point2D> casesAtteignables = jpers.casesAtteignables(this);
                if (!casesAtteignables.isEmpty()){
                        getJoueur().setEnDeplacement(true);
                        System.out.println("Utilisez les flèches pour indiquer votre déplacement");  //le traitement des touches est effectué dans WorldGUI    
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
                    System.out.println("Choisissez la créature que vous voulez combattre:");
                    int i = 0;
                    for (Creature c : creaturesAPortee){//affiche les creatures à portee             
                        System.out.println(i);
                        c.affiche();
                        i++;
                    }
                    while (command.isEmpty()) {
                        wait();  // Attend que le joueur entre une commande via l'interface graphique
                    }
                    int choixCombat = Integer.parseInt(command);
                    // ecrire sur le panneau l'issue du combat
                    Creature creatureCombattue = creaturesAPortee.get(choixCombat);
                    System.out.println("Vous allez combattre une créature ayant "+creatureCombattue.getPtVie()+"points de vie,"+creatureCombattue.getPagePar()+" pourcentage de parade et"+creatureCombattue.getPtPar()+" points de parade /n"+"Vous avez"+jpers.getPageAtt()+"poourcentage d'attaque et"+jpers.getDegAtt()+"points de dégats d'attaque");
                    jcomb.combattre(creatureCombattue);
                    System.out.println("Il reste "+creatureCombattue.getPtVie()+"points de vie à la créature");
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
        
        
        actualisationMorts();
        
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
    public void actualisationMorts(){
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
    }
    
    public synchronized void processCommand(String s){
        command = s;    
        notify();
    }
}