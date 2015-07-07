package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

public class Comp extends Subsystem{
	
	Compressor comp;
	
	public Comp() {
		comp = new Compressor();
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void StartComp() {
		comp.start();
	}
	
	public void StopComp() {
		comp.stop();
	}
	
}
