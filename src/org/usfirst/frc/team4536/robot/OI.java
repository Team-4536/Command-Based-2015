package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team4536.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4536.robot.commands.ExampleCommand;
import org.usfirst.frc.team4536.robot.commands.DriveElevatorWithStick;
import org.usfirst.frc.team4536.robot.commands.DriveElevatorToHeight;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//Joysticks
	public static Joystick mainStick;
	public static Joystick secondaryStick;
	
	//Pneumatics
	public static Button platformToggleButton;
	public static Button canburglerToggleButton;
	
	//Elevator
	public static Button driveElevatorWithStickButton;
	public static Button elevatorToHeight50Button;
	public static Button elevatorToHeight20Button;
	public static Button elevatorToHeight0Button;
	public static Button driveAt1;
	public static Button driveAt2;
	public static Button driveAt3;
	public static Button driveAt4;
	public static Button driveAt5;
	
	public OI() {
		
		/*----------------initializations------------------*/
		
		/*-----Joysticks-----*/
		mainStick = new Joystick(RobotMap.MAIN_STICK);
		secondaryStick = new Joystick(RobotMap.SECONDARY_STICK);
		
		/*-----Pneumatics-----*/
		platformToggleButton = new JoystickButton(mainStick, 2);
		canburglerToggleButton = new JoystickButton(mainStick, 3);
		
		/*-----Elevator-----*/
		driveElevatorWithStickButton = new JoystickButton(secondaryStick, 6);
		elevatorToHeight50Button = new JoystickButton(secondaryStick, 3);
		elevatorToHeight20Button = new JoystickButton(secondaryStick, 4);
		elevatorToHeight0Button = new JoystickButton(secondaryStick, 10);
		driveAt1 = new JoystickButton(mainStick, 7);
		
		
		/*-------------------actions------------------*/
		
		/*-----Elevator-----*/
		driveElevatorWithStickButton.whenPressed(new DriveElevatorWithStick());
		elevatorToHeight50Button.whenPressed(new DriveElevatorToHeight(50));
		elevatorToHeight20Button.whenPressed(new DriveElevatorToHeight(20));
		elevatorToHeight0Button.whenPressed(new DriveElevatorToHeight(0));
		driveAt1.whenPressed(new DriveAtVelocity(0.5));
		
		/*-----Pneumatics-----*/
		platformToggleButton.whenPressed(new TogglePlatform());
		canburglerToggleButton.whenPressed(new ToggleCanburgler());
	}
	

	
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

