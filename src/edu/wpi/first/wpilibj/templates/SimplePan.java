/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author robotics
 */
public class SimplePan {
    //make sure 'full right to full left' of servo oriented correctly
    //values for walls down/up may be backwards; please verify
    Servo walls;
    private final int PORT=8;
    
    public SimplePan(){
        walls = new Servo(PORT);
    }
    
    public void wallsDown(){
        walls.set(1);
    }
    
    public void wallsReset(){
        walls.set(0);
    }
    
    
    
}
