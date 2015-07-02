package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;

public class Drive extends CommandBase {
	
	public Drive() {
		requires(driveTrain);
	}
	
	protected void initialize() {
    }
	
    protected void execute() {
    	driveTrain.arcadeDrive(-Robot.oi.getMainStickY(), Robot.oi.getMainStickX());
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }

    protected void interrupted() {
    	driveTrain.arcadeDrive(0, 0);
    }

}
