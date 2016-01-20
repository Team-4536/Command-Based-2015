package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import java.lang.Math;

/**
 *
 */
public class DriveToDistance extends CommandBase {
	
	double desiredDistance = 0;

    public DriveToDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	this.desiredDistance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.encoderReset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.arcadeDrive(.3, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(desiredDistance - driveTrain.getDistance()) < 0.5 && driveTrain.getEncoderRate() < 0.5 ){
    		return true;
    	}
    	
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
