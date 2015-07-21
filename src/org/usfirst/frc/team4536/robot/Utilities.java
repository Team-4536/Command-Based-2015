package org.usfirst.frc.team4536.robot;
import java.lang.Math;
import edu.wpi.first.wpilibj.Timer;

public class Utilities {
	
	
	/*-----------------------------------------------------variables--------------------------------------------*/
	
	/*-----Cycle Time-----*/
	private static double currentTime, prevTime = 0.0;
	public static double cycleTime = 0.0;
	
	/*-----AccelerationLimit-----*/
	private static double prevDriveTrainThrottle, prevElevatorThrottle, throttleDiff, accelerationLimit = 0.0;
	public static double finalThrottle = 0.0;
	
	/*------------------------------------------------------methods---------------------------------------------*/
	
	public static Timer timer = new Timer();
	
	/**
	 * @ author Liam and Stepan
	 * @param input value to be limited.
	 * @param lowerBound minimum value input will be no greater than.
	 * @param upperBound maximum value input will be no less than.
	 * @return value after being constrained by upper and lower bounds.
	 */
	public static double limit(double input, double lowerBound, double upperBound) {
		
		if (input < lowerBound) 
			return lowerBound;
		else if (input > upperBound)
			return upperBound;
		else 
			return input;
	}
	
	/**
	 * @author Liam and Stepan
	 * @param input value to be limited.
	 * @param bound constrains the input value with a maximum value of bound and a minimum value of negative bound.
	 * @return value after being constrained by upper and lower bounds.
	 */
	public static double limit(double input, double bound) {
		
		return limit(input, -bound, bound);
	}
	
	/**
	 * @author Liam and Stepan
	 * @param input value to be limited
	 * @return value after being constrained with a maximum value of 1 and a minimum value of -1.
	 */
	public static double limit(double input) {
		
		return limit(input, 1);
	}
	
	/**
	 * @author Stepan
	 * @param input value to be raised to a power (or curved)
	 * @param curve exponent that the method uses to curve the input (curves smaller than 0.1 are invalid)
	 * @return input value raised an exponent (curved)
	 */
	public static double speedCurve(double input, double curve) {
		//negative curves cause asymptotes, leading to overflow errors. Curves smaller than 0.1 aren't very useful.
		double adjustedCurve = limit(curve, 0.1, Double.MAX_VALUE);
		
		//if the input is negative, outputs can be undefined and positive for certain curves
		if(input < 0) {
			return -Math.pow(Math.abs(input), adjustedCurve);
		}
		
		return Math.pow(input, adjustedCurve);
	}

	/**
	 * @author Mairead
	 * @param input value that needs to be of a certain magnitude
	 * @param deadZone magnitude the input should be greater than
	 * @return input if greater than magnitude, 0 if not
	 */
	public static double deadZone(double input, double deadZone){
	
		if((input > -deadZone) && (input < deadZone)) 
			return 0;
		else
			return input;
	}
	
	/**
	 *@ author Liam
	 * Starts the timer.
	 */
	public static void startTimer() {
		
		timer.start();
	}
	
	/**
	 * @author Liam
	 * Resets the timer by making the start time the current time so all time values are then compared to that new more recent time.
	 */
	public static void resetTimer() {
		
		timer.reset();
	}
	
	/**
	 * @author Liam
	 * Stops the timer.
	 */
	public static void stopTimer() {
		
		timer.stop();
	}
	
	/**
	 * @author Liam
	 * @return the current time of the timer in seconds
	 */
	public static double getTime() {
		
		return timer.get();
	}
	
	/**
	 * @author Liam
	 * @return the cycle time of our code is returned 
	 */
	public static double getCycleTime() {
		
		currentTime = Utilities.getTime();
		cycleTime = currentTime - prevTime;
		prevTime = currentTime;
		
		return cycleTime;
	}
	
	/**
	 * @author Liam
	 * @param throttle - the throttle of an object.
	 * @param prevThrottle - Throttle Value from previous cycle of code.
	 * @param fullSpeedTime - The amount of time it will take the throttle to reach full speed [-1, 1]. It is a double 
	 * @return finalThrottle - returns the throttle adjusted to be within the bounds of the acceleration limit.
	 */
	public static double accelLimit(double throttle, double prevThrottle, double fullSpeedTime) {
		
		finalThrottle = throttle;
		
		throttleDiff = throttle - prevThrottle;
		accelerationLimit = getCycleTime() / fullSpeedTime;
		
		if (throttleDiff > accelerationLimit)
			finalThrottle = prevThrottle + accelerationLimit;
		else if (throttleDiff < -accelerationLimit)
			finalThrottle = prevThrottle - accelerationLimit;
		
		return finalThrottle;
	}
}
