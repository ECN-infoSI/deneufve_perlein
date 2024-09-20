/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author benja
 */
public class Point2D {
    private int x;
    private int y;
    
    public Point2D(int xpos, int ypos){
            x = xpos;
            y = ypos;
    }
    public Point2D(Point2D point){
            x = point.x;
            y = point.y;
    }
    public Point2D(){
            x = 0;
            y = 0;
    }  
    public void setxPoint2D(int xpos){
        x = xpos;
    }
    
    public void setyPoint2D(int ypos){
        y = ypos;
    }
    public int getxpoint(){
        return(x);
    }
    public int getypoint(){
        return(y);
    }
    public void setPosition(int xpos, int ypos){
        x = xpos;
        y = ypos;
    }
    public void translate(int dx, int dy){
        x+=dx;
        y+=dy;
    }
    public void affiche(){
        System.out.println("x= " + x +"y=" +y); 
    }
    public double distance(Point2D p2){
        return Math.sqrt((p2.x-x)*(p2.x-x)+(p2.y-y)*(p2.y-y));
    }
    
    public boolean equal(Point2D p2) {
        return p2 != null && x==p2.x && y == p2.y ; 
    }
}
