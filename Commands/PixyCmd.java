package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;
import org.usfirst.frc.team5846.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PixyCmd extends Command {
	
	double speed;
	double scale = 0.005;
	double output;

    public PixyCmd() {
    	
    	requires(Robot.drivetrain);
    	requires(Robot.vision);
    	requires(Robot.pid);
    	
    	Robot.pid.setPID(0.3, 0.02, 0);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.pid.setOutputLimits(0, 0.7);
    	Robot.pid.setSetpointRange(5);
    	output = Robot.pid.getOutput(Vision.xPosition, 160);
    	
    	
    	if(Vision.xPosition > 170){
    		speed = (Vision.xPosition - 170) * scale;
    		Robot.drivetrain.tankDrive((-speed*0.25), (-speed*0.25));
    	}else if(Vision.xPosition < 150){
    		speed = (150 - Vision.xPosition) * scale;
    		Robot.drivetrain.tankDrive((speed*0.25), (speed*0.25));
    	}else{
    		Robot.drivetrain.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Vision.xPosition < 170  && Vision.xPosition > 150) {
        	return true;
        }
        else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
