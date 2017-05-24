package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDdrive extends Command {
	private double Angle;
	private double Difference;

    public PIDdrive(double Angle) {
    	requires(Robot.drivetrain);
    	this.Angle = Angle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.ahrs.reset();
    	Robot.drivetrain.driveEncoder.reset();
    	Robot.drivetrain.driveEncoderLeft.reset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Difference = this.Angle - Robot.drivetrain.ahrs.getAngle();
    	
    	double Power = Robot.drivetrain.convertAngleToTankDrive(Difference);
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
