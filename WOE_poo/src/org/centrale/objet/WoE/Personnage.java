/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random ;

/**
 *
 * @author benja
 */
public class Personnage {
    private String nom;
    private int ptVie;   
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    private Point2D pos;
  
    public Personnage(String n, int pv, int da, int ppar, int paatt, int papar, int dmax, Point2D p){
        nom = n;
        ptVie = pv;
        degAtt = da;
        ptPar= ppar;
        pageAtt = paatt;
        pagePar= papar;
        distAttMax = dmax;
        pos = p;        
    }
    public Personnage(Personnage p2){
        nom = p2.nom;
        ptVie = p2.ptVie;
        degAtt = p2.degAtt;
        ptPar= p2.ptPar;
        pageAtt = p2.pageAtt;
        pagePar= p2.pagePar;
        distAttMax = p2.distAttMax;
        pos = p2.pos;        
    }
    public Personnage(){
        nom = "SalamWEI";
        ptVie = 0;
        degAtt = 0;
        ptPar= 0;
        pageAtt = 0;
        pagePar= 0;
        distAttMax = 0;
        pos = new Point2D(0,0);        
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String n){
        nom  = n;
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    public void affiche(){
        System.out.println("nom: " + nom);
        System.out.println("Point de vie = " + ptVie);
        System.out.println("Degat d'attaque = " + degAtt);
        System.out.println("Points de parade = " + ptPar);
        System.out.println("Portée d'attaque = " + pageAtt);
        System.out.println("Portée de parade = " + pagePar);
        System.out.println("Distance d'attaque maximale = " + distAttMax);
        pos.affiche();
    }
    public void deplace(int taille){
        
        Random gen = new Random() ; 
        int dx = gen.nextInt(2) - 1 ; 
        int dy = gen.nextInt(2) - 1 ; 
        
        pos.translate(dx, dy);
    }
}
