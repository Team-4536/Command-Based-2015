package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

public class Piston {
	
	Solenoid leftSolenoid;
	Solenoid rightSolenoid;
	
	public Piston(int leftSolenoidChannel, int rightSolenoidChannel) {
		leftSolenoid = new Solenoid(leftSolenoidChannel);
		rightSolenoid = new Solenoid(rightSolenoidChannel);
	}
	
	public void retract() {
		leftSolenoid.set(true);
		rightSolenoid.set(false);
	}
	
	public void extend() {
		leftSolenoid.set(false);
		rightSolenoid.set(true);
	}
	
	public void flip() {
		leftSolenoid.set(!leftSolenoid.get());
		rightSolenoid.set(!rightSolenoid.get());
	}
	
	public boolean isExtended() {
		return rightSolenoid.get();
	}
}
