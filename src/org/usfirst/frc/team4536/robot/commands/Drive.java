package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends CommandBase {
	
	private static double deadZoneY = 0.0, deadZoneX = 0.0,
						speedCurveY = 0.0, speedCurveX = 0.0,
						finalThrottleY = 0.0, finalThrottleX = 0.0;
	
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
	 * @author Noah and Liam
	 */
    protected void execute() {
    	
    	deadZoneY = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
    	deadZoneX = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
    	
    	speedCurveY = Utilities.speedCurve(deadZoneY, Constants.FORWARD_SPEED_CURVE);
    	speedCurveX = Utilities.speedCurve(deadZoneX, Constants.TURN_SPEED_CURVE);
    	
    	finalThrottleY = Utilities.accelLimit(speedCurveY, DriveTrain.getPrevThrottleY(), Constants.ACCEL_LIMIT);
    	finalThrottleX = Utilities.accelLimit(speedCurveX, DriveTrain.getPrevThrottleX(), Constants.ACCEL_LIMIT);
    	
    	SmartDashboard.putNumber("Previous Y:", DriveTrain.getPrevThrottleY());
    	SmartDashboard.putNumber("throttleY", finalThrottleY);
    	SmartDashboard.putNumber("throttleX", finalThrottleX);
    	
    	driveTrain.arcadeDrive(finalThrottleY, finalThrottleX);
    	
    	SmartDashboard.putNumber("Updated Previous Y", DriveTrain.getPrevThrottleY());
    	
    	/*driveTrain.arcadeDrive(
    			
    			
    			/*Utilities.accelLimit(
    			Utilities.speedCurve(
    			Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE),
    			Constants.SPEED_CURVE),
    			driveTrain.getPrevThrottleY(), Constants.ACCEL_LIMIT),
    			
    			Utilities.accelLimit(
    			Utilities.speedCurve(
    			Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE),
    			Constants.SPEED_CURVE),
    			driveTrain.getPrevThrottleX(), Constants.ACCEL_LIMIT));*/
    	
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
