package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearPickupCmd extends Command {
	double scale = 0.25;

    public GearPickupCmd() {
    	requires(Robot.gearpickup);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getPOVup() == 0) {
    		Robot.gearpickup.intakePower = 0.75;
    	}
    	if(Robot.oi.getPOVdown() == 4) {
    		Robot.gearpickup.intakePower = -0.75;
    	}
    	Robot.gearpickup.Intake();
    	
    	Robot.gearpickup.Window(Robot.oi.getJoystick2Y() * scale);
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
