package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4536.robot.UglyRectangle;

/**
 *
 */
public class DriveUglyRectangleWithEncoder extends CommandBase {
	
	Timer timer = new Timer();
	double time;
	double desiredDistance;
	double maxVelocity;
	UglyRectangle tangle;

    public DriveUglyRectangleWithEncoder(double distance, double maxVelocity) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	tangle = new UglyRectangle(distance, maxVelocity);
    	this.desiredDistance = distance;
    	this.maxVelocity = maxVelocity;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	driveTrain.encoderReset();
    	driveTrain.gyroReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	time = timer.get();
    	
    	driveTrain.arcadeDrive(tangle.throttle(time) + 
    			0.75*(tangle.idealDistance(time) - driveTrain.getDistance()/12),
    			-(maxVelocity/24.6)*driveTrain.gyroAngle());
    	//Ask Caleb or Mairead on the implementation of feedforward+feedback
    	
    	System.out.println(driveTrain.getDistance()/12);
    	//Since getDistance is in feet, you have to divide by 12 to inches
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(driveTrain.getDistance() - desiredDistance) < 0.04
    			//in feet, true if the robot is within half of an inch away from the desired distance
    		&& Math.abs(driveTrain.getEncoderRate()) < 0.5)
    			//in inches, true in the robot is moving at a steep of less than half an inch
    	{
    		return true;
    	}
    	else
    		return false;
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
