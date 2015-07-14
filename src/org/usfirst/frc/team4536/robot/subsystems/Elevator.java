package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.DigitalInput;


public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 
 Talon elevatorTalon;
 Encoder elevatorEncoder;
 DigitalInput topLimitSwitch;
 DigitalInput middleLimitSwitch;
 DigitalInput bottomLimitSwitch;
 
 double actualHeight;
 double setHeight;
 double currentHeight;
 double correction;
 
 
 public Elevator (int talonChannel, 
   int encoderAChannel,
   int encoderBChannel,
   int topLimitSwitchChannel, 
   int middleLimitSwitchChannel,
   int bottomLimitSwitchChannel)
 {
  elevatorTalon = new Talon(talonChannel);
     elevatorEncoder = new Encoder(encoderAChannel, encoderBChannel);
     //For our particular Robot "Zenith" in the 2014-2015 competition The A Channel has only the signal wire
     topLimitSwitch = new DigitalInput(topLimitSwitchChannel);
     middleLimitSwitch = new DigitalInput(middleLimitSwitchChannel);
     bottomLimitSwitch = new DigitalInput(bottomLimitSwitchChannel); 
 }
 
    /**
     * @ author: Mairead
     * @ return: True if switch is pressed
     */
 public boolean topLimitSwitchValue() {
  
  return !topLimitSwitch.get();
 }
 
 /**
     * @ author: Mairead
     * @ return: True if switch is pressed
     */
 public boolean middleLimitSwitchValue(){
  return !middleLimitSwitch.get();
 }
 
 /**
     * @ author: Mairead
     * @ return: True if switch is pressed
     */
 public boolean bottomLimitSwitchValue(){
  return !bottomLimitSwitch.get();
 }
   
 /**
     * @ author: Mairead
     * @ param verticalThrottle - The throttle input into the elevator motor.
     *          Values go from -1 to 1
     *          Positive values make the elevator go up, negative makes the elevator go down 
     */
 public void drive(double verticalThrottle){
  
  //Makes sure that the elevator can only drive when not hitting a limit switch
  
     if ((this.topLimitSwitchValue() == true) && (verticalThrottle > 0)){
      //If the elevator hits the top limit switch it can go down but not up
      
      this.drive(0);
     }
     else if (((this.bottomLimitSwitchValue() == true) 
       || (this.middleLimitSwitchValue() == true)) 
       && (verticalThrottle < 0)){
      //If the elevator hits the middle or bottom limit switch it can go up but not down
      
      this.drive(0);
     }
     
     else
      elevatorTalon.set(-verticalThrottle);
 }
 
 
 public void setActualHeight(double actualHeight){
  correction = actualHeight - elevatorEncoder.get()/Constants.TICKS_PER_INCHES;
 }
 
 public void update(){
  currentHeight = correction + elevatorEncoder.get()/Constants.TICKS_PER_INCHES;
  
  if (this.topLimitSwitchValue()) {
   setActualHeight(Constants.TOP_LIMIT_SWITCH_HEIGHT);
  }
  
  if (this.middleLimitSwitchValue()) {
   setActualHeight(Constants.MIDDLE_LIMIT_SWITCH_HEIGHT);
  }
  
  if (this.bottomLimitSwitchValue() == true) {
   setActualHeight(Constants.BOTTOM_LIMIT_SWITCH_HEIGT);
  }
   

 }
 
 public double getEncoderHeight(){
  return elevatorEncoder.getDistance();
 }
 
 public double getCurrentHeight(){
  return currentHeight;
 }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here
        //setDefaultCommand(new MySpecialCommand()); 
    }
}

