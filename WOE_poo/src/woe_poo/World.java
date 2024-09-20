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
public class World {
    
    public Archer hog_rider ; 
    public Paysan peon ; 
    public Lapin bugs ; 
    public int taille ;
    
    public void creeMondeAlea(){
             
        Point2D[] l_pos = new Point2D[3] ;
        
        Random gen = new Random() ; 
        
        l_pos[0] = new Point2D(gen.nextInt(taille), gen.nextInt(taille));
        l_pos[1] = new Point2D(gen.nextInt(taille), gen.nextInt(taille));
        l_pos[2] = new Point2D(gen.nextInt(taille), gen.nextInt(taille));
        
        while (l_pos[0].equal(l_pos[1]) || l_pos[0].equal(l_pos[2]) || l_pos[2].equal(l_pos[1])){
            l_pos[0].setPosition(gen.nextInt(taille), gen.nextInt(taille));
            l_pos[1].setPosition(gen.nextInt(taille), gen.nextInt(taille));
            l_pos[2].setPosition(gen.nextInt(taille), gen.nextInt(taille));
        } 
        
        hog_rider.setPos(l_pos[0]) ; 
        peon.setPos(l_pos[1]) ; 
        bugs.setPos(l_pos[2]) ; 
    }
}