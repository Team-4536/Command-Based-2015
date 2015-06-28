package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon leftTalon;
	Talon rightTalon;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	leftTalon = new Talon(RobotMap.LEFT_MOTOR);
    	rightTalon = new Talon(RobotMap.RIGHT_MOTOR);
    }
    
    /*
     * @ author: Liam and Stepan
     * @ param leftThrottle - The throttle input into the left motor
     * @ param rightTHrottle - The throttle input into the right motor
     */
    public void tankDrive(double leftThrottle, double rightThrottle) {
    	
    	leftTalon.set(leftThrottle);
    	rightTalon.set(-rightThrottle);
    }
    
    public void arcadeDrive(double forwardThrottle, double turnThrottle) {
    	
    	double leftTalonThrottle = forwardThrottle + turnThrottle;
    	double rightTalonThrottle = -forwardThrottle + turnThrottle;
    }
}