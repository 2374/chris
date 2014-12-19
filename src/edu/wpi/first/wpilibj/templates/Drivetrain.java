/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author robotics
 */
public class Drivetrain {
    private Jaguar fleft;
    private Jaguar fright;
    private Jaguar bleft;
    private Jaguar bright;
    /*
    private Jaguar[] jags = new Jaguar[4];
 
    */
    private final int FRONT_LEFT_PORT=3;
    private final int FRONT_RIGHT_PORT=1;
    private final int BACK_LEFT_PORT=4;
    private final int BACK_RIGHT_PORT=2;
    
    public Drivetrain(){
        /*
        jags[0]=new Jaguar(FRONT_LEFT_PORT);
        jags[1]=new Jaguar(FRONT_RIGHT_PORT);
        jags[2]=new Jaguar(BACK_LEFT_PORT);
        jags[3]=new Jaguar(BACK_RIGHT_PORT);
        */
        fleft = new Jaguar(FRONT_LEFT_PORT); 
        fright = new Jaguar(FRONT_RIGHT_PORT);
        bleft = new Jaguar(BACK_LEFT_PORT); 
        bright = new Jaguar(BACK_RIGHT_PORT);
    }
    public void set(double lspeed, double rspeed){
        fleft.set(-lspeed); // -lspeed = forward
        fright.set(rspeed);
        bleft.set(-lspeed);
        bright.set(rspeed);
        
    }
  /*  public void setLeftSpeed(double speed){
        jags[0].set(speed);
        jags[2].set(speed);
    }*/
      /*  public void setRightSpeed(double speed){
        jags[1].set(speed);
        jags[3].set(speed);
    }*/
}
