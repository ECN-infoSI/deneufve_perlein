/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.LinkedList;

/**
 *
 * @author benja
 */
public interface Combattant {
    
    public void combattre(Creature c);
    
    public LinkedList<Creature> creaturesAPortee(World w, int portee);
}
