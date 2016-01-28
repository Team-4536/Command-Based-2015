package org.usfirst.frc.team4536.robot;


public class UglyRectangle {
	
	public double distance;
	public double timeNeeded;
	public double throttle;
	public double desiredMaxVelocity;

	
	public UglyRectangle(double distance, double desiredMaxVelocity){
	//desiredMaxVelocity is in feet per second
	//distance is in feet
	
	this.desiredMaxVelocity = desiredMaxVelocity;
	this.distance = distance;
	throttle = desiredMaxVelocity/Constants.DRIVE_TRAIN_MAX_VELOCITY;
	timeNeeded = distance/desiredMaxVelocity;
	
	}
	
	public double throttle(double time) {
		
		if(time > 0 && time < timeNeeded){		
			return throttle;			
		}
		
		else 
			return 0;
	}
	
	public double idealRate(double time){
		if(time > 0 && time < timeNeeded){		
			return desiredMaxVelocity;			
		}
		else 
			return 0;
	}

	public double idealDistance(double time){
		if(time > 0 && time < timeNeeded){		
			return desiredMaxVelocity*time;	
		}
		else 
			return distance;
	}
	
	
	
	
}
