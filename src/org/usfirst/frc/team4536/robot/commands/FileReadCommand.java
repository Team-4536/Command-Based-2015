package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.FileRead;

import java.io.IOException;

/**
 *@author Liam
 *The following link was used as we were learning to write to and read from text documents.
 *{@link}http://www.homeandlearn.co.uk/java/write_to_textfile.html
 * Command for reading from text files
 */
public class FileReadCommand extends CommandBase {
	
    public FileReadCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
        try {
            FileRead file = new FileRead(Constants.textFileName);
            String[] aryLines = file.openFile();
            int i;
            
            for (i = 0; i < aryLines.length; i++) {
              
              System.out.println(aryLines[i]);
            }
          }
          catch (IOException e) {
            
            System.out.println("I cannot read the file master programmer.");
          }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
