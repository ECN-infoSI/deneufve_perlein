package org.centrale.objet.WoE;

/**
 * Classe représentant un lapin, un type de monstre dans le jeu.
 * Hérite de la classe Monstre.
 */
public class Lapin extends Monstre {

    /**
     * Constructeur avec paramètres.
     * 
     * @param ptVie Points de vie du lapin.
     * @param degAtt Dégâts d'attaque.
     * @param ptPar Points de parade.
     * @param pageAtt Pourcentage d'attaque.
     * @param pagePar Pourcentage de parade.
     * @param pos Position du lapin.
     */
    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }

    /**
     * Constructeur par copie.
     * 
     * @param m Lapin à copier.
     */
    public Lapin(Lapin m) {
        super(m);
    }

    /**
     * Constructeur par défaut.
     */
    public Lapin() {
        super();
    } 
}
