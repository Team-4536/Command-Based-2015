package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends CommandBase {
	
	double speedLimit;
	
	/**
	 * @author Noah
	 */
	public Drive(double speedLimit) {
		requires(driveTrain);
		this.speedLimit = speedLimit;
	}
	
	protected void initialize() {
    }
	
	/**
	 * @author Noah
	 */
    protected void execute() {
    	driveTrain.arcadeDrive(speedLimit*Utilities.speedCurve(Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE), Constants.SPEED_CURVE), speedLimit*Utilities.speedCurve(Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE), Constants.SPEED_CURVE));
    	SmartDashboard.putNumber("Time", Utilities.getTime());
    	SmartDashboard.putNumber("Cycle Time", Utilities.getCycleTime());
    }
    
    protected boolean isFinished() {
    	
        return false;
    }
    
    /**
	 * @author Stepan
	 */
    protected void end() {
    	driveTrain.arcadeDrive(0, 0);
    }
    
    /**
	 * @author Noah and Stepan
	 */
    protected void interrupted() {
    	end();
    }

}
