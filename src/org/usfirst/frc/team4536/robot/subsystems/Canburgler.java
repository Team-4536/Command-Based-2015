package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.subsystems.Piston;

public class Canburgler extends Piston {
	
	/**
	 * @author Noah
	 * @param leftSolenoidChannel
	 * @param rightSolenoidChannel
	 */
	public Canburgler(int leftSolenoidChannel, int rightSolenoidChannel) {
		super(leftSolenoidChannel, rightSolenoidChannel);
		extend();
	}
	
	public void initDefaultCommand() {
	    // Set the default command for a subsystem here.
	    //setDefaultCommand(new MySpecialCommand());	    	
	}
}
