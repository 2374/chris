/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SimpleRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {

    private Joystick joystick = new Joystick(1);
    private Drivetrain drivetrain;
    private BowlerArm arm;
    Compressor compressor;
    Pan pan;
    //int port_1 = 7; //these ports were placeholders, no longer applicable
    //int port_2 = 7;

    public RobotTemplate() {
        drivetrain = new Drivetrain();
        arm = new BowlerArm();
        pan = new Pan();
        compressor = new Compressor(7, 7);//7 for the switch, 7 for the relay

    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        drivetrain.set(1, 1);
        sleep(5000);
        drivetrain.set(0,0);
      //  arm.auto();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        compressor.start();
        arm.setSolenoid(-1);
        while (isOperatorControl()) {
            //drivetrain updates
            double lstick = -joystick.getRawAxis(2);
            double rstick = -joystick.getRawAxis(4);
            drivetrain.set(Math.abs(lstick) * lstick, Math.abs(rstick) * rstick); //If I'm not mistaken, this is the most convenient way to square in Java?
            
            
            //pan updates version 2 (Amita); this is basic and can be used for backup
            if(joystick.getRawButton(10)){
                pan.endGame();
            }
            else{
                pan.resetServo();
            }

            //bowler arm updates
                                
            if (joystick.getRawButton(7)) {
                arm.rampDown();
            } else if (joystick.getRawButton(5)) {
                arm.rampUp();
            }  else {
                arm.setRamp(0);
            }
            arm.setSolenoid((int) joystick.getRawAxis(6));
            
        }
    }
    /*
     *changes the servo state based on the button being pressed. 
     *once it is pressed, it is set to the opposite of what is was at the start, ditto for release. 
     */
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {

    }
    public void updateDrivetrain(){
        
    }
    public void updateArm(){
        
    }
    public void updatePan(){
        
    }
    public static void sleep(long ms){
        long t=System.currentTimeMillis()+ms;
        while(System.currentTimeMillis()<t){
            //do nothing!
        }
    }
}
