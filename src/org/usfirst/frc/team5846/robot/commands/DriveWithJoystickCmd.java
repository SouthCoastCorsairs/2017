package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
	
public class DriveWithJoystickCmd extends Command {
//This is the speed of the robot
    public DriveWithJoystickCmd() {
       requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.oi.getButton6()) { //100%
    		Robot.drivetrain.speed = 1;
    	}
    	
    	if (Robot.oi.getButton5()) { //Quarter speed
    		Robot.drivetrain.speed = 0.25;
    	}
    	
    	if (Robot.oi.getButton4()) { //75%
    		Robot.drivetrain.speed = .75;
    		
    	}
    	
    	if (Robot.oi.getButton3()) {
    		Robot.drivetrain.speed = 0.50;
    	}
    	
    	if(Robot.oi.reverseButton()) {
    		Robot.drivetrain.speed = -0.60;
    	}
    	Robot.drivetrain.drive((Robot.oi.getJoystickX()*(Robot.drivetrain.speed)), (Robot.oi.getJoystickY()*(Robot.drivetrain.speed)));
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
