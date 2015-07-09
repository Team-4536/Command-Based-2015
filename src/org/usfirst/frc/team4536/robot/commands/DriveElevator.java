
package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.commands.CommandBase;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;
import org.usfirst.frc.team4536.robot.Utilities;

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

    	
    	if (OI.secondaryStick.getRawButton(6) == true){
    		elevator.drive(Utilities.deadZone(-OI.secondaryStick.getY(),0.05));
    		elevator.setDesiredHeight(elevator.getCurrentHeight());
    		//The elevator drives dependent on the joystick, back to move up, forward to move down
    	}
    	
    	else elevator.goToDesiredHeight();
    	
    	if (OI.secondaryStick.getRawButton(3) == true){
    		elevator.setDesiredHeight(0);
    	}
    	
    	elevator.update();
    	
    	
    	System.out.println("encoder" + elevator.getEncoderHeight());
    	System.out.println("desired" + elevator.getDesiredHeight());
    	System.out.println("current" + elevator.getCurrentHeight());
    	
    	
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
