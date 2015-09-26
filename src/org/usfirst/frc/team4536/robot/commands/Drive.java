package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.subsystems.PIDDriveTrain;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;
import org.usfirst.frc.team4536.robot.Utilities;

public class Drive extends CommandBase {
	
	private static double forwardThrottle, turnThrottle;
	
	/**
	 * @author Noah
	 */
	public Drive() {
		requires(driveTrain);
	}
	
	/**
	 * @author Stepan and Liam
	 */
	protected void initialize() {
		PIDDriveTrain.prevForwardThrottle = 0.0;
		PIDDriveTrain.prevTurnThrottle = 0.0;
		
		forwardThrottle = 0;
		turnThrottle = 0;
		
		driveTrain.arcadeDrive(0.0, 0.0);
    }
	
	/**
	 * @author Noah, Liam and Stepan
	 */
    protected void execute() {
    	
    	Utilities.updateCycleTime();
    	
    	forwardThrottle = Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE);
    	turnThrottle = Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE);
    	
    	forwardThrottle = Utilities.speedCurve(forwardThrottle, Constants.FORWARD_SPEED_CURVE);
    	turnThrottle = Utilities.speedCurve(turnThrottle, Constants.TURN_SPEED_CURVE);
    	
    	forwardThrottle = Utilities.accelLimit(forwardThrottle, PIDDriveTrain.getPrevForwardThrottle(), Constants.FORWARD_FULL_SPEED_TIME);
    	turnThrottle = Utilities.accelLimit(turnThrottle, PIDDriveTrain.getPrevTurnThrottle(), Constants.TURN_FULL_SPEED_TIME);
    	
    	driveTrain.arcadeDrive(forwardThrottle, turnThrottle);
    	
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
