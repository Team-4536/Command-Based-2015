package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import java.lang.Math;

import org.usfirst.frc.team4536.robot.Utilities;

/**
 *
 */
public class DriveToDistance extends CommandBase {
	
	double desiredDistance = 0;
	double maxSpeed;
	double maxAccel;

    public DriveToDistance(double distance, double maxSpeed, double maxAccel) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	this.desiredDistance = distance;
    	this.maxSpeed = maxSpeed;
    	this.maxAccel = maxAccel;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.encoderReset();
    	driveTrain.gyroReset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.arcadeDrive(maxSpeed*Utilities.limit(desiredDistance - driveTrain.getDistance()),
    							-(maxSpeed/6)*driveTrain.gyroAngle());
    	System.out.println(driveTrain.getDistance());
    	System.out.println(driveTrain.gyroAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(desiredDistance - driveTrain.getDistance()) < 0.5 
    				&& driveTrain.getEncoderRate() < 0.5
    				&& Math.abs(driveTrain.gyroAngle()) < 1 
    				&& (driveTrain.gyroAngleRate() < Math.abs(1))){
    		return true;
    	}
    	
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}