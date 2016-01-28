package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4536.robot.UglyRectangle;

/**
 *
 */
public class DriveUglyRectangle extends CommandBase {
	
	Timer timer = new Timer();
	UglyRectangle tangle;

    public DriveUglyRectangle(double distance, double maxVelocity) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	tangle = new UglyRectangle(distance, maxVelocity);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTrain.arcadeDrive(tangle.throttle(timer.get()), 0);
    	//Gives the driveTrain the desired speed for the amount of time needed to achieve the distance
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
