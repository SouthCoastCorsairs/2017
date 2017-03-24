package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistanceCmd extends Command {
	
	private double distance;
	
	public DriveDistanceCmd(double distance) {
         requires(Robot.drivetrain);
         this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.drivetrain.driveDistancePID.setSetpoint(this.distance);
    	//Robot.drivetrain.driveDistancePID.setAbsoluteTolerance(2.0);
    	//Robot.drivetrain.driveDistancePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
   protected boolean isFinished() {
    	return true;
	   //return Robot.drivetrain.driveDistancePID.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
