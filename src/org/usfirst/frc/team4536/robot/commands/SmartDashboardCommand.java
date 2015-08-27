package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.subsystems.DriveTrain;

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
    	SmartDashboard.putNumber("Right Encoder Ticks: ", DriveTrain.getRightEncoderTicks());
    	SmartDashboard.putNumber("Left Encoder Ticks: ", DriveTrain.getLeftEncoderTicks());
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