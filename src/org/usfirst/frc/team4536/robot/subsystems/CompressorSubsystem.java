package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

public class CompressorSubsystem extends Subsystem{
	
	Compressor compressor;
	
	/**
	 * @author Stepan
	 */
	public CompressorSubsystem() {
		compressor = new Compressor();
	}
	
	/**
	 * @author Stepan
	 */
	public void initDefaultCommand() {
		
	}
	
	/**
	 * @author Stepan
	 */
	public void startComp() {
		compressor.start();
	}
	
	/**
	 * @ author Stepan
	 */
	public void stopComp() {
		compressor.stop();
	}
}
