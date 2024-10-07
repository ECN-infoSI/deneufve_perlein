/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Scanner;

/**
 *
 * @author benja
 */
public class Joueur {
    private Personnage persoChoisi;

    public Joueur(Personnage persoChoisi) {
        this.persoChoisi = persoChoisi;
        if (persoChoisi instanceof Paysan) {
            throw new IllegalArgumentException("Un Paysan ne peut pas être choisi par le joueur");
        }
    }

    public Joueur() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choisissez la classe de votre personnage parmi: 1.Guerrier - 2.Archer");
        int choix = scanner.nextInt();
        
        switch(choix){
            case 1:
                persoChoisi = new Guerrier();
                break;
            case 2:
                persoChoisi = new Archer();
                break;
        }
    }
}
