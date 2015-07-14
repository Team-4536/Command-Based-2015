package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;

public class ToggleCanburgler extends CommandBase {
	
	public ToggleCanburgler() {
		requires(canburgler);
	}

	protected void initialize() {
		canburgler.flip();
    }
	
	protected void execute() {
		
    }
    
    protected boolean isFinished() {
        return true;
    }
    
    protected void end() {
    	
    }
    
    protected void interrupted() {
    	end();
    }
	
}
