package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends CommandBase {
	
	/**
	 * @author Noah
	 */
	public Drive() {
		requires(driveTrain);
	}
	
	protected void initialize() {
		DriveTrain.prevThrottleL = 0.0;
		DriveTrain.prevThrottleR = 0.0;
		DriveTrain.prevThrottleX = 0.0;
		DriveTrain.prevThrottleY = 0.0;
		
		driveTrain.arcadeDrive(0.0, 0.0);
    }
	
	/**
	 * @author Noah
	 */
    protected void execute() {
    	driveTrain.arcadeDrive(
    			Utilities.accelLimit(
    			Utilities.speedCurve(
    			Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE),
    			Constants.SPEED_CURVE),
    			driveTrain.getPrevThrottleY(), Constants.ACCEL_LIMIT),
    			
    			Utilities.accelLimit(
    			Utilities.speedCurve(
    			Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE),
    			Constants.SPEED_CURVE),
    			driveTrain.getPrevThrottleX(), Constants.ACCEL_LIMIT));
    	
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
