package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.*;

/**
 * @author Liam
 * This Class is used to handle all printouts from the roboRIO. To be able to graph information in excel we enter printouts in CSV format. We then select all and copy and paste that data into a text document and save it as a CSV file. You can then open it in excel and make a graph.
 */
public class RioLog extends CommandBase {

	/**
	 * @author Liam
	 */
    public RioLog() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
	/**
	 * @author Liam
	 */
    protected void initialize() {
    	//TODO add label printouts here
    	//System.out.print(arg0);
    }

    // Called repeatedly when this Command is scheduled to run
	/**
	 * @author Liam
	 */
    protected void execute() {
    	
    	System.out.print(Utilities.getTime() + ","); //Time
    	System.out.print(Utilities.getCycleTime() + ","); //Cycle Time
    	System.out.print(Utilities.getCurrent(2) + ","); //Elevator Current
    	System.out.print(elevator.getCurrentHeight() + ","); // Elevator Height
    	System.out.print(elevator.topLimitSwitchValue() + ","); //Top Limit Switch Value
    	System.out.print(elevator.bottomLimitSwitchValue() + ","); //Bottom Limit Switch Value
    	System.out.print(elevator.middleLimitSwitchValue() + ","); //Middle Limit Switch Value
    	System.out.print(Utilities.getTotalCurrent() + ","); //Total Current
    	System.out.print(OI.secondaryStick.getY() + ","); // Secondary Stick Y
    	System.out.print(OI.secondaryStick.getX() + ","); // Secondary Stick X
    	System.out.print(OI.mainStick.getY() + ","); // Main Stick Y
    	System.out.print(OI.mainStick.getX()); // Main Stick X
    	System.out.println("");
    }

    // Make this return true when this Command no longer needs to run execute()
	/**
	 * @author Liam
	 */
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
	/**
	 * @author Liam
	 */
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
	/**
	 * @author Liam
	 */
    protected void interrupted() {
    }
}
