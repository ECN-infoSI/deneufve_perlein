/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author benja
 */
public class Joueur {
    private Personnage persoJoueur;
    private ArrayList<Objet> inventaire;
    private ArrayList<Objet> effets;
    public boolean enDeplacement;

    public Joueur(Personnage persoJoueur) {
        this.persoJoueur = persoJoueur;
        if (persoJoueur instanceof Paysan) {
            throw new IllegalArgumentException("Un Paysan ne peut pas être choisi par le joueur");
        }
        this.inventaire = new ArrayList<Objet>();
        this.effets = new ArrayList<Objet>();
        this.enDeplacement = false;
    }

    public Joueur() {
        persoJoueur = new Guerrier();
        this.inventaire = new ArrayList<Objet>();
        this.enDeplacement = false;
        this.effets = new ArrayList<Objet>();
    }

    public ArrayList<Objet> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<Objet> inventaire) {
        this.inventaire = inventaire;
    }

    public ArrayList<Objet> getEffets() {
        return effets;
    }

    public void setEffets(ArrayList<Objet> effets) {
        this.effets = effets;
    }

    public void setPersoChoisi(Personnage persoJoueur) {
        this.persoJoueur = persoJoueur;
    }

    public Personnage getPersoChoisi() {
        return persoJoueur;
    }

    public synchronized boolean isEnDeplacement() {
        return enDeplacement;
    }

    public synchronized void setEnDeplacement(boolean enDeplacement) {
        this.enDeplacement = enDeplacement;
    }
    
    
    
    
}
