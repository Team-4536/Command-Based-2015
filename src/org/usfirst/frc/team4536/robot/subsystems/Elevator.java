package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team4536.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;;


public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon elevatorTalon;
	Encoder elevatorEncoder;
	DigitalInput topLimitSwitch;
	DigitalInput middleLimitSwitch;
	DigitalInput bottomLimitSwitch;
	
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
     * @ param verticalThrottle - The throttle input into the elevator motor
     */
	public void drive(double verticalThrottle){
		elevatorTalon.set(verticalThrottle);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here
        //setDefaultCommand(new MySpecialCommand());
    
    	
    }
}

