package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class RunCompressor extends CommandBase {
	
	/**
	 * @author Stepan
	 */
	public RunCompressor() {
		requires(compSub);
	}
	
	/**
	 * @author Stepan
	 */
	protected void initialize() {
		compSub.startComp();
    }
	
	/**
	 * @author Stepan
	 */
	protected void execute() {

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
    	compSub.stopComp();
    }
    
    /**
	 * @author Stepan
	 */
    protected void interrupted() {
    	compSub.stopComp();
    }
}
