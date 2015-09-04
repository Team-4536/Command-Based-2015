package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardCommand extends CommandBase {
	
	/**
	 * @author Stepan
	 */
	public SmartDashboardCommand() {}
	
	/**
	 * @author Stepan
	 */
	protected void initialize() {
		
    }
	
	/**
	 * @author Stepan
	 */
    protected void execute() {
    	SmartDashboard.putNumber("Time", Utilities.getTime());
    	SmartDashboard.putNumber("Cycle Time", Utilities.getCycleTime());
    	SmartDashboard.putNumber("Motor Current", Utilities.getCurrent(1));
    	SmartDashboard.putNumber("Total Current", Utilities.getTotalCurrent());
    	
    	System.out.print(Utilities.getTime() + ","); //Time
    	System.out.print(Utilities.getCycleTime() + ","); //Cycle Time
    	System.out.print(Utilities.getCurrent(1) + ","); //Motor Current
    	System.out.print(Utilities.getTotalCurrent() + ","); //Total Current
    	System.out.println("");
    }
    
    /**
	 * @author Stepan
	 * @return Whether the command is safe to be finished (true if it can be finished)
	 */
    protected boolean isFinished() {
        return false;
    }
    
    /**
	 * @author Stepan
	 */
    protected void end() {
    	
    }
    
    /**
	 * @author Stepan
	 */
    protected void interrupted() {
    	end();
    }

}