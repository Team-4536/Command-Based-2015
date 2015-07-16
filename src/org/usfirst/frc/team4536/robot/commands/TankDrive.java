package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4536.robot.commands.CommandBase;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Robot;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 * @author Liam
 * Tank Drive drives by running each motor on a separate input.
 */
public class TankDrive extends CommandBase {

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
		DriveTrain.prevThrottleL = 0.0;
		DriveTrain.prevThrottleR = 0.0;
		DriveTrain.prevThrottleX = 0.0;
		DriveTrain.prevThrottleY = 0.0;
		
		driveTrain.tankDrive(0.0, 0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.tankDrive(Utilities.speedCurve(-OI.mainStick.getY(), Constants.SPEED_CURVE), Utilities.speedCurve(-OI.secondaryStick.getY(), Constants.SPEED_CURVE));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveTrain.tankDrive(0, 0);
    }
}
