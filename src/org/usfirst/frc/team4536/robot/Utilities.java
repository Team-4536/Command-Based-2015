package org.usfirst.frc.team4536.robot;
import java.lang.Math;

public class Utilities {
	
	/**
	 * @ author Liam and Stepan
	 * @param input value to be limited.
	 * @param lowerBound minimum value input will be no greater than.
	 * @param upperBound maximum value input will be no less than.
	 * @return value after being constrained by upper and lower bounds.
	 */
	public static double limit(double input , double lowerBound, double upperBound) {
		
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
	
	
}