package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

public class Piston {
	
	
	Solenoid leftSolenoid;
	Solenoid rightSolenoid;
	
	/**
	 * @author Stepan
	 * @param leftSolenoidChannel channel that the left solenoid is plugged into on the roboRIO
	 * @param rightSolenoidChannel channel that the right solenoid is plugged into on the roboRIO
	 */
	public Piston(int leftSolenoidChannel, int rightSolenoidChannel) {
		leftSolenoid = new Solenoid(leftSolenoidChannel);
		rightSolenoid = new Solenoid(rightSolenoidChannel);
	}
	
	/**
	 * @author Stepan
	 */
	public void retract() {
		leftSolenoid.set(true);
		rightSolenoid.set(false);
	}
	
	/**
	 * @author Stepan
	 */
	public void extend() {
		leftSolenoid.set(false);
		rightSolenoid.set(true);
	}
	
	/**
	 * @author Stepan
	 * Sets the state of piston as the opposite of its current state
	 */
	public void flip() {
		leftSolenoid.set(!leftSolenoid.get());
		rightSolenoid.set(!rightSolenoid.get());
	}
	
	/**
	 * @author Stepan
	 */
	public boolean isExtended() {
		return rightSolenoid.get();
	}
}
