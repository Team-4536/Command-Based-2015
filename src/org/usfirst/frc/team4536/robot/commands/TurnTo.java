package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnTo extends CommandBase {

    public TurnTo() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.setSetpoint(30);
    	driveTrain.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("angle" + driveTrain.getPosition());
    	System.out.println("gyro angle" + driveTrain.gyroAngle());
    	
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
