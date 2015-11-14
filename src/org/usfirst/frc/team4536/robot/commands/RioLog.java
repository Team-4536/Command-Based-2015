package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.*;
import org.usfirst.frc.team4536.robot.subsystems.DriveTrain;

/**
 * @author Liam
 * This Class is used to handle all printouts from the roboRIO. To be able to graph information in excel we enter printouts in CSV format. We then select all and copy and paste that data into a text document and save it as a CSV file. You can then open it in excel and make a graph.
 */
public class RioLog extends CommandBase {
	
	int elevatorBottomLimitSwitch, elevatorMiddleLimitSwitch, elevatorTopLimitSwitch;
	
	double prevHeight, height;

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
    	
    	prevHeight = 0;
    	height = 0;
    	
    	// Add titles for data here
    	System.out.println("Time,CycleTime,ElevatorCurrent,"
    			+ "ElevatorHeight,TopLimitSwitchValue,"
    			+ "BottomLimitSwitchValue,MiddleLimitSwitchValue,"
    			+ "TotalCurrent,SecondaryStickY,SecondaryStickX,"
    			+ "MainStickY,MainStickX,LeftDriveTrainCurrent,"
    			+ "RightDriveTrainCurrent,DriveTrainCurrent,"
    			+ "Elevator Velocity");
    	
    }

    // Called repeatedly when this Command is scheduled to run
	/**
	 * @author Liam
	 */
    protected void execute() {
    	
    	height = elevator.getCurrentHeight();
    	
    	//Add printouts in CSV format for data here and remember to add a title above
    	System.out.print(Utilities.getTime() + ","); //Time
    	System.out.print(Utilities.getCycleTime() + ","); //Cycle Time
    	System.out.print(elevator.getCurrent() + ","); //Elevator Current
    	System.out.print(elevator.getCurrentHeight() + ","); // Elevator Height
    	System.out.print(elevator.topLimitSwitchValue() ? 1: 0 + ","); //Top Limit Switch Value
    	System.out.print(elevator.bottomLimitSwitchValue() ? 1: 0 + ","); //Bottom Limit Switch Value
    	System.out.print(elevator.middleLimitSwitchValue() ? 1: 0 + ","); //Middle Limit Switch Value
    	System.out.print(Utilities.getTotalCurrent() + ","); //Total Current
    	System.out.print(OI.secondaryStick.getY() + ","); // Secondary Stick Y
    	System.out.print(OI.secondaryStick.getX() + ","); // Secondary Stick X
    	System.out.print(OI.mainStick.getY() + ","); // Main Stick Y
    	System.out.print(OI.mainStick.getX()); // Main Stick X
    	System.out.print(DriveTrain.getLeftCurrent() + ","); // Left Drive Train Current
    	System.out.print(DriveTrain.getRightCurrent() + ","); // Right Drive Train Current
    	System.out.print(DriveTrain.getCurrent() + ","); // Drive Train Current
    	System.out.print((height-prevHeight)/Utilities.getCycleTime() + ","); //Velocity
    	System.out.println("");
    	
    	prevHeight = height;
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
