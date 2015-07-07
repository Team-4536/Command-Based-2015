package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;
import org.usfirst.frc.team4536.robot.Utilities;

public class Drive extends CommandBase {
	
	/**
	 * @author Noah
	 */
	public Drive() {
		requires(driveTrain);
	}
	
	protected void initialize() {
    }
	
	/**
	 * @author Noah
	 */
    protected void execute() {
    	driveTrain.arcadeDrive(Utilities.speedCurve(Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE), Constants.SPEED_CURVE), Utilities.speedCurve(Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE), Constants.SPEED_CURVE));
    	smartDashboard.putNumber("Caleb is Wrong", OI.mainStick.getY());
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    /**
	 * @author Noah
	 */
    protected void interrupted() {
    	driveTrain.arcadeDrive(0, 0);
    }

}
