package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoPocketCmd extends Command {
	
	private Timer pocketTimer = new Timer();
	private double time;

    public AutoPocketCmd(double time) {
    	requires(Robot.pocketopener);
    	this.time = time;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pocketTimer.start();
    	Robot.pocketopener.Open(-0.25);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pocketTimer.get() > this.time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pocketopener.stop2();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
