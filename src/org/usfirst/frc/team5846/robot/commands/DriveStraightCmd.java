package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightCmd extends Command {
	
	private double Distance;
	private double CurrentHeading;
	private double LeftSpeed;
	private double RightSpeed;
	private double HeadingError;

    public DriveStraightCmd(double Distance) {
    	requires(Robot.drivetrain);
    	this.Distance = Distance;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetDriveEncoders();
    	Robot.drivetrain.ahrs.reset();
    	LeftSpeed = 0.2; //Speed of the left side
    	RightSpeed = 0.2; //Speed of the right side
    	CurrentHeading = Robot.drivetrain.getAngle();
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
    	//if (Robot.drivetrain.driveEncoder.getDistance() > (Distance + 3)) {
    	//	Robot.drivetrain.tankDrive(-RightSpeed, LeftSpeed);
    	//}
    	//else {
    		Robot.drivetrain.tankDrive(LeftSpeed, -RightSpeed);
    	//}
    	//Robot.drivetrain.tankDrive(LeftSpeed, -RightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return Robot.drivetrain.isAtDistance(Distance);
    	return Robot.drivetrain.isAtDistance(Distance); 
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.drivetrain.slowDown();
    	Robot.drivetrain.stopTank();
    	//Robot.drivetrain.turnAngleAdditional(-(Robot.drivetrain.getAngle()));
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
