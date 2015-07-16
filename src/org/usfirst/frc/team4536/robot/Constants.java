package org.usfirst.frc.team4536.robot;

public class Constants {

	/*---------------------------------------Drive Train--------------------------------*/
	
	public static final double SPEED_CURVE = 2;
	
	/*---------------------------------------Joystick-----------------------------------*/
	
	public static final double DEAD_ZONE = 0.05;
	
	/*-------------------------------------Elevator Constants-----------------------------------*/    
   	public static final double ELEVATOR_PROPORTIONALITY_CONSTANT = .5; //Units of throttle/inch
   	public static final double TICKS_PER_INCHES = 247.7; //Converts encoder ticks to measurable inches
   	
   	public static final double TOP_LIMIT_SWITCH_HEIGHT = 48;
   	public static final double MIDDLE_LIMIT_SWITCH_HEIGHT = 8;
   	public static final double BOTTOM_LIMIT_SWITCH_HEIGHT = -0.5;
   	
   	public static final double HEIGHT_FOR_ONE_TOTE = 12;
   	public static final double HEIGHT_FOR_TOP_OF_FEEDER_STATION = 32;
   	public static final double HEIGHT_FOR_BOTTOM_OF_FEEDER_STATION = 10;
   	public static final double HEIGHT_FOR_SCORING_PLATFORM = 5;
   	public static final double HEIGHT_FOR_RECYCLING_CONTAINER = 14.5;
   	
   	
	
}
