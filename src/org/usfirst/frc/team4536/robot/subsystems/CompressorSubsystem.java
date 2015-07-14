package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

public class CompressorSubsystem extends Subsystem{
	
	Compressor compressor;
	
	public CompressorSubsystem() {
		compressor = new Compressor();
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void startComp() {
		compressor.start();
	}
	
	public void stopComp() {
		compressor.stop();
	}
}
