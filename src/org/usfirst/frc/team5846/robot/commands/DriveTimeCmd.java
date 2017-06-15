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
	private double LeftSpeed;
	private double RightSpeed;
	private double CurrentHeading;
	private double HeadingError;

    public DriveTimeCmd(double time) {
        requires(Robot.drivetrain);
        this.time = time;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.ahrs.reset();
    	LeftSpeed = 0.2; //Speed of the left side
    	RightSpeed = 0.2; //Speed of the right side
    	CurrentHeading = Robot.drivetrain.getAngle();
    	timer.start();
    	    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	HeadingError = CurrentHeading - Robot.drivetrain.getAngle();
    	if (HeadingError > 1) {
    		LeftSpeed = 0.3; //the speed for error correction (drifting) RAISE THIS IF IT DRIFTS
    	}
    	else if (HeadingError < -1) {
    		RightSpeed = 0.3; //Error correction for right side  RAISE THIS IF IT DRIFTS
    	}
    	else {
    		LeftSpeed = RightSpeed = 0.2; 
    	}
    	
    	Robot.drivetrain.tankDrive(LeftSpeed, -RightSpeed);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > this.time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stopTank();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
