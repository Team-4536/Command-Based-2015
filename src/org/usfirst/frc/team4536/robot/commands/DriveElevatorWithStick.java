
package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.commands.CommandBase;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *
 */


public class DriveElevatorWithStick extends CommandBase {

    public DriveElevatorWithStick() {
        // Use requires() here to declare subsystem dependencies
     requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
     
     elevator.drive(OI.secondaryStick.getY());  
     elevator.update();
     System.out.println("drive with stick");
     
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
    	this.end();
    }
}
