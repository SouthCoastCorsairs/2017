package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
	
public class DriveWithJoystickCmd extends Command {
	double speed = 1;
//This is the speed of the robot
    public DriveWithJoystickCmd() {
       requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.oi.getButton6()) { //Half speed
    		speed = 0.75;
    	}
    	
    	if (Robot.oi.getButton5()) { //Quarter speed
    		speed = 0.25;
    	}
    	
    	if (Robot.oi.getButton4()) { //Full speed
    		speed = 1;
    		//Makes robot go into HYPERDRIVE!!!!!!
    	}
    	
    	if (Robot.oi.reverseButton()) {
    		speed = -0.25;
    	}
    	
    	if (Robot.oi.getButton3()) {
    		speed = 0.50;
    	}
    	Robot.drivetrain.drive((Robot.oi.getJoystickX()*speed), (Robot.oi.getJoystickY()*speed));
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
