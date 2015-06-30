package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team4536.robot.RobotMap;


public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon elevatorTalon;
	Gyro 

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    
    	elevatorTalon = new Talon(RobotMap.ELEVATOR_MOTOR);
    }
}

