package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;

public class TogglePlatform extends CommandBase {
	
	/**
	 * @author Stepan
	 */
	public TogglePlatform() {
		requires(platform);
	}

	protected void initialize() {
		
		if(elevator.getCurrentHeight() > Constants.PLATFORM_TOGGLE_HEIGHT_LIMIT) {
			
			platform.flip();
		}
		else if (platform.isExtended()) {
			
			platform.flip();
		}
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