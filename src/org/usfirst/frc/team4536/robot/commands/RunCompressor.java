package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class RunCompressor extends CommandBase {
	
	public RunCompressor() {
		requires(compSub);
		compSub.startComp();
	}
	
	protected void execute() {

    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	compSub.stopComp();
    }
    
    protected void interrupted() {
    	compSub.stopComp();
    }
}
