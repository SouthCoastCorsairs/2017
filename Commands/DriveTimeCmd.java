package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */


public class DriveTimeCmd extends Command {
	
	private Timer timer = new Timer();
	private double time;

    public DriveTimeCmd(double time) {
        requires(Robot.drivetrain);
        this.time = time;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    	    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(0, -0.25);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > this.time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
