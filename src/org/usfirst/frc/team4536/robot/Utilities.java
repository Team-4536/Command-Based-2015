package org.usfirst.frc.team4536.robot;
import java.lang.Math;

public class Utilities {
	
	/**
	 * @ author Liam and Stepan
	 * @param input value to be limited.
	 * @param lowerBound minimum value input will be no greater than. And Baller Gs
	 * @param upperBound maximum value input will be no less than.
	 * @return value after being constrained by upper and lower bounds.
	 */
	public static double limit(double input , double lowerBound, double upperBound) {
		
		if (input < lowerBound)
			input = lowerBound;
		
		else if (input > upperBound)
			input = upperBound;
		
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
	 * 
	 * @param input input value to be raised to a power. Sign (+, -) will be maintained.
	 * @param curve exponent value the input will be raised to.
	 * @return input value raised to the curve with its sign (+, -) maintained.
	 */
	public static double speedCurve(double input, double curve) {
		
		if (input < 0)
			return -1 * Math.abs(Math.pow(input, limit(Math.abs(curve), 0.1, Double.MAX_VALUE)));
		
		return limit(Math.pow(input, limit(Math.abs(curve), 0.1, Double.MAX_VALUE)));
	}
	
}