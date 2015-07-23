package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	/*---------------------------------------------Variables--------------------------*/
	
	/*-----Previous Values-----*/
	public static double prevThrottleY = 0.0, prevThrottleX = 0.0, prevThrottleL = 0.0, prevThrottleR = 0.0;
	
	/*---------------------------------------------Objects----------------------------*/
	
	/*-----Talons-----*/
	Talon leftTalon;
	Talon rightTalon;
	
	/*-----Timers----*/
	Timer driveTimer;
	
	/*---------------------------------------------Methods---------------------------*/
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
    	
    }
    
    /**
     * @ author Liam and Stepan
     * @ param leftThrottle - The throttle input into the left motor
     * @ param rightTHrottle - The throttle input into the right motor
     */
    public void tankDrive(double leftThrottle, double rightThrottle) {
    	
    	leftTalon.set(leftThrottle);
    	rightTalon.set(-rightThrottle);
    	
    	prevThrottleL = leftThrottle;
    	prevThrottleR = rightThrottle;
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
    	
    	prevThrottleY = forwardThrottle;
    	prevThrottleX = turnThrottle;
    }
    
    public static double getPrevThrottleY() {
    	
    	return prevThrottleY;
    }
    
    public static double getPrevThrottleX() {
    	
    	return prevThrottleX;
    }
    
    public static double getPrevThrottleL() {
    	
    	return prevThrottleL;
    }
    
    public static double getPrevThrottleR() {
    	
    	return prevThrottleR;
    }
}