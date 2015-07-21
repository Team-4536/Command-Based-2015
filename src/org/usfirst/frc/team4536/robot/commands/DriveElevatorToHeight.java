package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveElevatorToHeight extends CommandBase {
 
 double desiredHeight;
 double speedLimit;

    public DriveElevatorToHeight(double Height, double speedLimit) {
        // Use requires() here to declare subsystem dependencies
        requires(elevator);
        desiredHeight = Height;
        this.speedLimit = speedLimit;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
     
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
     
     elevator.update();
     elevator.drive(speedLimit*Utilities.limit(desiredHeight - elevator.getCurrentHeight())); 
     System.out.println("desired" + desiredHeight);
     
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
     elevator.drive(0);
    }
}
