/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author benja
 */
public class Archer extends Personnage{
    private int nbFleches;

    public Archer(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p, int nbFlchs) {
        super(n, pv, da, ppar, paatt, papar, dmax, p);
        this.nbFleches = nbFlchs;
    }

    public Archer(Personnage p2, int nbFlchs) {
        super(p2);
        this.nbFleches = nbFlchs;
    }

    public Archer() {
        super();
        this.nbFleches = 0;
    }
    
}
