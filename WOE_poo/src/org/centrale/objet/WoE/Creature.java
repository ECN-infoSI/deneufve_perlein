/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import org.centrale.objet.WoE.Point2D;

/**
 *
 * @author benja
 */
public class Creature {
    private int ptVie;   
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    }
    
    public Creature(Creature c){
        ptVie = c.ptVie;
        degAtt = c.degAtt;
        ptPar= c.ptPar;
        pageAtt = c.pageAtt;
        pagePar= c.pagePar;
        pos = c.pos;        
    }
    public Creature(){
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

    public void deplace(int taille){
        //à améliorer pour ne pas sortir de la map et ne pas entrer en collision
        Random gen = new Random() ; 
        int dx = gen.nextInt(2) - 1 ; 
        int dy = gen.nextInt(2) - 1 ; 
        
        pos.translate(dx, dy);
    }
}
