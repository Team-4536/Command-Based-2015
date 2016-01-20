package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class PIDDriveTrain extends PIDSubsystem {
	
	//tank drive previous throttles
	public static double prevLeftThrottle = 0.0, prevRightThrottle = 0.0;
	
	//arcade drive previous throttles
	public static double prevForwardThrottle = 0.0, prevTurnThrottle = 0.0;
	
	Talon leftTalon;
	Talon rightTalon;
	
	Timer driveTimer;
	AnalogGyro gyro;
	Encoder encoder;
	double angle;
    
    // Initialize your subsystem here
    public PIDDriveTrain(int leftTalonChannel, int rightTalonChannel, int gyroChannel,
    						int motorEncoderAChannel, int motorEncoderBChannel) {   	
    	super("PIDDrive", 1 , 0, 0);
    	
    	this.setAbsoluteTolerance(1);
		
		leftTalon = new Talon(leftTalonChannel);
		rightTalon = new Talon(rightTalonChannel);
		gyro = new AnalogGyro(gyroChannel);
		encoder = new Encoder(motorEncoderAChannel, motorEncoderBChannel);
		
    	leftTalon.set(0.0);
    	rightTalon.set(0.0);
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return (gyro.getAngle());
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	 
    	 rightTalon.set(output);
		 leftTalon.set(output);
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
    
    public void gyroReset(){
    	this.gyro.reset();
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
    
    public double gyroAngle(){
    	
    	return gyro.getAngle();
    	
    }
    
    public double gyroAngleRate(){
    	return gyro.getRate();
    }
    
    public void setProportionality(double proportionalValue) {
    	
    	this.getPIDController().setPID(proportionalValue, 0, 0);
    }
    
    public void encoderReset(){
    	this.encoder.reset();
    }
    
    public double getDistance(){
    	return this.encoder.getDistance();
    }
    
    public double getEncoderRate(){
    	return this.encoder.getRate();
    }

}
