package org.usfirst.frc.team4536.robot;

public class UglyRectangle {

	public double distance;
	public double timeNeeded;
	public double throttle;
	public double desiredMaxVelocity;

	public UglyRectangle(double distance, double desiredMaxVelocity) {
		// distance is in feet
		// desiredMaxVelocity is in feet per second

		this.desiredMaxVelocity = desiredMaxVelocity;
		this.distance = distance;
		throttle = desiredMaxVelocity / Constants.DRIVE_TRAIN_MAX_VELOCITY; // Converts the desired velocity into a throttle value to send to the motors
		timeNeeded = distance / desiredMaxVelocity; // Uses physics to calculate the time needed

	}

	public double throttle(double time) {
		// Returns the throttle value if the desired time has not passed

		if (time > 0 && time < timeNeeded) {
			return throttle;
		}

		else
			return 0;
	}

	public double idealRate(double time) {
		//For interfacing, returns the velocity the robot SHOULD be at
		if (time > 0 && time < timeNeeded) {
			return desiredMaxVelocity;
		} else
			return 0;
	}

	public double idealDistance(double time) {
		//For interfacing, returns the distance the robot SHOULD be at
		if (time > 0 && time < timeNeeded) {
			return desiredMaxVelocity * time;
		} else
			return distance;
	}

}
