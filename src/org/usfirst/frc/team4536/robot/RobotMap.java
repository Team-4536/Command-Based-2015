package org.usfirst.frc.team4536.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	/*-------------------------------------Motors------------------------------------*/	
    public static final int LEFT_MOTOR = 1;
    public static final int RIGHT_MOTOR = 0;
    public static final int ELEVATOR_MOTOR = 2;
    
    public static final int ELEVATOR_ENCODER_A_CHANNEL = 5;
    public static final int ELEVATOR_ENCODER_B_CHANNEL = 6;
    
    public static final int TOP_LIMIT_SWITCH =3;
    public static final int MIDDLE_LIMIT_SWITCH =1;
    public static final int BOTTOM_LIMIT_SWITCH =4;
    
    public static final int SECONDARY_STICK = 1; 
}