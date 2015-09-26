package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.commands.CommandBase;

/**
 *
 */
public class RecyclingContainerToFeederStationAutonomous extends CommandGroup {
    
    public  RecyclingContainerToFeederStationAutonomous() {
    	

    	CommandBase.driveTrain.setOutputRange(-0.2, 0.2);
    	
    	addSequential(new DriveElevatorToHeight(48, .75));
    	addSequential(new TurnToGroup(-45));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
