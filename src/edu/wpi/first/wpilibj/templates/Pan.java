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
public class Pan {
       private boolean prevState=false;
       Servo walls;
       private final int PORT=8;
       
    public Pan(){
       walls = new Servo(PORT);
       
    }
    public void set(double value){
        walls.set(value);
    }
    public double get(){
       return walls.get();
    }
    public boolean getPrevState(){
        return prevState;
    }
    public void setState(boolean newState){
        this.prevState=newState;
    }
    public void changeState(){
        prevState=!prevState;
    }
    public void endGame(){ //verify directionality
        walls.set(0); //walls fall //changed from 1 to 0
    }
    public void resetServo(){
        walls.set(1); //servo resets for next time //changed from 0 to 1
    }
    
  
}
