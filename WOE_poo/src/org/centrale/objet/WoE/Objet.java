package org.centrale.objet.WoE;

/**
 * Classe représentant un objet générique dans le jeu.
 * Un objet a un nom, un style et un poids.
 */
public class Objet {
    
    private String nom; 
    private String style; 
    private int poids;
    
    /**
     * Constructeur avec paramètres.
     * 
     * @param n Nom de l'objet.
     * @param pds Style de l'objet.
     * @param p Poids de l'objet.
     */
    public Objet(String n, String pds, int p) {
        nom = n; 
        style = pds; 
        poids = p;
    }
    
    /**
     * Constructeur par copie.
     * 
     * @param oo Objet à copier.
     */
    public Objet(Objet oo) {
        nom = oo.nom; 
        style = oo.style; 
        poids = oo.poids; 
    }
    
    /**
     * Constructeur par défaut.
     * Initialise un objet avec des valeurs par défaut.
     */
    public Objet() {
        nom = "Sable";
        style = "Pas bien"; 
        poids = 0;        
    }

    /**
     * Retourne le nom de l'objet.
     * 
     * @return Le nom de l'objet.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le style de l'objet.
     * 
     * @return Le style de l'objet.
     */
    public String getPoint_de_style() {
        return style;
    }

    /**
     * Retourne le poids de l'objet.
     * 
     * @return Le poids de l'objet.
     */
    public int getPoids() {
        return poids;
    }

    /**
     * Définit le nom de l'objet.
     * 
     * @param nom Nouveau nom de l'objet.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le style de l'objet.
     * 
     * @param style Nouveau style de l'objet.
     */
    public void setPoint_de_style(String style) {
        this.style = style;
    }

    /**
     * Définit le poids de l'objet.
     * 
     * @param poids Nouveau poids de l'objet.
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }
    
    /**
     * Affiche les caractéristiques de l'objet (nom, style, poids).
     */
    public void affiche() {
        System.out.println("Nom : " + nom);
        System.out.println("Style de l'objet : " + style);
        System.out.println("Poids = " + poids); 
    }
}
