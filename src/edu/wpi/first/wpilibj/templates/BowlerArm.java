/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author robotics
 */
public class BowlerArm {
    //NEED TO FIX SPEED TO DIRECTION CORRELATION!!!!!!!!!!!!

    private Jaguar ramp1;
    private Jaguar ramp2;
    private DoubleSolenoid arm;
    private final int JAG_PORT_1 = 5;
    private final int JAG_PORT_2 = 6;

    private final int ARM_FORWARD_PORT = 1; //orig 0; corrected to 1
    private final int ARM_BACKWARD_PORT = 2; //orig 0; corrected to 2
    private final double RAMP_SPEED = 0.25;
    private final long RAMP_WAIT = 1000;
    private final long ARM_WAIT=10;

    public BowlerArm() {
        ramp1 = new Jaguar(JAG_PORT_1);
        ramp2 = new Jaguar(JAG_PORT_2);

        arm = new DoubleSolenoid(ARM_FORWARD_PORT, ARM_BACKWARD_PORT);

    }
    /*
     forward, backward, or off. 
     */

    public void setSolenoid(int value) {
        if (value == 1) {
            arm.set(DoubleSolenoid.Value.kForward); //forward (out)
        } else if (value == 0) {
            arm.set(DoubleSolenoid.Value.kOff); //off
        } else if (value == -1){
            arm.set(DoubleSolenoid.Value.kReverse); //backward (in)
        }
    }

    
    public void setRamp(double value) {
        ramp1.set(value);
        ramp2.set(value);

    }
    
    public void rampDown(){
        setRamp(-RAMP_SPEED);
    }
    
    public void rampUp(){
        setRamp(RAMP_SPEED);
    }

    public void auto()  {
        //down
        setRamp(RAMP_SPEED); //verify sign to physical direction!!!!!!!!
        RobotTemplate.sleep(ARM_WAIT);
        //to be determined 
        setRamp(0);
        //out
        setSolenoid(1);
        //out
     
    
        //in
        setSolenoid(-1); //in
        //up
        setRamp(-RAMP_SPEED); //verify sign to physical direction!!!!!!!!
        RobotTemplate.sleep(RAMP_WAIT);
        setRamp(0);
    }
    

}
