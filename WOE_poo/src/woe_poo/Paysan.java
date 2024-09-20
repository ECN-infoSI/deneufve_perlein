/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author benja
 */
public class Paysan extends Personnage{

    public Paysan(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p) {
        super(n, pv, da, ppar, paatt, papar, dmax, p);
    }

    public Paysan(Paysan p2) {
        super(p2);
    }

    public Paysan() {
        super();
    }
}
