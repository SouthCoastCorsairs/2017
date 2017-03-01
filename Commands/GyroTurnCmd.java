package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurnCmd extends Command {

    double Angle;
    double startAngle;
    double target;
    double speed;
    
	public GyroTurnCmd(double Angle) {
		Robot.drivetrain.ahrs.reset();
    	requires(Robot.drivetrain);
    	this.Angle = Angle;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	speed =	Robot.drivetrain.turnAngleAdditional(this.Angle);
    	
    	Robot.drivetrain.setTurnSpeed(speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.drivetrain.isAtTurnTarget(this.Angle);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
