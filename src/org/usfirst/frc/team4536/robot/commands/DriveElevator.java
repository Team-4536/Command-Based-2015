package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.commands.CommandBase;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;

/**
 *
 */
public class DriveElevator extends CommandBase {

    public DriveElevator() {
        // Use requires() here to declare subsystem dependencies
    	requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if ((elevator.topLimitSwitchValue() == true) && (OI.secondaryStick.getY() > 0)){
    		elevator.drive(0);
    	}
    	else if (((elevator.bottomLimitSwitchValue() == true) 
    			|| (elevator.middleLimitSwitchValue() == true)) 
    			&& (OI.secondaryStick.getY() < 0)){
    		elevator.drive(0);
    	}
    	
    	else
    		elevator.drive(-OI.secondaryStick.getY());
    	
    	System.out.println(elevator.topLimitSwitchValue());
    	
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
