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
    	// might need to convert +- 180 to 0-360!!!!!!!!!!!!!
    	double desired = this.Angle;
    	double current = Robot.drivetrain.ahrs.getAngle();
    	desired = (desired > 0 ? desired : (2 * Math.PI + desired)) * 360 / (2 * Math.PI); //comment out if desired is in 0-360 format
    	current = (current > 0 ? current : (2 * Math.PI + current)) * 360 / (2 * Math.PI); //comment out if desired is in 0-360 format
    	
    	// 0-360 will help us determine if we are right or left of angle
    	double error = desired - current;
    	double power = Robot.drivetrain.convertAngleToTankDrive(error);

    	// turn left
    	if(error > 0.0){
    		Robot.drivetrain.tankDrive(-power, -power);

    	}
    	// turn right
    	else if(error < 0.0){
    		Robot.drivetrain.tankDrive(power, power);

    	}
    	// stop turning
    	else{
    		
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
