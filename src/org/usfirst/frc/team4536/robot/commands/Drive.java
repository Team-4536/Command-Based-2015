package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Robot;

public class Drive extends Command {
	
	public Drive() {
		requires(Robot.driveTrain);
		requires(Robot.oi);
	}
	
	protected void initialize() {
    }
	
    protected void execute() {
    	Robot.driveTrain.arcadeDrive(OI., );
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }

    protected void interrupted() {
    }

}
