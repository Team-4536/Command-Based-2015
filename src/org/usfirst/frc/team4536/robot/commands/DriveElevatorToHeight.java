package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveElevatorToHeight extends CommandBase {
 
 double desiredHeight;

    public DriveElevatorToHeight(double Height) {
        // Use requires() here to declare subsystem dependencies
        requires(elevator);
        desiredHeight = Height;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
     
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
     
     elevator.update();
     elevator.drive(Utilities.limit(desiredHeight - elevator.getCurrentHeight())); 
     
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