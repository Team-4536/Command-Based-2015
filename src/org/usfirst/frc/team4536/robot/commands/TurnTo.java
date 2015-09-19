package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnTo extends CommandBase {
	
	double angle;

    public TurnTo(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.setSetpoint(angle);
    	driveTrain.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("angle" + driveTrain.getPosition());
//    	System.out.println("gyro angle" + driveTrain.gyroAngle());
    	System.out.println("target" + driveTrain.onTarget());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        if (driveTrain.onTarget()){
        	return true;
        }
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
