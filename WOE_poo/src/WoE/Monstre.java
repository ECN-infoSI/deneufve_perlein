/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WoE;

import java.util.logging.Logger;

/**
 *
 * @author benja
 */
public class Monstre {
    
    private int ptVie;   
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }
    
    public Monstre(Monstre m){
        ptVie = m.ptVie;
        degAtt = m.degAtt;
        ptPar= m.ptPar;
        pageAtt = m.pageAtt;
        pagePar= m.pagePar;
        pos = m.pos;        
    }
    public Monstre(){
        ptVie = 0;
        degAtt = 0;
        ptPar= 0;
        pageAtt = 0;
        pagePar= 0;
        pos = new Point2D(0,0);        
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

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public void affiche(){
        System.out.println("Point de vie = " + ptVie);
        System.out.println("Degat d'attaque = " + degAtt);
        System.out.println("Points de parade = " + ptPar);
        System.out.println("Portée d'attaque = " + pageAtt);
        System.out.println("Portée de parade = " + pagePar);
        pos.affiche();
    }
    public void deplace(int dx, int dy){
        pos.translate(dx, dy);
    }
}
