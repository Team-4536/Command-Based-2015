package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.commands.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain extends Subsystem {

	//tank drive previous throttles
	public static double prevLeftThrottle = 0.0, prevRightThrottle = 0.0;
	
	//arcade drive previous throttles
	public static double prevForwardThrottle = 0.0, prevTurnThrottle = 0.0;
	
	Talon leftTalon;
	Talon rightTalon;
	
	Timer driveTimer;
	
	/**
	 * @author Liam
	 * @param leftTalonChannel - The PWM channel of the left talon of the drive train
	 * @param rightTalonChannel - THe PWM channel of the right talon of the drive train
	 */
	public DriveTrain(int leftTalonChannel, int rightTalonChannel) {
		
		leftTalon = new Talon(leftTalonChannel);
		rightTalon = new Talon(rightTalonChannel);
		
    	leftTalon.set(0.0);
    	rightTalon.set(0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand())
    	setDefaultCommand(new Drive());
    }
    
    /**
     * @ author Liam and Stepan
     * @ param leftThrottle - The throttle input into the left motor
     * @ param rightTHrottle - The throttle input into the right motor
     */
    public void tankDrive(double leftThrottle, double rightThrottle) {
    	
    	leftTalon.set(leftThrottle);
    	rightTalon.set(-rightThrottle);
    	
    	prevLeftThrottle = leftThrottle;
    	prevRightThrottle = rightThrottle;
    }
    
    /**
     * @author Liam and Stepan
     * @param forwardThrottle - Throttle for forward motion of the drivetrain (+ forward, - backwards) 
     * @param turnThrottle - Throttle for horizontal motion of the drivetrain (+ right, - left)
     */
    public void arcadeDrive(double forwardThrottle, double turnThrottle) {
    	
    	double leftTalonThrottle = forwardThrottle + turnThrottle;
    	double rightTalonThrottle = -forwardThrottle + turnThrottle;
    	
    	leftTalon.set(leftTalonThrottle);
    	rightTalon.set(rightTalonThrottle);
    	
    	prevForwardThrottle = forwardThrottle;
    	prevTurnThrottle = turnThrottle;
    }
    
    public static double getPrevForwardThrottle() {
    	
    	return prevForwardThrottle;
    }
    
    public static double getPrevTurnThrottle() {
    	
    	return prevTurnThrottle;
    }
    
    public static double getPrevLeftThrottle() {
    	
    	return prevLeftThrottle;
    }
    
    public static double getPrevRightThrottle() {
    	
    	return prevRightThrottle;
    }
    
    /**
     * @author Liam
     * @return Returns the current of the left side of the drive train
     */
    public static double getLeftCurrent() {
    	
    	return (Utilities.getCurrent(RobotMap.DRIVE_TRAIN_LEFT_PDP[0])
    			+ Utilities.getCurrent(RobotMap.DRIVE_TRAIN_LEFT_PDP[1]));
    }
    
    /**
     * @author Liam
     * @return Returns the current of the right side of the robot
     */
    public static double getRightCurrent() {
    	
    	return (Utilities.getCurrent(RobotMap.DRIVE_TRAIN_RIGHT_PDP[0])
    			+ Utilities.getCurrent(RobotMap.DRIVE_TRAIN_RIGHT_PDP[1]));
    }
    
    /**
     * @author Liam
     * @return Returns the current of the whole drive train subsystem
     */
    public static double getCurrent() {
    	
    	return getRightCurrent() + getLeftCurrent();
    }
}