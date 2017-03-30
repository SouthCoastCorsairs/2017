package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;
import org.usfirst.frc.team5846.robot.subsystems.RopeClimber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RopeClimberCmd extends Command {

    public RopeClimberCmd() {
        requires(Robot.ropeclimber);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.ropeclimber.Climb(Robot.oi.getButton1());
    	
    }
    
   

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.climbButton5()) {
    		Robot.ropeclimber.climbSpeed = -0.10;
    	}
    	
    	if (Robot.oi.climbButton6()) {
    		Robot.ropeclimber.climbSpeed = -0.1;
    	}
    	
    	if (Robot.oi.climbButton3()) {
    		Robot.ropeclimber.climbSpeed = -0.85;
    	}
    	
    	if (Robot.oi.climbButton4()) {
    		Robot.ropeclimber.climbSpeed = -0.90;
    	}
    	
    	if (Robot.oi.getButton2()) {
    		Robot.ropeclimber.climbSpeed = 80;
    	}
    	Robot.ropeclimber.climbTheRope();
    	
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
